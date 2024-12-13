/**
 *
 */
package com.mavenir.vmp.mailbox.model;

import org.joda.time.DateTime;

/**
 * The Class MailboxVMAttributeList.
 *
 * @author Vlatka, OptimIT
 */
public class MailboxSearchResponseAttributes {

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

	/** The subscriber mailbox quota. */
	private Integer subscriberMailboxQuota;

	/** The imap failed login count. */
	private Integer imapFailedLoginCount;

	/** The date. */
	private DateTime date;

	/** The user login level. */
	private String userLoginLevel;

	/** The user login source. */
	private String userLoginSource;

	/** The broadcast alert time stamp. */
	private String broadcastAlertTimeStamp;

	/** The used quota. */
	private String usedQuota;

	/** The new msg count. */
	private Integer newMsgCount;

	/** The saved msg count. */
	private Integer savedMsgCount;

	/** The num of msg. */
	private Integer numOfMsg;

	/** The subscriber blocked. */
	private String subscriberBlocked;

	/** The pin. */
	private String pin;

	/** The mailbox locked. */
	private String mailboxLocked;

	private String unifiedMailboxId;
	
	/** the last deposit date */
	private String lastDepositDate;
	
	/** the last retrieval date */
	private String lastRetrievalDate;
	
	/** The language. */
	private String language;
	
	/** The missed call notification. */
	private String missedCallNotif;

	/** The mailbox initialized. */
	private String mailboxInitialized;
	
	/** The greeting type **/
	private String greetingType;
	
	/** The MCC Service Active **/
	private String mccServiceActive;
	
	/** The MCC Folder Creation date **/
	private String mccFolderCreationDate;
	
	/** The MCC Voice Messages number **/
	private int mccVoiceMsgsNum;
	
	/** The MCC Service only active **/
	private String mccServiceOnly;

	/**
	 * Gets the value of the date property.
	 *
	 * @return
	 *         possible object is {@link String }
	 */
	public DateTime getDate() {
		return date;
	}

	/**
	 * Sets the value of the date property.
	 *
	 * @param value
	 *        allowed object is {@link String }
	 */
	public void setDate(DateTime value) {
		this.date = value;
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
	 * Gets the value of the userLoginLevel property.
	 *
	 * @return
	 *         possible object is {@link String }
	 */
	public String getUserLoginLevel() {
		return userLoginLevel;
	}

	/**
	 * Sets the value of the userLoginLevel property.
	 *
	 * @param value
	 *        allowed object is {@link String }
	 */
	public void setUserLoginLevel(String value) {
		this.userLoginLevel = value;
	}

	/**
	 * Gets the value of the userLoginSource property.
	 *
	 * @return
	 *         possible object is {@link String }
	 */
	public String getUserLoginSource() {
		return userLoginSource;
	}

	/**
	 * Sets the value of the userLoginSource property.
	 *
	 * @param value
	 *        allowed object is {@link String }
	 */
	public void setUserLoginSource(String value) {
		this.userLoginSource = value;
	}

	/**
	 * Gets the value of the broadcastAlertTimeStamp property.
	 *
	 * @return
	 *         possible object is {@link String }
	 */
	public String getBroadcastAlertTimeStamp() {
		return broadcastAlertTimeStamp;
	}

	/**
	 * Sets the value of the broadcastAlertTimeStamp property.
	 *
	 * @param value
	 *        allowed object is {@link String }
	 */
	public void setBroadcastAlertTimeStamp(String value) {
		this.broadcastAlertTimeStamp = value;
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
	 * Gets the value of the imapFailedLoginCount property.
	 *
	 * @return
	 *         possible object is {@link Integer }
	 */
	public Integer getImapFailedLoginCount() {
		return imapFailedLoginCount;
	}

	/**
	 * Sets the value of the imapFailedLoginCount property.
	 *
	 * @param value
	 *        allowed object is {@link Integer }
	 */
	public void setImapFailedLoginCount(Integer value) {
		this.imapFailedLoginCount = value;
	}

	/**
	 * Gets the value of the subscriberMailboxQuota property.
	 *
	 * @return
	 *         possible object is {@link String }
	 */
	public Integer getSubscriberMailboxQuota() {
		return subscriberMailboxQuota;
	}

	/**
	 * Sets the value of the subscriberMailboxQuota property.
	 *
	 * @param value
	 *        allowed object is {@link String }
	 */
	public void setSubscriberMailboxQuota(Integer value) {
		this.subscriberMailboxQuota = value;
	}

	/**
	 * Gets the value of the usedQuota property.
	 *
	 * @return
	 *         possible object is {@link String }
	 */
	public String getUsedQuota() {
		return usedQuota;
	}

	/**
	 * Sets the value of the usedQuota property.
	 *
	 * @param value
	 *        allowed object is {@link String }
	 */
	public void setUsedQuota(String value) {
		this.usedQuota = value;
	}

	/**
	 * Gets the value of the newMsgCount property.
	 *
	 * @return
	 *         possible object is {@link Integer }
	 */
	public Integer getNewMsgCount() {
		return newMsgCount;
	}

	/**
	 * Sets the value of the newMsgCount property.
	 *
	 * @param value
	 *        allowed object is {@link Integer }
	 */
	public void setNewMsgCount(Integer value) {
		this.newMsgCount = value;
	}

	/**
	 * Gets the value of the savedMsgCount property.
	 *
	 * @return
	 *         possible object is {@link Integer }
	 */
	public Integer getSavedMsgCount() {
		return savedMsgCount;
	}

	/**
	 * Sets the value of the savedMsgCount property.
	 *
	 * @param value
	 *        allowed object is {@link Integer }
	 */
	public void setSavedMsgCount(Integer value) {
		this.savedMsgCount = value;
	}

	/**
	 * Gets the value of the numOfMsg property.
	 *
	 * @return
	 *         possible object is {@link Integer }
	 */
	public Integer getNumOfMsg() {
		return numOfMsg;
	}

	/**
	 * Sets the value of the numOfMsg property.
	 *
	 * @param value
	 *        allowed object is {@link Integer }
	 */
	public void setNumOfMsg(Integer value) {
		this.numOfMsg = value;
	}

	/**
	 * Gets the value of the subscriberBlocked property.
	 *
	 * @return
	 *         possible object is {@link String }
	 */
	public String getSubscriberBlocked() {
		return subscriberBlocked;
	}

	/**
	 * Sets the value of the subscriberBlocked property.
	 *
	 * @param value
	 *        allowed object is {@link String }
	 */
	public void setSubscriberBlocked(String value) {
		this.subscriberBlocked = value;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getMailboxLocked() {
		return mailboxLocked;
	}

	public void setMailboxLocked(String mailboxLocked) {
		this.mailboxLocked = mailboxLocked;
	}

	public String getUnifiedMailboxId() {
		return unifiedMailboxId;
	}

	public void setUnifiedMailboxId(String unifiedMailboxId) {
		this.unifiedMailboxId = unifiedMailboxId;
	}

	/**
	 * Returns lastDepositDate value.
	 *
	 * @return the lastDepositDate value.
	 */
	public String getLastDepositDate() {
		return lastDepositDate;
	}

	/**
	 * Sets lastDepositDate to given value.
	 *
	 * @param lastDepositDate the lastDepositDate to set
	 */
	public void setLastDepositDate(String lastDepositDate) {
		this.lastDepositDate = lastDepositDate;
	}

	/**
	 * Returns lastRetrievalDate value.
	 *
	 * @return the lastRetrievalDate value.
	 */
	public String getLastRetrievalDate() {
		return lastRetrievalDate;
	}

	/**
	 * Sets lastRetrievalDate to given value.
	 *
	 * @param lastRetrievalDate the lastRetrievalDate to set
	 */
	public void setLastRetrievalDate(String lastRetrievalDate) {
		this.lastRetrievalDate = lastRetrievalDate;
	}

	/**
	 * Gets the value of the language property.
	 *
	 * @return
	 *         possible object is {@link String }
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * Sets the value of the language property.
	 *
	 * @param value
	 *        allowed object is {@link String }
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

	/**
	 * Returns mailboxInitialized value.
	 *
	 * @return the mailboxInitialized value.
	 */
	public String getMailboxInitialized() {
		return mailboxInitialized;
	}

	/**
	 * Sets mailboxInitialized to given value.
	 *
	 * @param mailboxInitialized the mailboxInitialized to set
	 */
	public void setMailboxInitialized(String mailboxInitialized) {
		this.mailboxInitialized = mailboxInitialized;
	}

	/**
	 * Returns greetingType value.
	 *
	 * @return the greetingType value.
	 */
	public String getGreetingType() {
		return greetingType;
	}

	/**
	 * Sets greetingType to given value.
	 *
	 * @param greetingType the greetingType to set
	 */
	public void setGreetingType(String greetingType) {
		this.greetingType = greetingType;
	}

	/**
	 * Returns mccServiceActive value.
	 *
	 * @return the mccServiceActive value.
	 */
	public String getMccServiceActive() {
		return mccServiceActive;
	}

	/**
	 * Sets mccServiceActive to given value.
	 *
	 * @param mccServiceActive
	 *            the mccServiceActive to set
	 */
	public void setMccServiceActive(String mccServiceActive) {
		this.mccServiceActive = mccServiceActive;
	}

	/**
	 * Returns mccFolderCreationDate value.
	 *
	 * @return the mccFolderCreationDate value.
	 */
	public String getMccFolderCreationDate() {
		return mccFolderCreationDate;
	}

	/**
	 * Sets mccFolderCreationDate to given value.
	 *
	 * @param mccFolderCreationDate
	 *            the mccFolderCreationDate to set
	 */
	public void setMccFolderCreationDate(String mccFolderCreationDate) {
		this.mccFolderCreationDate = mccFolderCreationDate;
	}

	/**
	 * Returns mccVoiceMsgsNum value.
	 *
	 * @return the mccVoiceMsgsNum value.
	 */
	public int getMccVoiceMsgsNum() {
		return mccVoiceMsgsNum;
	}

	/**
	 * Sets mccVoiceMsgsNum to given value.
	 *
	 * @param mccVoiceMsgsNum
	 *            the mccVoiceMsgsNum to set
	 */
	public void setMccVoiceMsgsNum(int mccVoiceMsgsNum) {
		this.mccVoiceMsgsNum = mccVoiceMsgsNum;
	}

	/**
	 * Returns mccServiceOnly value.
	 *
	 * @return the mccServiceOnly value.
	 */
	public String getMccServiceOnly() {
		return mccServiceOnly;
	}

	/**
	 * Sets mccServiceOnly to given value.
	 *
	 * @param mccServiceOnly the mccServiceOnly to set
	 */
	public void setMccServiceOnly(String mccServiceOnly) {
		this.mccServiceOnly = mccServiceOnly;
	}

}
