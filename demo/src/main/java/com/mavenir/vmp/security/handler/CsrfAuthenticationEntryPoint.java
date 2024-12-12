package com.mavenir.vmp.security.handler;

import com.google.common.net.HttpHeaders;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.csrf.CsrfToken;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Authentication entry point that returns CSRF token and 401 Unauthorized response.
 *
 * CSRF token is returned as HTTP header.
 *
 */
public class CsrfAuthenticationEntryPoint implements AuthenticationEntryPoint {

	/**
	 * Commences an authentication scheme.
	 *
	 * @param request HTTP servlet request
	 * @param response HTTP servlet response
	 * @param authException exception that caused the invocation
	 */
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
			throws IOException {

		CsrfToken token = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
		response.setHeader("X-CSRF-TOKEN", token.getToken());
		response.setHeader(HttpHeaders.WWW_AUTHENTICATE, "REST realm=\"VMP\"");

		response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
	}

}
