/**
 *
 */
package com.mavenir.vmp.user;

import com.mavenir.vmp.export.ExportType;

import jakarta.validation.constraints.NotNull;

/**
 * @author developer, OptimIT
 *
 */
@ExportType
public class UserPasswordVM {

	/** The password. */
	@NotNull
	private String password;

	/** The new password. */
	@NotNull
	private String newPassword;

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the new password.
	 *
	 * @return the new password
	 */
	public String getNewPassword() {
		return newPassword;
	}

	/**
	 * Sets the new password.
	 *
	 * @param newPassword the new new password
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
}
