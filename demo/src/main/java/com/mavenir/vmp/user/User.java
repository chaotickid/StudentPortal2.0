package com.mavenir.vmp.user;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;

/**
 * Application user.
 *
 */
@Entity
public class User extends AbstractUser {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/** Encrypted login password. */
	@NotNull
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
