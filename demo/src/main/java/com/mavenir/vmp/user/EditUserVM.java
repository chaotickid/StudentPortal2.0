/**
 *
 */
package com.mavenir.vmp.user;

/**
 * @author developer, OptimIT
 *
 */
public class EditUserVM extends AbstractUser {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/** Encrypted login password. */
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
