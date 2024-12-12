package com.mavenir.vmp.rest;

import java.net.MalformedURLException;
import java.net.URL;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.config.AuthSchemes;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.common.base.Throwables;
import com.mavenir.vmp.config.EnvironmentProperties;

/**
 * Credential provider for integration.
 */
@Service
public class RestCredentialsProvider extends BasicCredentialsProvider {

	/** The environment config. */
	@Autowired
	private EnvironmentProperties environment;

	/*
	 * (non-Javadoc)
	 * @see org.apache.http.impl.client.BasicCredentialsProvider#getCredentials(org.apache.http.auth.AuthScope)
	 */
	@Override
	public Credentials getCredentials(AuthScope authscope) {
		Credentials credentials = super.getCredentials(authscope);
		if (credentials != null) {
			return credentials;
		}

		URL url;
		try {
			url = new URL(environment.getCcpsUrl());
		} catch (MalformedURLException e) {
			throw Throwables.propagate(e);
		}

		String host = url.getHost();
		int port = url.getPort();
		if (port == -1) {
			port = url.getProtocol().equalsIgnoreCase("http") ? 80 : 443;
		}
		boolean basic = authscope.getScheme().equalsIgnoreCase(AuthSchemes.BASIC);

		if (authscope.getHost().equals(host) && authscope.getPort() == port && basic) {
			return new UsernamePasswordCredentials("USERNAME", "PASSWORD");
		}

		return null;
	}

}
