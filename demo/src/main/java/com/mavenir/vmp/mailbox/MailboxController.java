package com.mavenir.vmp.mailbox;

import com.google.common.base.Joiner;
import com.google.common.base.Strings;
import com.google.common.collect.Iterators;
import com.mavenir.vmp.config.EnvironmentProperties;
import com.mavenir.vmp.core.web.BadRequestException;
import com.mavenir.vmp.external.DropdownElement;
import com.mavenir.vmp.mailbox.model.*;
import com.mavenir.vmp.mailbox.template.VmpTemplate;
import com.mavenir.vmp.mailbox.template.VmpTemplateVM;
import com.mavenir.vmp.mailbox.template.VmpTemplatesBasic;
import com.mavenir.vmp.mailbox.vm.*;
import com.mavenir.vmp.user.Role;
import com.mavenir.vmp.user.UserService;
import com.mavenir.vmp.utils.DropdownUtil;
import com.mavenir.vmp.utils.StringUtil;
import com.mavenir.vmp.utils.TypeConverter;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * The Class MailboxController.
 */
@RestController
@RequestMapping("mailbox")
public class MailboxController {

	private final Logger logger = LoggerFactory.getLogger(MailboxController.class);

	/** The service. */
	@Autowired
	private MailboxService service;

	/** The mapper. */
	@Autowired
	private ModelMapper mapper;

	/** The user service. */
	@Autowired
	private UserService userService;

	/** The environment properties. */
	@Autowired
	private EnvironmentProperties environmentProperties;

	/** The dropdown config. */
	@Autowired
	private EnvironmentProperties environment;
	
	private Iterator<String> urlIter;
	
	@PostConstruct
	public void init() {
		String[] url = environment.getUrl().replace(" ", "").split(",");
		List<String> urlList = Arrays.asList(url);
		urlIter = Iterators.cycle(urlList);
	}

	/**
	 * Creates the.
	 *
	 * @param mailbox the mailbox
	 * @return the mailbox response
	 */
	@PreAuthorize("hasRole('ROLE_ADVANCED')")
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public MailboxResponseVM create(@RequestBody @Valid MailboxCreateVM mailbox) {
		logger.info("----- START - Create subscriber (msisdn = " + mailbox.getMsisdn() + ") -----");
		CreateSubscriberRequest request = mapper.map(mailbox, CreateSubscriberRequest.class);
		MailboxResponse response = service.create(request);
		logMailboxResponse(response, "Create subscriber (msisdn = " + mailbox.getMsisdn() + ")");
		logger.info("----- END - Create subscriber (msisdn = " + mailbox.getMsisdn() + ") -----");
		return mapper.map(response, MailboxResponseVM.class);
	}

	/**
	 * Edits the.
	 *
	 * @param msisdn the msisdn
	 * @return the mailbox edit vm
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "edit/{msisdn}", method = RequestMethod.GET)
	public MailboxEditSearchResponseVM edit(@PathVariable String msisdn) {
		logger.info("START - Find subscriber for edit by msisdn (" + msisdn + ")");
		MailboxSearchFullResponse response = service.query(msisdn);
		logMailboxResponse(response.getResponse(), "Find subscriber for edit by msisdn(" + msisdn + "):");
		MailboxEditVM vm = null;
		if (response != null && response.getMailbox() != null) {
			vm = mapper.map(response.getMailbox(), MailboxEditVM.class);
			if (response.getMailbox().getAttributeList() != null) {
				mapper.map(response.getMailbox().getAttributeList(), vm);
				setDropdownValues(vm, response.getMailbox().getAttributeList());
			}
			vm.setPin(null);
		}
		logger.info("END - Find subscriber for edit by msisdn (" + msisdn + ")");
		return new MailboxEditSearchResponseVM(mapper.map(response.getResponse(), MailboxResponseVM.class), vm);
	}

	/**
	 * Edits the.
	 *
	 * @param mailbox the mailbox
	 * @return the mailbox response
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public MailboxResponseVM edit(@RequestBody @Valid MailboxEditVM mailbox) {
		logger.info("START - Edit subscriber (msisdn = " + mailbox.getMsisdn() + ")");
		EditSubscriberRequest request = null;
		if (userService.hasCurrentRole(Role.ROLE_INTERMEDIATE)) {
			// Simple role, complex logic
			// Get current mailbox from NMS and SPS
			MailboxEditSearchResponseVM currentMailbox = edit(mailbox.getMsisdn());
			// Something went wrong while getting mailbox, abort everything
			if (!Strings.isNullOrEmpty(currentMailbox.getResponseStatus().getErrorCause())) {
				return currentMailbox.getResponseStatus();
			}
			// Map changes that user did to simple mailbox VM
			MailboxEditSimpleVM simpleMailbox = mapper.map(mailbox, MailboxEditSimpleVM.class);
			// Create EditSubscriberRequest based on the current mailbox
			request = mapper.map(currentMailbox.getMailbox(), EditSubscriberRequest.class);
			// Map changes that the user did
			mapper.map(simpleMailbox, request);
			setDropdownValues(request, currentMailbox.getMailbox());
			setDropdownValues(request, simpleMailbox);
		} else {
			request = mapper.map(mailbox, EditSubscriberRequest.class);
			setDropdownValues(request, mailbox);
		}

		MailboxResponse response = service.update(request);
		logMailboxResponse(response, "Edit subscriber (msisdn = " + mailbox.getMsisdn() + ")");
		logger.info("END - Edit subscriber (msisdn = " + mailbox.getMsisdn() + ")");
		return mapper.map(response, MailboxResponseVM.class);
	}

	/**
	 * Edits the.
	 *
	 * @param fieldName the field name
	 * @param fieldValue the field value
	 * @return the string
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "editField", method = RequestMethod.POST)
	public MailboxResponseVM edit(@RequestBody MailboxEditFieldVM vm) {
		logger.info("START - Edit subscriber field (msisdn = " + vm.getMsisdn() + ", field = " + vm.getFieldName() + ")");
		EditSubscriberRequest request = new EditSubscriberRequest();
		request.setMsisdn(vm.getMsisdn());
		request.setNewMsisdn(vm.getNewMsisdn());
		request.setImapPassword(vm.getImapPassword());
		setSingleField(request, vm.getFieldName(), vm.getFieldValue());
		MailboxResponse response = service.update(request);
		logMailboxResponse(response, "Edit subscriber field (msisdn = " + vm.getMsisdn() + ", field = " + vm.getFieldName() + ")");
		logger.info("END - Edit subscriber field (msisdn = " + vm.getMsisdn() + ", field = " + vm.getFieldName() + ")");
		return mapper.map(response, MailboxResponseVM.class);
	}

	/**
	 * Find by msisdn.
	 *
	 * @param msisdn the msisdn
	 * @return the mailbox vm
	 */
	@PreAuthorize("hasAnyRole('ROLE_SIMPLE','ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "findByMsisdn/{msisdn}/{query}", method = RequestMethod.GET)
	public MailboxSearchResponseVM findByMsisdn(@PathVariable String msisdn, @PathVariable boolean query) {
		logger.info("START - Find subscriber by msisdn (" + msisdn + ")");
		MailboxSearchFullResponse response = service.query(msisdn, query);
		logMailboxResponse(response.getResponse(), "Find subscriber by msisdn(" + msisdn + "):");
		MailboxSearchVM vm = null;
		if (response != null && response.getMailbox() != null) {
			vm = mapper.map(response.getMailbox(), MailboxSearchVM.class);
			if (response.getMailbox().getAttributeList() != null) {
				mapper.map(response.getMailbox().getAttributeList(), vm);
				setDropdownValues(vm, response.getMailbox().getAttributeList());
			}
		}
		logger.info("END - Find subscriber by msisdn (" + msisdn + ")");
		return new MailboxSearchResponseVM(mapper.map(response.getResponse(), MailboxResponseVM.class), vm);
	}

	/**
	 * Delete.
	 *
	 * @param msisdn the msisdn
	 * @return the mailbox response
	 */
	@PreAuthorize("hasAnyRole('ROLE_ADVANCED')")
	@RequestMapping(value = "delete/{msisdn}", method = RequestMethod.POST)
	public MailboxResponseVM delete(@PathVariable String msisdn) {
		logger.info("START - Delete subscriber by msisdn (" + msisdn + ")");
		MailboxResponse response = service.delete(msisdn);
		logMailboxResponse(response, "Delete subscriber by msisdn(" + msisdn + "):");
		MailboxResponseVM vm = mapper.map(response, MailboxResponseVM.class);
		return vm;
	}

	/**
	 * Delete.
	 *
	 * @param msisdn the msisdn
	 * @return the mailbox response
	 */
	@PreAuthorize("hasAnyRole('ROLE_ADVANCED')")
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public MailboxResponseVM delete(@RequestBody MailboxSearchVM mailbox) {
		logger.info("START - Delete subscriber by msisdn and COS (" + mailbox.getMsisdn() + ")");
		MailboxResponse response = service.delete(mailbox.getMsisdn(), mailbox.getClassOfService().getValue());
		logMailboxResponse(response, "Delete subscriber by msisdn(" + mailbox.getMsisdn() + "):");
		MailboxResponseVM vm = mapper.map(response, MailboxResponseVM.class);
		return vm;
	}

	/**
	 * Gets the vmp templates.
	 *
	 * @return the vmp templates
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "vmpTemplates", method = RequestMethod.GET)
	public VmpTemplatesBasic getVmpTemplates() {
		logger.info("START - getVmpTemplates");
		VmpTemplatesBasic templates = service.getVmpTemplates();
		return templates;
	}

	/**
	 * Fill mailbox values with values from template.
	 *
	 * @param mailbox the mailbox
	 * @return the template
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "vmpTemplateCreate", method = RequestMethod.POST)
	public MailboxCreateVM getTemplate(@RequestBody MailboxCreateVM mailbox) {
		logger.info("START - getTemplate (" + mailbox + ")");
		VmpTemplate template = service.getVmpTemplate(mailbox.getTemplate());
		MailboxCreateVM vm = (MailboxCreateVM) fillWithTemplate(template, mailbox);
		return vm;
	}

	/**
	 * Gets the template.
	 *
	 * @param mailbox the mailbox
	 * @return the template
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "vmpTemplate/{templateId}", method = RequestMethod.GET)
	public VmpTemplateVM getTemplate(@PathVariable String templateId) {
		VmpTemplate template = service.getVmpTemplate(templateId);
		return fillWithTemplate(template);
	}

	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "isDefaultPasswordAutogenEnabled", method = RequestMethod.GET)
	public boolean isDefaultPasswordAutogenEnabled() {
		return environmentProperties.isAutogenPassDefaultEnabled();
	}

	/**
	 * Generate password.
	 *
	 * @return the string
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "generatePassword", method = RequestMethod.GET)
	public String generatePassword() {
		int minLength = environmentProperties.getAutogenPassMinLength();
		int maxLength = environmentProperties.getAutogenPassMaxLength();
		return StringUtil.generateRandomString(minLength, maxLength, StringUtil.Type.NUMERIC);
	}

	/**
	 * Gets the user levels.
	 *
	 * @return the user levels
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "userLoginLevelValues", method = RequestMethod.GET)
	public List<DropdownElement> getUserLoginLevelValues() {
		return DropdownUtil.parseDropdownValues(environment.getDropdown().getUserLoginLevel());
	}

	/**
	 * Gets the class of service values.
	 *
	 * @return the class of service values
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "classOfServiceValues", method = RequestMethod.GET)
	public List<DropdownElement> getClassOfServiceValues() {
		return DropdownUtil.parseDropdownValues(environment.getDropdown().getClassOfService());
	}
	
	/**
	 * Gets the user credentials.
	 *
	 * @return the user credential values
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "usercredentials", method = RequestMethod.GET)
	public List<DropdownElement> getUserCredentials() {
		return DropdownUtil.parseDropdownValues(environment.getDropdown().getUsercredentials());
	}

	/**
	 * Gets the language values.
	 *
	 * @return the language values
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "languageValues", method = RequestMethod.GET)
	public List<DropdownElement> getLanguageValues() {
		return DropdownUtil.parseDropdownValues(environment.getDropdown().getLanguage());
	}
	
	
	/**
	 * Gets the voicemail importance values.
	 *
	 * @return the voicemail importance values
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "voicemailImportance", method = RequestMethod.GET)
	public List<DropdownElement> getVoicemailImportance() {
		return DropdownUtil.parseDropdownValues(environment.getDropdown().getVoicemailImportance());
	}


	/**
	 * Gets the voicemail sensitivity values.
	 *
	 * @return the voicemail sensitivity values
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "voicemailSensitivity", method = RequestMethod.GET)
	public List<DropdownElement> getVoicemailSensitivity() {
		return DropdownUtil.parseDropdownValues(environment.getDropdown().getVoicemailSensitivity());
	}


	/**
	 * Gets the voicemail content-type values.
	 *
	 * @return the voicemail content-type values
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "voicemailContentType", method = RequestMethod.GET)
	public List<DropdownElement> getVoicemailContentType() {
		return DropdownUtil.parseDropdownValues(environment.getDropdown().getVoicemailContentType());
	}


	/**
	 * Gets the provisioningGUI API values.
	 *
	 * @return the provisioningGUI API values
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "allApis", method = RequestMethod.GET)
	public List<DropdownElement> getAllApis() {
		return DropdownUtil.parseDropdownValues(environment.getDropdown().getAllApis());
	}
		
	/**
	 * Gets the subscriber blocked values.
	 *
	 * @return the subscriberBlocked values
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "subscriberBlockedValues", method = RequestMethod.GET)
	public List<DropdownElement> getSubscriberBlockedValues() {
		return DropdownUtil.parseDropdownValues(environment.getDropdown().getSubscriberBlockedValues());
	}
	
	/**
	 * Gets the Password Suppression values.
	 *
	 * @return the passwordSuppressValues
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "passwordSuppressValues", method = RequestMethod.GET)
	public List<DropdownElement> getPasswordSuppressValuess() {
		return DropdownUtil.parseDropdownValues(environment.getDropdown().getPasswordSuppressValues());
	}
	
	/**
	 * Gets the Play Order values.
	 *
	 * @return the playOrderValues
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "playOrderValues", method = RequestMethod.GET)
	public List<DropdownElement> getPlayOrderValues() {
		return DropdownUtil.parseDropdownValues(environment.getDropdown().getPlayOrderValues());
	}
	
	/**
	 * Gets the Play Message Header values.
	 *
	 * @return the playMsgHeaderValues
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "playMsgHeaderValues", method = RequestMethod.GET)
	public List<DropdownElement> getPlayMsgHeaderValues() {
		return DropdownUtil.parseDropdownValues(environment.getDropdown().getPlayMsgHeaderValues());
	}
	
	/**
	 * Gets the Auto Play Messages values.
	 *
	 * @return the autoPlayMsgValues
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "autoPlayMsgValues", method = RequestMethod.GET)
	public List<DropdownElement> getAutoPlayMsgValues() {
		return DropdownUtil.parseDropdownValues(environment.getDropdown().getAutoPlayMsgValues());
	}
	
	/**
	 * Gets the Linked Listen values.
	 *
	 * @return the linkedListenValues
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "linkedListenValues", method = RequestMethod.GET)
	public List<DropdownElement> getLinkedListenValues() {
		return DropdownUtil.parseDropdownValues(environment.getDropdown().getLinkedListenValues());
	}
	
	
	/**
	 * Gets the Prompt Type values.
	 *
	 * @return the promptTypeValues
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "promptTypeValues", method = RequestMethod.GET)
	public List<DropdownElement> getPromptTypeValues() {
		return DropdownUtil.parseDropdownValues(environment.getDropdown().getPromptTypeValues());
	}
	
	
	/**
	 * Gets the Fax Feature Enabled values.
	 *
	 * @return the faxFeatureEnabledValues
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "faxFeatureEnabledValues", method = RequestMethod.GET)
	public List<DropdownElement> getFaxFeatureEnabledValues() {
		return DropdownUtil.parseDropdownValues(environment.getDropdown().getFaxFeatureEnabledValues());
	}
	
	
	/**
	 * Gets the Auto Fax Print On values.
	 *
	 * @return the autoFaxPrintOnValues
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "autoFaxPrintOnValues", method = RequestMethod.GET)
	public List<DropdownElement> getAutoFaxPrintOnValues() {
		return DropdownUtil.parseDropdownValues(environment.getDropdown().getAutoFaxPrintOnValues());
	}
	
	
	/**
	 * Gets the V2T ON values.
	 *
	 * @return the v2tOnValues
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "v2tOnValues", method = RequestMethod.GET)
	public List<DropdownElement> getV2tOnValues() {
		return DropdownUtil.parseDropdownValues(environment.getDropdown().getV2tOnValues());
	}
	
	
	/**
	 * Gets the V2E ON values.
	 *
	 * @return the v2eOnValues
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "v2eOnValues", method = RequestMethod.GET)
	public List<DropdownElement> getV2eOnValuess() {
		return DropdownUtil.parseDropdownValues(environment.getDropdown().getV2eOnValues());
	}
	
	
	/**
	 * Gets the V2W ON values.
	 *
	 * @return the v2wOnValues
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "v2wOnValues", method = RequestMethod.GET)
	public List<DropdownElement> getV2wOnValues() {
		return DropdownUtil.parseDropdownValues(environment.getDropdown().getV2wOnValues());
	}
	
	
	/**
	 * Gets the MWI ON values.
	 *
	 * @return the mwiOnValues
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "mwiOnValues", method = RequestMethod.GET)
	public List<DropdownElement> getMwiOnValues() {
		return DropdownUtil.parseDropdownValues(environment.getDropdown().getMwiOnValues());
	}
	
	
	/**
	 * Gets the Device Type values.
	 *
	 * @return the deviceType values
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "deviceTypeValues", method = RequestMethod.GET)
	public List<DropdownElement> getDeviceTypeValues() {
		return DropdownUtil.parseDropdownValues(environment.getDropdown().getDeviceTypeValues());
	}
	
	
	/**
	 * Gets the NUT values.
	 *
	 * @return the nutvalues
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "nutValues", method = RequestMethod.GET)
	public List<DropdownElement> getNutValues() {
		return DropdownUtil.parseDropdownValues(environment.getDropdown().getNutValues());
	}
	
	
	/**
	 * Gets the dltMsgActionValues values.
	 *
	 * @return the dltMsgActionValues values
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "dltMsgActionValues", method = RequestMethod.GET)
	public List<DropdownElement> getDltMsgActionValues() {
		return DropdownUtil.parseDropdownValues(environment.getDropdown().getDltMsgActionValues());
	}
	
	
	/**
	 * Gets the OMTP VVM On values.
	 *
	 * @return the omtpVvmOnValues values
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "omtpVvmOnValues", method = RequestMethod.GET)
	public List<DropdownElement> getOmtpVvmOnValues() {
		return DropdownUtil.parseDropdownValues(environment.getDropdown().getOmtpVvmOnValues());
	}
	
	/**
	 * Gets the OMA VVM On values.
	 *
	 * @return the omaVvmOnValues values
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "omaVvmOnValues", method = RequestMethod.GET)
	public List<DropdownElement> getOmaVvmOnValues() {
		return DropdownUtil.parseDropdownValues(environment.getDropdown().getOmaVvmOnValues());
	}
	
	/**
	 * Gets the Type of request values.
	 *
	 * @return the typeOfRequestValues values
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "typeOfRequestValues", method = RequestMethod.GET)
	public List<DropdownElement> getTypeOfRequestValues() {
		return DropdownUtil.parseDropdownValues(environment.getDropdown().getTypeOfRequestValues());
	}
	
	/**
	 * Gets the migration status values.
	 *
	 * @return the migrationStatusValues values
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "migrationStatusValues", method = RequestMethod.GET)
	public List<DropdownElement> getMigrationStatusValues() {
		return DropdownUtil.parseDropdownValues(environment.getDropdown().getMigrationStatusValues());
	}
	
	/**
	 * Gets the forced migration values.
	 *
	 * @return the forcedMigrationValues values
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "forcedMigrationValues", method = RequestMethod.GET)
	public List<DropdownElement> getForcedMigrationValues() {
		return DropdownUtil.parseDropdownValues(environment.getDropdown().getForcedMigrationValues());
	}
	
	/**
	 * Gets the V2T notification type values.
	 *
	 * @return the v2tNotificationTypeValues values
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "v2tNotificationTypeValues", method = RequestMethod.GET)
	public String[] getV2tNotificationTypeValues() {
		return environmentProperties.getV2tNotificationTypeValues() != null 
				? environmentProperties.getV2tNotificationTypeValues().split(",")
				: null;
	}
	
	/**
	 * Gets the notify me enabled values.
	 *
	 * @return the notifyMeEnabled values
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "notifyMeEnabledValues", method = RequestMethod.GET)
	public List<DropdownElement> getNotifyMeEnabledValues() {
		return DropdownUtil.parseDropdownValues(environment.getDropdown().getNotifyMeEnabledValues());
	}

	/**
	 * Gets the URL value
	 *
	 * @return the url value
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "urlValues", method = RequestMethod.GET)
	public String[] getUrl() {
		return environment.getUrl().split(",");
	}

	/**
	 * Gets the URL count
	 *
	 * @return the url count
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "urlCount", method = RequestMethod.GET)
	public int getUrlCount() {
		return environment.getUrl().split(",").length;
	}

	/**
	 * Gets the URL value
	 *
	 * @return the url value
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "url", method = RequestMethod.GET)
	public String getNextUrl() {
		String url;
		synchronized (urlIter) {
			url = urlIter.next();
		}
		/**
		InetAddress address;
		try {
			URL Fqdnurl = new URL(url);	
  			String fqdn = Fqdnurl.getHost();
  			address = InetAddress.getByName(fqdn);
  			String IP = address.getHostAddress();
  			url = url.replace(fqdn, IP);
		} catch (UnknownHostException | MalformedURLException me) {
			return url;
		}
		**/
		return url;
	}
	
	/**
	 * Gets the resource URL value
	 *
	 * @return the resourceUrl value
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "resurlvalue", method = RequestMethod.GET)
	public String getResUrl() {
		return environment.getResUrl();
	}
	
	/**
	 * Gets the bulletin max entries value
	 *
	 * @return the bulletin maxEntries value
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "maxentriesvalue", method = RequestMethod.GET)
	public String getMaxEntries() {
		return environment.getMaxEntries();
	}
	
	/**
	 * Gets the msisdn length value
	 *
	 * @return the msisdnLength value
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "msisdnLengthValue", method = RequestMethod.GET)
	public String getMsisdnLength() {
		return environment.getMsisdnLength();
	}
	
	/**
	 * Gets the request timeout value
	 *
	 * @return the requestTimeout value
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "requestTimeoutValue", method = RequestMethod.GET)
	public String getRequestTimeout() {
		return environment.getRequestTimeout();
	}
	
	/**
	 * Gets the digest auth enable flag value
	 *
	 * @return the digestAuthEnabled value
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "digestAuthEnabled", method = RequestMethod.GET)
	public boolean isDigestAuthEnabled() {
		return environment.isDigestAuthEnabled();
	}
	
	/**
	 * Gets the mstore voicemail message folder location
	 *
	 * @return the  value
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "mstoreVoiceMailMessageFolderId", method = RequestMethod.GET)
	public String getMstoreVoiceMailMessageFolderId() {
		return environment.getMstoreVoiceMailMessageFolderId();
	}
	
	/**
	 * Gets the mstore greetings message folder location
	 *
	 * @return the  value
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "mstoreGreetingsMessageFolderId", method = RequestMethod.GET)
	public String getMstoreGreetingsMessageFolderId() {
		return environment.getMstoreGreetingsMessageFolderId();
	}
        
	/**
	 * Gets the mstore group greetings message folder location
	 * 
	 * 
	 * @return the  value
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "mstoreGroupGreetingsMessageFolderId", method = RequestMethod.GET)
	public String getMstoreGroupGreetingsMessageFolderId() {
	        return environment.getMstoreGroupGreetingsMessageFolderId();
	}

	/**
	 * Gets the user agent value
	 *
	 * @return the  value
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "userAgent", method = RequestMethod.GET)
	public String getUserAgent() {
		return environment.getUserAgent();
	}

	/**
	 * Gets the bulletin max entries value
	 *
	 * @return the bulletin maxEntries value
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "messageMaxEntries", method = RequestMethod.GET)
	public String getMessageMaxEntries() {
		return environment.getMessageMaxEntries();
	}
	
	/**
	 * Gets the max file size value
	 *
	 * @return the maxFileSize value
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "maxfilesizevalue", method = RequestMethod.GET)
	public int getMaxFileSize() {
		return environment.getMaxFileSize();
	}

	/**
	 * Gets the missed call notification values.
	 *
	 * @return the missed call notification values
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "missedCallNotifValues", method = RequestMethod.GET)
	public List<DropdownElement> getMissedCallNotifValues() {
		return DropdownUtil.parseDropdownValues(environment.getDropdown().getMissedCallNotif());
	}

	/**
	 * Gets the time zone values.
	 *
	 * @return the time zone values
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "timeZoneValues", method = RequestMethod.GET)
	public List<DropdownElement> getTimeZoneValues() {
		return DropdownUtil.parseDropdownValues(environment.getDropdown().getTimeZone());
	}

	/**
	 * Gets the apple vvm status values.
	 *
	 * @return the apple vvm status values
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "appleVvmStatusValues", method = RequestMethod.GET)
	public List<DropdownElement> getAppleVvmStatusValues() {
		return DropdownUtil.parseDropdownValues(environment.getDropdown().getAppleVvmStatusChanged());
	}

	/**
	 * Gets the notification type values.
	 *
	 * @return the notification type values
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "notificationTypeValues", method = RequestMethod.GET)
	public List<DropdownElement> getNotificationTypeValues() {
		return DropdownUtil.parseDropdownValues(environment.getDropdown().getNotificationType());
	}

	/**
	 * Gets the notification type values.
	 *
	 * @return the notification type values
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "notificationTypeValues/{cosId}", method = RequestMethod.GET)
	public List<DropdownElement> getNotificationTypeValues(@PathVariable String cosId) {
		return DropdownUtil.parseDropdownValues(environment.getDropdown().getNotificationType(cosId));
	}

	/**
	 * Gets the greeting type values.
	 *
	 * @return the greeting type values
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "greetingTypeValues", method = RequestMethod.GET)
	public List<DropdownElement> getGreetingTypeValues() {
		return DropdownUtil.parseDropdownValues(environment.getDropdown().getGreetingType());
	}

	/**
	 * Gets the v2tTranslationLang values.
	 *
	 * @return the v2tTranslationLang values
	 *
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "v2tTranslationLangValues", method = RequestMethod.GET)
	public List<DropdownElement> getV2tTranslationLanguageValues() {
	       return DropdownUtil.parseDropdownValues(environment.getDropdown().getV2tTranslationLang());
	}
	
	/**
	 * Gets the subType values.
	 *
	 * @return the subType values
	 *
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "subTypeValues", method = RequestMethod.GET)
	public List<DropdownElement> getSubTypeValues() {
	       return DropdownUtil.parseDropdownValues(environment.getDropdown().getSubType());
	}
	
	/**
	 * Gets the subStatus values.
	 *
	 * @return the subStatus values
	 * 	 	 	 	 
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "subStatusValues", method = RequestMethod.GET)
	public List<DropdownElement> getSubStatusValues() {
	       return DropdownUtil.parseDropdownValues(environment.getDropdown().getSubStatus());
	}
	
	/**
	 * Gets the operatorId values.
	 *
	 * @return the operatorId values
	 *
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "operatorIdValues", method = RequestMethod.GET)
	public List<DropdownElement> getOperatorIdValues() {
	       return DropdownUtil.parseDropdownValues(environment.getDropdown().getOperatorId());
	}

	/**
	 * Checks if Subscriber exists based on MSISDN.
	 *
	 * @param msisdn the msisdn
	 * @return true, if successful
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "exists", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean exists(@RequestBody String msisdn) {
		logger.info("START - Check existence of subscriber by msisdn (" + msisdn + ")");
		MailboxSearchFullResponse response = service.query(msisdn);
		logger.info("END - Check existence of subscriber by msisdn (" + msisdn + ")");
		if (response != null && response.getResponse() != null && Strings.isNullOrEmpty(response.getResponse().getErrorCause())) {
			return true;
		}
		return false;
	}

	/**
	 * Merge.
	 *
	 * @param mergeVm the merge vm
	 * @return the mailbox response vm
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "merge", method = RequestMethod.POST)
	public MailboxResponseVM merge(@Valid @RequestBody MergeVM mergeVm) {
		if (mergeVm.getSecondaryMsisdns().contains(mergeVm.getPrimaryMsisdn())) {
			throw new BadRequestException("Duplicate MSISDNs found");
		}
		logger.info("START - Merge mailboxes (" + Joiner.on(", ").join(mergeVm.getPrimaryMsisdn(), mergeVm.getSecondaryMsisdns()) + ")");
		MergeRequest merge = new MergeRequest();
		merge.setPriMsisdn(mergeVm.getPrimaryMsisdn());
		merge.getSecMsisdn().addAll(mergeVm.getSecondaryMsisdns());
		MailboxResponse response = service.merge(merge);
		logMailboxResponse(response, "Merge mailboxes (" + Joiner.on(", ").join(mergeVm.getPrimaryMsisdn(), mergeVm.getSecondaryMsisdns()) + "):");
		MailboxResponseVM vm = mapper.map(response, MailboxResponseVM.class);
		return vm;
	}

	/**
	 * Split.
	 *
	 * @param msisdn the msisdn
	 * @return the mailbox response vm
	 */
	@PreAuthorize("hasAnyRole('ROLE_INTERMEDIATE','ROLE_ADVANCED')")
	@RequestMapping(value = "split/{unifiedMailboxId}", method = RequestMethod.POST)
	public MailboxResponseVM split(@PathVariable String unifiedMailboxId) {
		logger.info("START - Split mailboxes (Unified mailbox ID: " + unifiedMailboxId + ")");
		MailboxResponse response = service.split(unifiedMailboxId);
		logMailboxResponse(response, "Split mailboxes (Unified mailbox ID: " + unifiedMailboxId + ")");
		MailboxResponseVM vm = mapper.map(response, MailboxResponseVM.class);
		return vm;
	}

	/**
	 * Sets the dropdown values from domain model to view model.
	 *
	 * @param vm the vm
	 * @return the mailbox search vm
	 */
	private MailboxVM setDropdownValues(MailboxVM vm, MailboxSearchResponseAttributes attributes) {
		vm.setClassOfService(DropdownUtil.getDropdownElement(getClassOfServiceValues(), attributes.getClassOfService()));
		vm.setLanguage(DropdownUtil.getDropdownElement(getLanguageValues(), attributes.getLanguage()));
		vm.setTimeZone(DropdownUtil.getDropdownElement(getTimeZoneValues(), attributes.getTimeZone()));
		vm.setNotificationType(DropdownUtil.getDropdownElement(getNotificationTypeValues(attributes.getClassOfService()), attributes.getNotificationType()));
		vm.setMissedCallNotif(DropdownUtil.getDropdownElement(getMissedCallNotifValues(), attributes.getMissedCallNotif()));
		vm.setAppleVvmStatusChanged(DropdownUtil.getDropdownElement(getAppleVvmStatusValues(), attributes.getAppleVvmStatusChanged()));
		vm.setUserLoginLevel(DropdownUtil.getDropdownElement(getUserLoginLevelValues(), attributes.getUserLoginLevel()));
		return vm;
	}

	/**
	 * Sets the dropdown values from view model to domain model.
	 *
	 * @param vm the vm
	 * @return the mailbox search vm
	 */
	private MailboxVM setDropdownValues(EditSubscriberRequest request, MailboxEditVM vm) {
		request.setClassOfService(vm.getClassOfService() == null ? null : vm.getClassOfService().getValue());
		request.setLanguage(vm.getLanguage() == null ? null : vm.getLanguage().getValue());
		request.setTimeZone(vm.getTimeZone() == null ? null : vm.getTimeZone().getValue());
		request.setAppleVvmStatusChanged(vm.getAppleVvmStatusChanged() == null ? null : vm.getAppleVvmStatusChanged().getValue());
		request.setNotificationType(vm.getNotificationType() == null ? null : vm.getNotificationType().getValue());
		request.setMissedCallNotif(vm.getMissedCallNotif() == null ? null : vm.getMissedCallNotif().getValue());
		request.setUserLoginLevel(vm.getUserLoginLevel() == null ? null : Integer.parseInt(vm.getUserLoginLevel().getValue()));
		return vm;
	}

	/**
	 * Sets the dropdown values from view model to domain model.
	 *
	 * @param vm the vm
	 * @return the mailbox search vm
	 */
	private void setDropdownValues(EditSubscriberRequest request, MailboxEditSimpleVM vm) {
		request.setLanguage(vm.getLanguage() == null ? null : vm.getLanguage().getValue());
		request.setTimeZone(vm.getTimeZone() == null ? null : vm.getTimeZone().getValue());
		request.setNotificationType(vm.getNotificationType() == null ? null : vm.getNotificationType().getValue());
		request.setMissedCallNotif(vm.getMissedCallNotif() == null ? null : vm.getMissedCallNotif().getValue());
	}

	/**
	 * Fill with template.
	 *
	 * @param template the template
	 * @param vm the vm
	 * @return the class
	 */
	private IMailboxVM fillWithTemplate(VmpTemplate template, IMailboxVM vm) {
		IMailboxVM copyVm = mapper.map(vm, IMailboxVM.class);
		if (template == null) {
			return vm;
		}
		Method[] methods = copyVm.getClass().getDeclaredMethods();
		for (Method getMethod : methods) {
			if (getMethod.getName().startsWith("get")) {
				try {
					Object fieldGetValue = getMethod.invoke(copyVm);
					String fieldName = getMethod.getName().substring(3, 4).toLowerCase() + getMethod.getName().substring(4);
					if (fieldGetValue == null && template.containsKey(fieldName)) {
						Method setMethod = copyVm.getClass().getDeclaredMethod("s" + getMethod.getName().substring(1), getMethod.getReturnType());
						String fieldDefaultValue = template.getPropertyValue(fieldName);
						Object fieldSetValue = null;
						try {
							fieldSetValue = TypeConverter.convert(fieldDefaultValue, getMethod.getReturnType());
						} catch (UnsupportedOperationException e) {
							logger.error("Cannot replace empty " + fieldName + " field with default value " + fieldDefaultValue +
									" from template " + template.getId(), e);
							return vm;
						}
						setMethod.invoke(copyVm, fieldSetValue);
					}
				} catch (Exception e) {
					logger.error("Error happened when replacing empty request fields with default values", e);
					return vm;
				}
			}
		}
		return copyVm;
	}

	/**
	 * Fill with template.
	 *
	 * @param template the template
	 * @return the class
	 */
	private VmpTemplateVM fillWithTemplate(VmpTemplate template) {
		VmpTemplateVM vm = new VmpTemplateVM();
		if (template == null) {
			return null;
		}
		Method[] methods = vm.getClass().getDeclaredMethods();
		for (Method getMethod : methods) {
			if (getMethod.getName().startsWith("get")) {
				try {
					Object fieldGetValue = getMethod.invoke(vm);
					String fieldName = getMethod.getName().substring(3, 4).toLowerCase() + getMethod.getName().substring(4);
					if (fieldGetValue == null && template.containsKey(fieldName)) {
						Method setMethod = vm.getClass().getDeclaredMethod("s" + getMethod.getName().substring(1), getMethod.getReturnType());
						String fieldDefaultValue = template.getPropertyValue(fieldName);
						Object fieldSetValue = null;
						try {
							fieldSetValue = TypeConverter.convert(fieldDefaultValue, getMethod.getReturnType());
						} catch (UnsupportedOperationException e) {
							logger.error("Cannot replace empty " + fieldName + " field with default value " + fieldDefaultValue +
									" from template " + template.getId(), e);
							return null;
						}
						setMethod.invoke(vm, fieldSetValue);
					}
				} catch (Exception e) {
					logger.error("Error happened when replacing empty request fields with default values", e);
					return null;
				}
			}
		}
		return vm;
	}

	/**
	 * Sets the single field.
	 *
	 * @param request the subscriber
	 * @param name the name
	 * @param value the value
	 * @return the edits the subscriber request
	 */
	private EditSubscriberRequest setSingleField(EditSubscriberRequest request, String name, String value) {
		if (name.equals("msisdn")) {
			request.setNewMsisdn(value);
			return request;
		}
		Method[] methods = EditSubscriberRequest.class.getMethods();
		for (Method setMethod : methods) {
			if (setMethod.getName().startsWith("set")) {
				try {
					String fieldName = setMethod.getName().substring(3, 4).toLowerCase() + setMethod.getName().substring(4);
					if (fieldName.equals(name)) {
						Method getMethod = EditSubscriberRequest.class.getMethod("g" + setMethod.getName().substring(1));
						Object fieldSetValue = null;
						try {
							fieldSetValue = TypeConverter.convert(value, getMethod.getReturnType());
						} catch (UnsupportedOperationException e) {
							logger.error("Cannot replace " + fieldName + " field with new value " + value, e);
							return request;
						}
						setMethod.invoke(request, fieldSetValue);
						return request;
					}
				} catch (Exception e) {
					logger.error("Error happened when replacing empty request fields with default values", e);
					return request;
				}
			}
		}
		return request;
	}

	/**
	 * Log mailbox response.
	 *
	 * @param response the response
	 */
	private void logMailboxResponse(MailboxResponse response, String actionName) {
		logger.info("RESPONSE - " + actionName);
		if (response != null) {
			logger.info("status code = " + response.getStatusCode() + ", " + "status text = " + response.getStatusText() +
					", " + "error cause = " + response.getErrorCause());
		}
	}

}
