package com.mavenir.vmp.rest;

/**
 * Integration exception.
 */
public class RestException extends RuntimeException {

	/** Serial version UID. */
	private static final long serialVersionUID = 1L;

	/** Server. */
	private final boolean server;

	/**
	 * Instantiates a new rest exception.
	 *
	 * @param server the server
	 * @param cause the cause
	 */
	public RestException(boolean server, Throwable cause) {
		super(cause);
		this.server = server;
	}

	/**
	 * Checks if is server.
	 *
	 * @return the server
	 */
	public boolean isServer() {
		return server;
	}

}
