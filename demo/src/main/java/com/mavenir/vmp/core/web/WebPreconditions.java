package com.mavenir.vmp.core.web;

/**
 * Utility methods for checking validity of request parameters.
 */
public final class WebPreconditions {

	/**
	 * Instantiates a new web preconditions.
	 */
	private WebPreconditions() {
	}

	/**
	 * Ensures that an given value is not null.
	 *
	 * @param <T> value type
	 * @param value value
	 * @return the t
	 */
	public static <T> T checkNotNull(T value) {
		if (value == null) {
			throw new NotFoundException();
		}

		return value;
	}

}
