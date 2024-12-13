/**
 *
 */
package com.mavenir.vmp.security.handler;

import com.mavenir.vmp.user.UserCounterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @author developer, OptimIT
 *
 */
@Component
public class NoOpLogoutHandler extends SecurityContextLogoutHandler {

	@Autowired
	private UserCounterService counter;

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		counter.decrementCounter();
		super.logout(request, response, authentication);
	}

}
