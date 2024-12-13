package com.mavenir.vmp.mailbox;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.common.base.Joiner;
import com.mavenir.vmp.config.EnvironmentProperties;
import com.mavenir.vmp.mailbox.model.*;
import com.mavenir.vmp.mailbox.template.VmpTemplate;
import com.mavenir.vmp.mailbox.template.VmpTemplatesBasic;
import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.util.Base64Util;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.Arrays;
import java.util.List;

/**
 * The Class MailboxService.
 */
@Service
public class MailboxService {

	/** The Constant MSISDN_OFFSET. */
	private static final int MSISDN_OFFSET = 4;

	private final Logger logger = LoggerFactory.getLogger(MailboxService.class);
	
	private final Logger securityLogger = LoggerFactory.getLogger("security");

	/** The conn config. */
	@Autowired
	private EnvironmentProperties environment;

	/** The rest template. */
	@Autowired
	private RestTemplate restTemplate;

	/** The mapper. */
	@Autowired
	private XmlMapper mapper;

	/**
	 * Query.
	 *
	 * @param msisdn the msisdn
	 * @param attributes the list of attributes
	 * @param isOnlyQuery is it just query
	 * @return the mailbox vm
	 */
	public MailboxSearchFullResponse query(String msisdn, List<String> attributes, boolean isOnlyQuery) {
		String requestId = generateRequestId(msisdn);
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userIp = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getRemoteAddr();
		securityLogger.info(Joiner.on(" ").join(user.getUsername(), userIp, "RETRIEVE"));
		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(environment.getCcpsUrl())
				.path(msisdn).queryParam("request_id", requestId).queryParam("user", user.getUsername())
				.queryParam("query", isOnlyQuery);
		if (attributes != null && !attributes.isEmpty()) {
			uriComponentsBuilder.queryParam("attribute_list", attributesToString(attributes));
		}
		URI targetUrl = uriComponentsBuilder.build().toUri();
		ResponseEntity<String> responseEntity = restTemplate.exchange(targetUrl, HttpMethod.GET, authorizationHeader(), String.class);
		MailboxSearchResponse vm = null;
		MailboxResponse response = new MailboxResponse();
		if (checkIsRequestSuccessful(responseEntity, response, msisdn, requestId)) {
			String result = responseEntity.getBody();
			try {
				vm = mapper.readValue(result, MailboxSearchResponse.class);
			} catch (Exception e) {
				// something went wrong, TODO: fix this
			}
			try {
				response = mapper.readValue(result, MailboxResponse.class);
			} catch (Exception e) {
				// something went wrong, TODO: fix this
			}
		}
		return new MailboxSearchFullResponse(vm, response);
	}

	/**
	 * Query.
	 *
	 * @param msisdn the msisdn
	 * @return the mailbox vm
	 */
	public MailboxSearchFullResponse query(String msisdn) {
		return query(msisdn, null, false);
	}

	/**
	 * Query.
	 *
	 * @param msisdn the msisdn
	 * @param isOnlyQuery is it just query
	 * @return the mailbox vm
	 */
	public MailboxSearchFullResponse query(String msisdn, boolean isOnlyQuery) {
		return query(msisdn, null, isOnlyQuery);
	}

	/**
	 * Creates the.
	 *
	 * @param mailbox the mailbox
	 * @return the mailbox response
	 */
	public MailboxResponse create(CreateSubscriberRequest mailbox) {
		String msisdn = mailbox.getMsisdn();
		String requestId = generateRequestId(msisdn);
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userIp = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getRemoteAddr();
		securityLogger.info(Joiner.on(" ").join(user.getUsername(), userIp, "CREATE"));
		URI targetUrl = UriComponentsBuilder.fromUriString(environment.getCcpsUrl()).path("create").queryParam("user", user.getUsername()).build().toUri();
		ResponseEntity<String> responseEntity = restTemplate.exchange(targetUrl, HttpMethod.POST, createHttpEntity(mailbox, requestId), String.class);
		MailboxResponse response = new MailboxResponse();
		if (checkIsRequestSuccessful(responseEntity, response, msisdn, requestId)) {
			String result = responseEntity.getBody();
			try {
				response = mapper.readValue(result, MailboxResponse.class);
			} catch (Exception e) {
				// something went wrong, TODO: fix this
			}
		}
		return response;
	}

	/**
	 * Update.
	 *
	 * @param mailbox the mailbox
	 * @return the mailbox response
	 */
	public MailboxResponse update(EditSubscriberRequest mailbox) {
		String msisdn = mailbox.getMsisdn();
		String requestId = generateRequestId(msisdn);
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userIp = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getRemoteAddr();
		securityLogger.info(Joiner.on(" ").join(user.getUsername(), userIp, "MODIFY"));
		URI targetUrl = UriComponentsBuilder.fromUriString(environment.getCcpsUrl()).path(msisdn).queryParam("user", user.getUsername()).build().toUri();
		ResponseEntity<String> responseEntity = restTemplate.exchange(targetUrl, HttpMethod.PUT, createHttpEntity(mailbox, requestId), String.class);
		MailboxResponse response = new MailboxResponse();
		if (checkIsRequestSuccessful(responseEntity, response, msisdn, requestId)) {
			String result = responseEntity.getBody();
			try {
				response = mapper.readValue(result, MailboxResponse.class);
			} catch (Exception e) {
				// something went wrong, TODO: fix this
			}
		}
		return response;
	}
	
	/**
	 * Delete.
	 *
	 * @param msisdn the msisdn
	 * @return the mailbox response
	 */
	public MailboxResponse delete(String msisdn) {
		return delete(msisdn, null);
	}

	/**
	 * Delete.
	 *
	 * @param msisdn the msisdn
	 * @param classOfService the class of service
	 * @return the mailbox response
	 */
	public MailboxResponse delete(String msisdn, String classOfService) {
		String requestId = generateRequestId(msisdn);
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userIp = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getRemoteAddr();
		securityLogger.info(Joiner.on(" ").join(user.getUsername(), userIp, "DELETE"));
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(environment.getCcpsUrl()).path(msisdn).queryParam("request_id", requestId).queryParam("user", user.getUsername());
		if (classOfService != null) {
			builder.queryParam("class_of_service", classOfService);
		}
		URI targetUrl = builder.build().toUri();
		ResponseEntity<String> responseEntity = restTemplate.exchange(targetUrl, HttpMethod.DELETE, authorizationHeader(), String.class);
		MailboxResponse response = new MailboxResponse();
		if (checkIsRequestSuccessful(responseEntity, response, msisdn, requestId)) {
			String result = responseEntity.getBody();
			try {
				response = mapper.readValue(result, MailboxResponse.class);
			} catch (Exception e) {
				// something went wrong, TODO: fix this
			}
		}
		return response;
	}

	public MailboxResponse merge(MergeRequest request) {
		String requestId = generateRequestId(request.getPriMsisdn());
		request.setRequestId(requestId);
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userIp = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getRemoteAddr();
		securityLogger.info(Joiner.on(" ").join(user.getUsername(), userIp, "MERGE"));
		URI targetUrl = UriComponentsBuilder.fromUriString(environment.getCcpsUrl()).path("merge").queryParam("user", user.getUsername()).build().toUri();
		ResponseEntity<String> responseEntity = restTemplate.exchange(targetUrl, HttpMethod.POST, createHttpEntity(request, requestId), String.class);
		MailboxResponse response = new MailboxResponse();
		if (checkIsRequestSuccessful(responseEntity, response, request.getPriMsisdn(), requestId)) {
			String result = responseEntity.getBody();
			try {
				response = mapper.readValue(result, MailboxResponse.class);
			} catch (Exception e) {
				// something went wrong, TODO: fix this
			}
		}
		return response;
	}

	/**
	 * @param msisdn
	 * @return
	 */
	public MailboxResponse split(String unifiedMailboxId) {
		String requestId = generateRequestId(unifiedMailboxId);
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userIp = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getRemoteAddr();
		securityLogger.info(Joiner.on(" ").join(user.getUsername(), userIp, "SPLIT"));
		URI targetUrl =	UriComponentsBuilder.fromUriString(environment.getCcpsUrl())
				.path("split/" + unifiedMailboxId).queryParam("request_id", requestId).queryParam("user", user.getUsername()).build().toUri();
		ResponseEntity<String> responseEntity = restTemplate.exchange(targetUrl, HttpMethod.DELETE, authorizationHeader(), String.class);
		MailboxResponse response = new MailboxResponse();
		if (checkIsRequestSuccessful(responseEntity, response, unifiedMailboxId, requestId)) {
			String result = responseEntity.getBody();
			try {
				response = mapper.readValue(result, MailboxResponse.class);
			} catch (Exception e) {
				// something went wrong, TODO: fix this
			}
		}
		return response;
	}

	/**
	 * Gets the vmp templates.
	 *
	 * @return the vmp templates
	 */
	public VmpTemplatesBasic getVmpTemplates() {
		URI targetUrl = UriComponentsBuilder.fromUriString(environment.getCcpsUrl()).path("templates").build().toUri();
		ResponseEntity<String> responseEntity = restTemplate.exchange(targetUrl, HttpMethod.GET, authorizationHeader(), String.class);
		VmpTemplatesBasic templates = new VmpTemplatesBasic();
		MailboxResponse mailboxResponse = new MailboxResponse();
		templates.setResponse(mailboxResponse);
		if (checkIsRequestSuccessful(responseEntity, templates.getResponse(), "", "")) {
			String result = responseEntity.getBody();
			try {
				templates = mapper.readValue(result, VmpTemplatesBasic.class);
				mailboxResponse.setStatusCode("01");
				templates.setResponse(mailboxResponse);
			} catch (Exception e) {
				logger.error("Error occured when trying to fetch VMP templates from CCPS", e);
			}
		}
		return templates;
	}

	/**
	 * Gets the vmp template.
	 *
	 * @param templateId the template id
	 * @return the vmp template
	 */
	public VmpTemplate getVmpTemplate(String templateId) {
		URI targetUrl = UriComponentsBuilder.fromUriString(environment.getCcpsUrl()).path("template").
				queryParam("template_id", templateId).build().toUri();
		String result = restTemplate.exchange(targetUrl, HttpMethod.GET, authorizationHeader(), String.class).getBody();
		VmpTemplate response = null;
		try {
			response = mapper.readValue(result, VmpTemplate.class);
		} catch (Exception e) {
			logger.error("Error occured when trying to fetch VMP templates from CCPS", e);
		}
		return response;
	}

	/**
	 * Authorization header.
	 *
	 * @return the http entity
	 */
	private HttpEntity<String> authorizationHeader() {
		HttpHeaders header = new HttpHeaders();
		try {
			header.add("Authorization", "Basic " + Arrays.toString(Base64.encodeBase64(environment.getVmpUser().getBytes("UTF-8"))));
		} catch (UnsupportedEncodingException e) {
			logger.error("Unsupported charset UTF-8 ", e);
		}
		return new HttpEntity<String>("", header);
	}

	/**
	 * Creates the http entity.
	 *
	 * @param entity the entity
	 * @return the http entity
	 */
	private <T extends Requestable> HttpEntity<String> createHttpEntity(T entity, String requestId) {
		entity.setRequestId(requestId);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.APPLICATION_XML_VALUE);
		try {
			headers.add("Authorization", "Basic " + Arrays.toString(Base64.encodeBase64(environment.getVmpUser().getBytes("UTF-8"))));
		} catch (UnsupportedEncodingException e) {
			logger.error("Unsupported charset UTF-8 ", e);
		}
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_XML));
		String xml = "";
		try {
			xml = mapper.writeValueAsString(entity);
		} catch (JsonProcessingException e) {
			// something went wrong, TODO: fix this
		}
		xml = xml.replace("xmlns=\"\"", "xmlns=\"http://vmp.ccps.mavenir.com/\"");
		HttpEntity<String> request = new HttpEntity<String>(xml, headers);
		return request;
	}

	/**
	 * Generate request id.
	 *
	 * @param msisdn the msisdn
	 * @return the string
	 */
	private String generateRequestId(String msisdn) {
		StringBuilder requestId = new StringBuilder();
		DateTime time = DateTime.now();
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyyMMdd-kkmmssSS");
		requestId.append(formatter.print(time));
		requestId.append("-");
		if (msisdn.length() >= MSISDN_OFFSET) {
			requestId.append(msisdn.substring(msisdn.length() - MSISDN_OFFSET, msisdn.length()));
		} else {
			requestId.append(msisdn);
		}
		requestId.append("-123456789");
		return requestId.toString();
	}

	/**
	 * Attributes to string.
	 *
	 * @param attributes the attributes
	 * @return the string
	 */
	private String attributesToString(List<String> attributes) {
		StringBuilder builder = new StringBuilder("");
		for (String attribute : attributes) {
			builder.append(attribute);
			builder.append(",");
		}
		builder.deleteCharAt(builder.length() - 1);
		return builder.toString();
	}

	/**
	 * Check is request successful.
	 *
	 * @param ccpsResponse the ccps response
	 * @param mailboxResponse the mailbox response
	 * @param msisdn the msisdn
	 * @param requestId the request id
	 * @return true, if successful
	 */
	private boolean checkIsRequestSuccessful(ResponseEntity<String> ccpsResponse, MailboxResponse mailboxResponse, String msisdn, String requestId) {
		if (checkIsCcpsUrlReached(ccpsResponse, mailboxResponse, msisdn, requestId) &&
				checkIsCcpsReached(ccpsResponse, mailboxResponse, msisdn, requestId)) {
			return true;
		}
		return false;
	}

	/**
	 * Check is ccps reached.
	 *
	 * @param ccpsResponse the ccps response
	 * @param mailboxResponse the mailbox response
	 * @param msisdn the msisdn
	 * @param requestId the request id
	 * @return true, if successful
	 */
	private boolean checkIsCcpsReached(ResponseEntity<String> ccpsResponse, MailboxResponse mailboxResponse, String msisdn, String requestId) {
		if (ccpsResponse != null && ccpsResponse.getStatusCode() == HttpStatus.NOT_FOUND && ccpsResponse.getBody().equals("404 Not Found")) {
			mailboxResponse.setStatusCode("");
			mailboxResponse.setStatusText("");
			mailboxResponse.setMsisdn(msisdn);
			mailboxResponse.setResponseId(requestId);
			mailboxResponse.setErrorCause("CCPS not reached. Error is: " + ccpsResponse);
			return false;
		}
		return true;
	}

	/**
	 * Check is result not null.
	 *
	 * @param ccpsResponse the ccps response
	 * @param mailboxResponse the mailbox response
	 * @param msisdn the msisdn
	 * @param requestId the request id
	 * @return true, if successful
	 */
	private boolean checkIsCcpsUrlReached(ResponseEntity<String> ccpsResponse, MailboxResponse mailboxResponse, String msisdn, String requestId) {
		if (ccpsResponse != null && ccpsResponse.getStatusCode() == HttpStatus.NOT_FOUND && ccpsResponse.getBody() == null) {
			mailboxResponse.setStatusCode("");
			mailboxResponse.setStatusText("");
			mailboxResponse.setMsisdn(msisdn);
			mailboxResponse.setResponseId(requestId);
			mailboxResponse.setErrorCause("CCPS reached but URL action not found. Please check logs for more information.");
			return false;
		}
		return true;
	}
}
