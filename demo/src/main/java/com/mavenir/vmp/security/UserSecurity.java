package com.mavenir.vmp.security;

import java.util.List;

/**
 * User security.
 *
 */
public class UserSecurity {

	private String username;

	/** Full name. */
	private String firstName;

	private String lastName;

	/** Language. */
	private String language;

	/** Roles. */
	private List<String> roles;

	public String getFullName() {
		return firstName != null && lastName != null ? firstName + " " + lastName : null;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
