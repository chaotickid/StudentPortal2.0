package com.mavenir.vmp.core.web;

/**
 * Exception to be thrown when application rejects user request.
 */
public final class BadRequestException extends RuntimeException {

	/** Serial version UID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new bad request exception.
	 */
	public BadRequestException() {
	}

	/**
	 * Instantiates a new bad request exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public BadRequestException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new bad request exception.
	 *
	 * @param message the message
	 */
	public BadRequestException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new bad request exception.
	 *
	 * @param cause the cause
	 */
	public BadRequestException(Throwable cause) {
		super(cause);
	}

}
