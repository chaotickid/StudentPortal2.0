/**
 *
 */
package com.mavenir.vmp.security.handler;

/**
 * @author developer, OptimIT
 *
 */
public class UserLoggedOutException extends RuntimeException {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new user logged out exception.
	 */
	public UserLoggedOutException() {
	}

	/**
	 * Instantiates a new user logged out exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public UserLoggedOutException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new user logged out exception.
	 *
	 * @param message the message
	 */
	public UserLoggedOutException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new user logged out exception.
	 *
	 * @param cause the cause
	 */
	public UserLoggedOutException(Throwable cause) {
		super(cause);
	}
}
