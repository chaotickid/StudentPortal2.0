package com.mavenir.vmp.mailbox.model;

/**
 * The Class AbstractSubscriberRequest.
 */
public abstract class AbstractSubscriberRequest implements Requestable {

	/** The request id. */
	private String requestId;

	/** The msisdn. */
	private String msisdn;

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
	private Integer failedLoginCount;

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

	/** The imap failed login count. */
	private Integer imapFailedLoginCount;

	/** The broadcast alert time stamp. */
	private String broadcastAlertTimeStamp;

	/** The userLoginLevel. */
	private Integer userLoginLevel;
	
	/** The language. */
	private String language;

	/** The missed call notification. */
	private String missedCallNotif;

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
	@Override
	public void setRequestId(String value) {
		this.requestId = value;
	}

	/**
	 * Gets the value of the msisdn property.
	 *
	 * @return
	 *         possible object is {@link String }
	 */
	public String getMsisdn() {
		return msisdn;
	}

	/**
	 * Sets the value of the msisdn property.
	 *
	 * @param value
	 *        allowed object is {@link String }
	 */
	public void setMsisdn(String value) {
		this.msisdn = value;
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
	 * Gets the broadcast alert time stamp.
	 *
	 * @return the broadcast alert time stamp
	 */
	public String getBroadcastAlertTimeStamp() {
		return broadcastAlertTimeStamp;
	}

	/**
	 * Sets the broadcast alert time stamp.
	 *
	 * @param broadcastAlertTimeStamp the new broadcast alert time stamp
	 */
	public void setBroadcastAlertTimeStamp(String broadcastAlertTimeStamp) {
		this.broadcastAlertTimeStamp = broadcastAlertTimeStamp;
	}

	/**
	 * Gets the class of service.
	 *
	 * @return the class of service
	 */
	public Integer getUserLoginLevel() {
		return userLoginLevel;
	}

	/**
	 * Sets the class of service.
	 *
	 * @param userLoginLevel the new class of service
	 */
	public void setUserLoginLevel(Integer userLoginLevel) {
		this.userLoginLevel = userLoginLevel;
	}

	/**
	 * Returns language value.
	 *
	 * @return the language value.
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * Sets language to given value.
	 *
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * Returns missedCallNotif value.
	 *
	 * @return the missedCallNotif value.
	 */
	public String getMissedCallNotif() {
		return missedCallNotif;
	}

	/**
	 * Sets missedCallNotif to given value.
	 *
	 * @param missedCallNotif the missedCallNotif to set
	 */
	public void setMissedCallNotif(String missedCallNotif) {
		this.missedCallNotif = missedCallNotif;
	}

}
