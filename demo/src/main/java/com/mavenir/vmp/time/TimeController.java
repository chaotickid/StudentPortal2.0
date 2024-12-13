/**
 *
 */
package com.mavenir.vmp.time;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.Arrays;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.mavenir.vmp.config.EnvironmentProperties;

/**
 * @author developer, OptimIT
 *
 */
@RestController
@RequestMapping("time")
public class TimeController {

	private final Logger logger = LoggerFactory.getLogger(TimeController.class);

	@Autowired
	private RestTemplate rest;

	@Autowired
	private EnvironmentProperties environment;

	@RequestMapping
	public String getTime() {
		UriComponentsBuilder uriComponentsBuilder =
				UriComponentsBuilder.fromUriString(environment.getCcpsUrl()).path("echo/time");
		URI targetUrl = uriComponentsBuilder.build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", MediaType.TEXT_PLAIN_VALUE);
		try {
			headers.add("Authorization", "Basic " + Arrays.toString(Base64.encodeBase64(environment.getVmpUser().getBytes("UTF-8"))));
		} catch (UnsupportedEncodingException e) {
			logger.error("Unsupported charset UTF-8 ", e);
		}
		headers.setAccept(Arrays.asList(MediaType.TEXT_PLAIN));
		HttpEntity<String> request = new HttpEntity<String>("", headers);
		try {
			return rest.exchange(targetUrl, HttpMethod.GET, request, String.class).getBody();
		} catch (ResourceAccessException ex) {
			return "CCPS unavailable";
		}
	}
}