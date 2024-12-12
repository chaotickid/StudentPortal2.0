package com.mavenir.vmp.security.handler;

import com.google.common.collect.ImmutableSet;
import org.springframework.security.web.util.matcher.RequestMatcher;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.regex.Pattern;

/**
 * CSRF request matcher.
 *
 */
public class CsrfRequestMatcher implements RequestMatcher {

	/** Ignores methods. */
	private static final Collection<String> IGNORED_METHODS = ImmutableSet.of("GET", "HEAD", "TRACE", "OPTIONS");

	/** Ignored URLs. */
	private static final Pattern IGNORED_URL = Pattern.compile("/log-error|/socket(/.*)?");

	@Override
	public boolean matches(HttpServletRequest request) {
		String uri = request.getRequestURI().substring(request.getContextPath().length());
		return !IGNORED_METHODS.contains(request.getMethod()) && !IGNORED_URL.matcher(uri).matches();
	}

}
