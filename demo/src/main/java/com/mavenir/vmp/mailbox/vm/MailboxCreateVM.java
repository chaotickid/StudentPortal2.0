package com.mavenir.vmp.mailbox.vm;

import com.mavenir.vmp.export.ExportType;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

/**
 * The Class MailboxCreateVM.
 */
@ExportType
public class MailboxCreateVM implements IMailboxVM {

	/** The request id. */
	private String requestId;

	/** The msisdn. */
	@NotNull
	private String msisdn;

	/** The class of service. */
	private String classOfService;

	/** The migration status. */
	private Boolean migrationStatus;

	/** The password suppression. */
	private Boolean passwordSuppression;

	/** The time zone. */
	private String timeZone;

	/** The cli presentation enabled. */
	private Boolean cliPresentationEnabled;

	/** The notification type. */
	private String notificationType;

	/** The failed login count. */
	@Min(value = 0)
	private Integer failedLoginCount;

	/** The apple vvm status changed. */
	private String appleVvmStatusChanged;

	/** The vm blocked. */
	private Boolean vmBlocked;

	/** The legal intercept. */
	private Boolean legalIntercept;

	/** The pin. */
	//@NotNull
	private String pin;

	/** The imap password. */
	//@NotNull
	private String imapPassword;

	/** The subscriber mailbox quota. */
	@Min(value = 0)
	private Integer subscriberMailboxQuota;

	/** The mailbox locked. */
	private Boolean mailboxLocked;

	/** The template. */
	private String template;

	/** The broadcast alert time stamp. */
	private String broadcastAlertTimeStamp;

	/** The user login level. */
	private String userLoginLevel;
	
	/** The language. */
	private String language;

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
	public Boolean getMigrationStatus() {
		return migrationStatus;
	}

	/**
	 * Sets the value of the migrationStatus property.
	 *
	 * @param value
	 *        allowed object is {@link String }
	 */
	public void setMigrationStatus(Boolean value) {
		this.migrationStatus = value;
	}

	/**
	 * Gets the value of the passwordSuppression property.
	 *
	 * @return
	 *         possible object is {@link String }
	 */
	public Boolean getPasswordSuppression() {
		return passwordSuppression;
	}

	/**
	 * Sets the value of the passwordSuppression property.
	 *
	 * @param value
	 *        allowed object is {@link String }
	 */
	public void setPasswordSuppression(Boolean value) {
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
	public Boolean getCliPresentationEnabled() {
		return cliPresentationEnabled;
	}

	/**
	 * Sets the value of the cliPresentationEnabled property.
	 *
	 * @param value
	 *        allowed object is {@link String }
	 */
	public void setCliPresentationEnabled(Boolean value) {
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
	public Boolean getVmBlocked() {
		return vmBlocked;
	}

	/**
	 * Sets the value of the vmBlocked property.
	 *
	 * @param value
	 *        allowed object is {@link String }
	 */
	public void setVmBlocked(Boolean value) {
		this.vmBlocked = value;
	}

	/**
	 * Gets the value of the legalIntercept property.
	 *
	 * @return
	 *         possible object is {@link String }
	 */
	public Boolean getLegalIntercept() {
		return legalIntercept;
	}

	/**
	 * Sets the value of the legalIntercept property.
	 *
	 * @param value
	 *        allowed object is {@link String }
	 */
	public void setLegalIntercept(Boolean value) {
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
	public Boolean getMailboxLocked() {
		return mailboxLocked;
	}

	/**
	 * Sets the value of the mailboxLocked property.
	 *
	 * @param value
	 *        allowed object is {@link String }
	 */
	public void setMailboxLocked(Boolean value) {
		this.mailboxLocked = value;
	}

	/**
	 * Gets the template.
	 *
	 * @return the template
	 */
	public String getTemplate() {
		return template;
	}

	/**
	 * Sets the template.
	 *
	 * @param template the new template
	 */
	public void setTemplate(String template) {
		this.template = template;
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
	 * Gets the language.
	 *
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * Sets the language.
	 *
	 * @param language the new language
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public boolean isCreateVM() {
		return true;
	}

	@Override
	public boolean isEditVM() {
		return false;
	}

	@Override
	public boolean isSearchVM() {
		return false;
	}

}
