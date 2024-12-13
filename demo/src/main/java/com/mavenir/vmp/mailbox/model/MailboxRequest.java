package com.mavenir.vmp.mailbox.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * The Class MailboxRequest.
 */
public class MailboxRequest {

	/** The msisdn. */
	@JacksonXmlProperty(localName = "msisdn")
	private String msisdn;

	/** The new msisdn. */
	@JacksonXmlProperty(localName = "new_msisdn")
	private String newMsisdn;

	/** The cos. */
	@JacksonXmlProperty(localName = "class_of_service")
	private String cos;

	/** The pin. */
	@JacksonXmlProperty(localName = "pin")
	private String pin;

	/** The time zone. */
	@JacksonXmlProperty(localName = "time_zone")
	private String timeZone;

	/** The notification type. */
	@JacksonXmlProperty(localName = "notification_type")
	private String notificationType;

	/** The mailbox locked. */
	@JacksonXmlProperty(localName = "mailbox_locked")
	private Boolean mailboxLocked;

	/** The failed login count. */
	@JacksonXmlProperty(localName = "failed_login_count")
	private String failedLoginCount;

	/** The voicemail blocked. */
	@JacksonXmlProperty(localName = "vm_blocked")
	private Boolean voicemailBlocked;

	/** The password supression. */
	@JacksonXmlProperty(localName = "password_suppression")
	private Boolean passwordSupression;

	/** The cli presentation. */
	@JacksonXmlProperty(localName = "cli_presentation_enabled")
	private Boolean cliPresentation;

	/** The mailbox unlock time. */
	@JacksonXmlProperty(localName = "mailbox_unlock_time")
	private String mailboxUnlockTime;

	/** The broadcast alert timestamp. */
	@JacksonXmlProperty(localName = "broadcast_alert_time_stamp")
	private String broadcastAlertTimestamp;

	/** The apple vvm status. */
	@JacksonXmlProperty(localName = "apple_vvm_status_changed")
	private String appleVvmStatus;

	/** The migration status. */
	@JacksonXmlProperty(localName = "migration_status")
	private Boolean migrationStatus;

	/** The user login level. */
	@JacksonXmlProperty(localName = "user_login_level")
	private String userLoginLevel;

	/** The imap password. */
	@JacksonXmlProperty(localName = "imap_password")
	private String imapPassword;

	/** The imap failed login count. */
	@JacksonXmlProperty(localName = "imap_failed_login_count")
	private String imapFailedLoginCount;

	/** The imap locked. */
	@JacksonXmlProperty(localName = "imap_locked")
	private boolean imapLocked;

	/** The quota. */
	@JacksonXmlProperty(localName = "subscriber_mailbox_quota")
	private String quota;

	/** The request id. */
	@JacksonXmlProperty(localName = "request_id")
	private String requestId;

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

	/**
	 * Gets the pin.
	 *
	 * @return the pin
	 */
	public String getPin() {
		return pin;
	}

	/**
	 * Sets the pin.
	 *
	 * @param pin the new pin
	 */
	public void setPin(String pin) {
		this.pin = pin;
	}

	/**
	 * Gets the user login level.
	 *
	 * @return the user login level
	 */
	public String getUserLoginLevel() {
		return userLoginLevel;
	}

	/**
	 * Sets the user login level.
	 *
	 * @param userLoginLevel the new user login level
	 */
	public void setUserLoginLevel(String userLoginLevel) {
		this.userLoginLevel = userLoginLevel;
	}

	/**
	 * Gets the cos.
	 *
	 * @return the cos
	 */
	public String getCos() {
		return cos;
	}

	/**
	 * Sets the cos.
	 *
	 * @param cos the new cos
	 */
	public void setCos(String cos) {
		this.cos = cos;
	}

	/**
	 * Gets the notification type.
	 *
	 * @return the notification type
	 */
	public String getNotificationType() {
		return notificationType;
	}

	/**
	 * Sets the notification type.
	 *
	 * @param notificationType the new notification type
	 */
	public void setNotificationType(String notificationType) {
		this.notificationType = notificationType;
	}

	/**
	 * Gets the failed login count.
	 *
	 * @return the failed login count
	 */
	public String getFailedLoginCount() {
		return failedLoginCount;
	}

	/**
	 * Sets the failed login count.
	 *
	 * @param failedLoginCount the new failed login count
	 */
	public void setFailedLoginCount(String failedLoginCount) {
		this.failedLoginCount = failedLoginCount;
	}

	/**
	 * Gets the quota.
	 *
	 * @return the quota
	 */
	public String getQuota() {
		return quota;
	}

	/**
	 * Sets the quota.
	 *
	 * @param quota the new quota
	 */
	public void setQuota(String quota) {
		this.quota = quota;
	}

	/**
	 * Gets the time zone.
	 *
	 * @return the time zone
	 */
	public String getTimeZone() {
		return timeZone;
	}

	/**
	 * Sets the time zone.
	 *
	 * @param timeZone the new time zone
	 */
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	/**
	 * Gets the apple vvm status.
	 *
	 * @return the apple vvm status
	 */
	public String getAppleVvmStatus() {
		return appleVvmStatus;
	}

	/**
	 * Sets the apple vvm status.
	 *
	 * @param appleVvmStatus the new apple vvm status
	 */
	public void setAppleVvmStatus(String appleVvmStatus) {
		this.appleVvmStatus = appleVvmStatus;
	}

	/**
	 * Gets the mailbox locked.
	 *
	 * @return the mailbox locked
	 */
	public Boolean getMailboxLocked() {
		return mailboxLocked;
	}

	/**
	 * Sets the mailbox locked.
	 *
	 * @param mailboxLocked the new mailbox locked
	 */
	public void setMailboxLocked(Boolean mailboxLocked) {
		this.mailboxLocked = mailboxLocked;
	}

	/**
	 * Gets the voicemail blocked.
	 *
	 * @return the voicemail blocked
	 */
	public Boolean getVoicemailBlocked() {
		return voicemailBlocked;
	}

	/**
	 * Sets the voicemail blocked.
	 *
	 * @param voicemailBlocked the new voicemail blocked
	 */
	public void setVoicemailBlocked(Boolean voicemailBlocked) {
		this.voicemailBlocked = voicemailBlocked;
	}

	/**
	 * Gets the cli presentation.
	 *
	 * @return the cli presentation
	 */
	public Boolean getCliPresentation() {
		return cliPresentation;
	}

	/**
	 * Sets the cli presentation.
	 *
	 * @param cliPresentation the new cli presentation
	 */
	public void setCliPresentation(Boolean cliPresentation) {
		this.cliPresentation = cliPresentation;
	}

	/**
	 * Gets the password supression.
	 *
	 * @return the password supression
	 */
	public Boolean getPasswordSupression() {
		return passwordSupression;
	}

	/**
	 * Sets the password supression.
	 *
	 * @param passwordSupression the new password supression
	 */
	public void setPasswordSupression(Boolean passwordSupression) {
		this.passwordSupression = passwordSupression;
	}

	/**
	 * Gets the migration status.
	 *
	 * @return the migration status
	 */
	public Boolean getMigrationStatus() {
		return migrationStatus;
	}

	/**
	 * Sets the migration status.
	 *
	 * @param migrationStatus the new migration status
	 */
	public void setMigrationStatus(Boolean migrationStatus) {
		this.migrationStatus = migrationStatus;
	}

	/**
	 * Gets the new msisdn.
	 *
	 * @return the new msisdn
	 */
	public String getNewMsisdn() {
		return newMsisdn;
	}

	/**
	 * Sets the new msisdn.
	 *
	 * @param newMsisdn the new new msisdn
	 */
	public void setNewMsisdn(String newMsisdn) {
		this.newMsisdn = newMsisdn;
	}

	/**
	 * Gets the mailbox unlock time.
	 *
	 * @return the mailbox unlock time
	 */
	public String getMailboxUnlockTime() {
		return mailboxUnlockTime;
	}

	/**
	 * Sets the mailbox unlock time.
	 *
	 * @param mailboxUnlockTime the new mailbox unlock time
	 */
	public void setMailboxUnlockTime(String mailboxUnlockTime) {
		this.mailboxUnlockTime = mailboxUnlockTime;
	}

	/**
	 * Gets the broadcast alert timestamp.
	 *
	 * @return the broadcast alert timestamp
	 */
	public String getBroadcastAlertTimestamp() {
		return broadcastAlertTimestamp;
	}

	/**
	 * Sets the broadcast alert timestamp.
	 *
	 * @param broadcastAlertTimestamp the new broadcast alert timestamp
	 */
	public void setBroadcastAlertTimestamp(String broadcastAlertTimestamp) {
		this.broadcastAlertTimestamp = broadcastAlertTimestamp;
	}

	/**
	 * Gets the imap password.
	 *
	 * @return the imap password
	 */
	public String getImapPassword() {
		return imapPassword;
	}

	/**
	 * Sets the imap password.
	 *
	 * @param imapPassword the new imap password
	 */
	public void setImapPassword(String imapPassword) {
		this.imapPassword = imapPassword;
	}

	/**
	 * Gets the imap failed login count.
	 *
	 * @return the imap failed login count
	 */
	public String getImapFailedLoginCount() {
		return imapFailedLoginCount;
	}

	/**
	 * Sets the imap failed login count.
	 *
	 * @param imapFailedLoginCount the new imap failed login count
	 */
	public void setImapFailedLoginCount(String imapFailedLoginCount) {
		this.imapFailedLoginCount = imapFailedLoginCount;
	}

	/**
	 * Checks if is imap locked.
	 *
	 * @return true, if is imap locked
	 */
	public boolean isImapLocked() {
		return imapLocked;
	}

	/**
	 * Sets the imap locked.
	 *
	 * @param imapLocked the new imap locked
	 */
	public void setImapLocked(boolean imapLocked) {
		this.imapLocked = imapLocked;
	}
}
