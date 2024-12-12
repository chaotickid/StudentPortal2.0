/**
 *
 */
package com.mavenir.vmp.security.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;

/**
 * @author developer, OptimIT
 *
 */
@Component
public class LoginFailedListener implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {

	/** The service. */
	@Autowired
	private AccountLockService service;

	@Override
	public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent event) {
		service.loginFailed(event.getAuthentication().getName());
	}

}
