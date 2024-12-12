package com.mavenir.vmp.core.web;

/**
 * Exception thrown when resource requested by user doesn't exist.
 */
public class NotFoundException extends RuntimeException {

	/** Serial version UID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new not found exception.
	 */
	public NotFoundException() {
		super();
	}

	/**
	 * Instantiates a new not found exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public NotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new not found exception.
	 *
	 * @param message the message
	 */
	public NotFoundException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new not found exception.
	 *
	 * @param cause the cause
	 */
	public NotFoundException(Throwable cause) {
		super(cause);
	}

}
