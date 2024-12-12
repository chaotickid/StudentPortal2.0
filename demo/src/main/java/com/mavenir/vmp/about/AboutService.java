/**
 *
 */
package com.mavenir.vmp.about;

import com.mavenir.vmp.config.EnvironmentProperties;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.Arrays;

/**
 * The Class AboutService.
 *
 * @author Vlatka, OptimIT
 */
@Service
public class AboutService {

	private final Logger logger = LoggerFactory.getLogger(AboutService.class);

	/** The conn config. */
	@Autowired
	private EnvironmentProperties environment;

	/** The rest template. */
	@Autowired
	private RestTemplate restTemplate;

	/**
	 * Gets the ccps version.
	 *
	 * @return the ccps version
	 */
	public String getCcpsVersion() {
		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(environment.getCcpsUrl()).path("ccps_version");
		URI targetUrl = uriComponentsBuilder.build().toUri();
		String result = restTemplate.exchange(targetUrl, HttpMethod.GET, authorizationHeader(), String.class).getBody();
		return result;
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

}
