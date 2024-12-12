package com.mavenir.vmp.security.handler;

import com.mavenir.vmp.user.UserCounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Authentication success handler that doesn't do anything.
 *
 */
@Component
public class NoOpAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Autowired
	private UserCounterService counter;

	@Autowired
	private AccountLockService service;

	/**
	 * Called when a user has been successfully authenticated.
	 *
	 * @param request HTTP servlet request
	 * @param response HTTP servlet response
	 * @param authentication authentication object
	 */
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) {
		counter.incrementCounter();
		service.loginSuccess(authentication.getName());
	}

}
