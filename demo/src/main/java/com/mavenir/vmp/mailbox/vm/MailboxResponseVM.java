/**
 *
 */
package com.mavenir.vmp.mailbox.vm;

/**
 * The Class MailboxResponseVM.
 *
 * @author Vlatka, OptimIT
 */
public class MailboxResponseVM {

	/** The status code. */
	private String statusCode;

	/** The error cause. */
	private String errorCause;

	/**
	 * Gets the status code.
	 *
	 * @return the status code
	 */
	public String getStatusCode() {
		return statusCode;
	}

	/**
	 * Sets the status code.
	 *
	 * @param statusCode the new status code
	 */
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * Gets the error cause.
	 *
	 * @return the error cause
	 */
	public String getErrorCause() {
		return errorCause;
	}

	/**
	 * Sets the error cause.
	 *
	 * @param errorCause the new error cause
	 */
	public void setErrorCause(String errorCause) {
		this.errorCause = errorCause;
	}

}
