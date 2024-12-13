package com.mavenir.vmp.mailbox.model;

/**
 * The Class MailboxResponse.
 */
public class MailboxResponse {

	/** The status code. */
	private String statusCode;

	/** The status text. */
	private String statusText;

	/** The response id. */
	private String responseId;

	/** The error cause. */
	private String errorCause;

	/** The msisdn. */
	private String msisdn;

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
	 * Gets the status text.
	 *
	 * @return the status text
	 */
	public String getStatusText() {
		return statusText;
	}

	/**
	 * Sets the status text.
	 *
	 * @param statusText the new status text
	 */
	public void setStatusText(String statusText) {
		this.statusText = statusText;
	}

	/**
	 * Gets the response id.
	 *
	 * @return the response id
	 */
	public String getResponseId() {
		return responseId;
	}

	/**
	 * Sets the response id.
	 *
	 * @param responseId the new response id
	 */
	public void setResponseId(String responseId) {
		this.responseId = responseId;
	}

	/**
	 * Gets the msisdn.
	 *
	 * @return the msisdn
	 */
	public String getMsisdn() {
		return msisdn;
	}

	/**
	 * Sets the msisdn.
	 *
	 * @param msisdn the new msisdn
	 */
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
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
