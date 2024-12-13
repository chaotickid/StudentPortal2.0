package com.mavenir.vmp.mailbox.template;

import jakarta.validation.constraints.Min;

/**
 * The Class VmpTemplateVM.
 */
public class VmpTemplateVM {

	/** The request id. */
	private String requestId;

	/** The class of service. */
	private String classOfService;

	/** The migration status. */
	private String migrationStatus;

	/** The password suppression. */
	private String passwordSuppression;

	/** The time zone. */
	private String timeZone;

	/** The cli presentation enabled. */
	private String cliPresentationEnabled;

	/** The notification type. */
	private String notificationType;

	/** The failed login count. */
	@Min(value = 0)
	private Integer failedLoginCount;

	/** The imap failed login count. */
	@Min(value = 0)
	private Integer imapFailedLoginCount;

	/** The apple vvm status changed. */
	private String appleVvmStatusChanged;

	/** The vm blocked. */
	private String vmBlocked;

	/** The legal intercept. */
	private String legalIntercept;

	/** The pin. */
	private String pin;

	/** The imap password. */
	private String imapPassword;

	/** The subscriber mailbox quota. */
	private Integer subscriberMailboxQuota;

	/** The mailbox locked. */
	private String mailboxLocked;

	/** The subscriber blocked. */
	private String subscriberBlocked;

	/**
	 * Gets the value of the requestId property.
	 *
	 * @return
	 *         possible object is {@link String }
	 */
	public String getRequestId() {
		return requestId;
	}

	/**
	 * Sets the value of the requestId property.
	 *
	 * @param value
	 *        allowed object is {@link String }
	 */
	public void setRequestId(String value) {
		this.requestId = value;
	}

	/**
	 * Gets the value of the classOfService property.
	 *
	 * @return
	 *         possible object is {@link String }
	 */
	public String getClassOfService() {
		return classOfService;
	}

	/**
	 * Sets the value of the classOfService property.
	 *
	 * @param value
	 *        allowed object is {@link String }
	 */
	public void setClassOfService(String value) {
		this.classOfService = value;
	}

	/**
	 * Gets the value of the migrationStatus property.
	 *
	 * @return
	 *         possible object is {@link String }
	 */
	public String getMigrationStatus() {
		return migrationStatus;
	}

	/**
	 * Sets the value of the migrationStatus property.
	 *
	 * @param value
	 *        allowed object is {@link String }
	 */
	public void setMigrationStatus(String value) {
		this.migrationStatus = value;
	}

	/**
	 * Gets the value of the passwordSuppression property.
	 *
	 * @return
	 *         possible object is {@link String }
	 */
	public String getPasswordSuppression() {
		return passwordSuppression;
	}

	/**
	 * Sets the value of the passwordSuppression property.
	 *
	 * @param value
	 *        allowed object is {@link String }
	 */
	public void setPasswordSuppression(String value) {
		this.passwordSuppression = value;
	}

	/**
	 * Gets the value of the timeZone property.
	 *
	 * @return
	 *         possible object is {@link String }
	 */
	public String getTimeZone() {
		return timeZone;
	}

	/**
	 * Sets the value of the timeZone property.
	 *
	 * @param value
	 *        allowed object is {@link String }
	 */
	public void setTimeZone(String value) {
		this.timeZone = value;
	}

	/**
	 * Gets the value of the cliPresentationEnabled property.
	 *
	 * @return
	 *         possible object is {@link String }
	 */
	public String getCliPresentationEnabled() {
		return cliPresentationEnabled;
	}

	/**
	 * Sets the value of the cliPresentationEnabled property.
	 *
	 * @param value
	 *        allowed object is {@link String }
	 */
	public void setCliPresentationEnabled(String value) {
		this.cliPresentationEnabled = value;
	}

	/**
	 * Gets the value of the notificationType property.
	 *
	 * @return
	 *         possible object is {@link String }
	 */
	public String getNotificationType() {
		return notificationType;
	}

	/**
	 * Sets the value of the notificationType property.
	 *
	 * @param value
	 *        allowed object is {@link String }
	 */
	public void setNotificationType(String value) {
		this.notificationType = value;
	}

	/**
	 * Gets the value of the failedLoginCount property.
	 *
	 * @return
	 *         possible object is {@link Integer }
	 */
	public Integer getFailedLoginCount() {
		return failedLoginCount;
	}

	/**
	 * Sets the value of the failedLoginCount property.
	 *
	 * @param value
	 *        allowed object is {@link Integer }
	 */
	public void setFailedLoginCount(Integer value) {
		this.failedLoginCount = value;
	}

	/**
	 * Gets the value of the appleVvmStatusChanged property.
	 *
	 * @return
	 *         possible object is {@link String }
	 */
	public String getAppleVvmStatusChanged() {
		return appleVvmStatusChanged;
	}

	/**
	 * Sets the value of the appleVvmStatusChanged property.
	 *
	 * @param value
	 *        allowed object is {@link String }
	 */
	public void setAppleVvmStatusChanged(String value) {
		this.appleVvmStatusChanged = value;
	}

	/**
	 * Gets the value of the vmBlocked property.
	 *
	 * @return
	 *         possible object is {@link String }
	 */
	public String getVmBlocked() {
		return vmBlocked;
	}

	/**
	 * Sets the value of the vmBlocked property.
	 *
	 * @param value
	 *        allowed object is {@link String }
	 */
	public void setVmBlocked(String value) {
		this.vmBlocked = value;
	}

	/**
	 * Gets the value of the legalIntercept property.
	 *
	 * @return
	 *         possible object is {@link String }
	 */
	public String getLegalIntercept() {
		return legalIntercept;
	}

	/**
	 * Sets the value of the legalIntercept property.
	 *
	 * @param value
	 *        allowed object is {@link String }
	 */
	public void setLegalIntercept(String value) {
		this.legalIntercept = value;
	}

	/**
	 * Gets the value of the pin property.
	 *
	 * @return
	 *         possible object is {@link String }
	 */
	public String getPin() {
		return pin;
	}

	/**
	 * Sets the value of the pin property.
	 *
	 * @param value
	 *        allowed object is {@link String }
	 */
	public void setPin(String value) {
		this.pin = value;
	}

	/**
	 * Gets the value of the imapPassword property.
	 *
	 * @return
	 *         possible object is {@link String }
	 */
	public String getImapPassword() {
		return imapPassword;
	}

	/**
	 * Sets the value of the imapPassword property.
	 *
	 * @param value
	 *        allowed object is {@link String }
	 */
	public void setImapPassword(String value) {
		this.imapPassword = value;
	}

	/**
	 * Gets the value of the subscriberMailboxQuota property.
	 *
	 * @return
	 *         possible object is {@link Integer }
	 */
	public Integer getSubscriberMailboxQuota() {
		return subscriberMailboxQuota;
	}

	/**
	 * Sets the value of the subscriberMailboxQuota property.
	 *
	 * @param value
	 *        allowed object is {@link Integer }
	 */
	public void setSubscriberMailboxQuota(Integer value) {
		this.subscriberMailboxQuota = value;
	}

	/**
	 * Gets the value of the mailboxLocked property.
	 *
	 * @return
	 *         possible object is {@link String }
	 */
	public String getMailboxLocked() {
		return mailboxLocked;
	}

	/**
	 * Sets the value of the mailboxLocked property.
	 *
	 * @param value
	 *        allowed object is {@link String }
	 */
	public void setMailboxLocked(String value) {
		this.mailboxLocked = value;
	}

	/**
	 * Gets the imap failed login count.
	 *
	 * @return the imap failed login count
	 */
	public Integer getImapFailedLoginCount() {
		return imapFailedLoginCount;
	}

	/**
	 * Sets the imap failed login count.
	 *
	 * @param imapFailedLoginCount the new imap failed login count
	 */
	public void setImapFailedLoginCount(Integer imapFailedLoginCount) {
		this.imapFailedLoginCount = imapFailedLoginCount;
	}

	/**
	 * Gets the subscriber blocked.
	 *
	 * @return the subscriber blocked
	 */
	public String getSubscriberBlocked() {
		return subscriberBlocked;
	}

	/**
	 * Sets the subscriber blocked.
	 *
	 * @param subscriberBlocked the new subscriber blocked
	 */
	public void setSubscriberBlocked(String subscriberBlocked) {
		this.subscriberBlocked = subscriberBlocked;
	}

}
