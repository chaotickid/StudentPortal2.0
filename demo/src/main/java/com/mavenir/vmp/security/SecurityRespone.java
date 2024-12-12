package com.mavenir.vmp.security;

/**
 * Security response.
 *
 */
public final class SecurityRespone {

	/** CSTF tToken. */
	private final String csrfToken;

	/** User. */
	private final UserSecurity user;

	public SecurityRespone(String csrfToken, UserSecurity user) {
		this.csrfToken = csrfToken;
		this.user = user;
	}

	public String getCsrfToken() {
		return csrfToken;
	}

	public UserSecurity getUser() {
		return user;
	}

}
