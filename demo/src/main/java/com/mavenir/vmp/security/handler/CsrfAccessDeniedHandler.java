package com.mavenir.vmp.security.handler;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.csrf.CsrfException;
import org.springframework.security.web.csrf.CsrfToken;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Access denied handler that returns CSRF token and 403 Forbidden response.
 *
 * CSRF token is returned as HTTP header.
 *
 */
public class CsrfAccessDeniedHandler implements AccessDeniedHandler {

	/**
	 * Handles an access denied failure.
	 *
	 * @param request HTTP servlet request
	 * @param response HTTP servlet response
	 * @param accessDeniedException exception that caused the invocation
	 */
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException {

		HttpStatus status;

		if (accessDeniedException instanceof CsrfException) {
			CsrfToken token = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
			response.setHeader("X-CSRF-TOKEN", token.getToken());
			status = HttpStatus.I_AM_A_TEAPOT;
		}	else {
			status = HttpStatus.FORBIDDEN;
		}

		response.sendError(status.value(), status.getReasonPhrase());
	}

}
