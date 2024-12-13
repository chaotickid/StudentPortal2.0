/**
 *
 */
package com.mavenir.vmp.mailbox.vm;

/**
 * The Class EditSubscriberFieldRequest.
 *
 * @author Vlatka, OptimIT
 */
public class MailboxEditFieldVM {

	/** The request id. */
	private String requestId;

	/** The msisdn. */
	private String msisdn;

	/** The new msisdn. */
	private String newMsisdn;

	/** The imap password. */
	private String imapPassword;

	/** The field name. */
	private String fieldName;

	/** The field value. */
	private String fieldValue;

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
	 * Gets the field name.
	 *
	 * @return the field name
	 */
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * Sets the field name.
	 *
	 * @param fieldName the new field name
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	/**
	 * Gets the field value.
	 *
	 * @return the field value
	 */
	public String getFieldValue() {
		return fieldValue;
	}

	/**
	 * Sets the field value.
	 *
	 * @param fieldValue the new field value
	 */
	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}

	/**
	 * Gets the request id.
	 *
	 * @return the request id
	 */
	public String getRequestId() {
		return requestId;
	}

	/**
	 * Sets the request id.
	 *
	 * @param requestId the new request id
	 */
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getNewMsisdn() {
		return newMsisdn;
	}

	public void setNewMsisdn(String newMsisdn) {
		this.newMsisdn = newMsisdn;
	}

	public String getImapPassword() {
		return imapPassword;
	}

	public void setImapPassword(String imapPassword) {
		this.imapPassword = imapPassword;
	}

}
