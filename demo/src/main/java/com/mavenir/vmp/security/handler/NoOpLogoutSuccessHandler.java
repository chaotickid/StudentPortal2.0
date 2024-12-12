package com.mavenir.vmp.security.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Logout success handler that doesn't do anything.
 *
 */
public class NoOpLogoutSuccessHandler implements LogoutSuccessHandler {

	/**
	 * Called when a user has been successfully logged out.
	 *
	 * @param request HTTP servlet request
	 * @param response HTTP servlet response
	 * @param authentication authentication object
	 */
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
	}

}
