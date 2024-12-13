/**
 *
 */
package com.mavenir.vmp.mailbox.vm;

import com.mavenir.vmp.external.DropdownElement;
import org.joda.time.DateTime;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

/**
 * The Class MailboxVM.
 *
 * @author Vlatka, OptimIT
 */
public class MailboxVM {

	/** The msisdn. */
	@NotNull
	private String msisdn;

	/** The class of service. */
	private DropdownElement classOfService;

	/** The migration status. */
	private Boolean migrationStatus;

	/** The password suppression. */
	private Boolean passwordSuppression;

	/** The time zone. */
	private DropdownElement timeZone;

	/** The cli presentation enabled. */
	private Boolean cliPresentationEnabled;

	/** The notification type. */
	private DropdownElement notificationType;

	/** The failed login count. */
	@Min(value = 0)
	private Integer failedLoginCount;

	/** The apple vvm status changed. */
	private DropdownElement appleVvmStatusChanged;

	/** The vm blocked. */
	private Boolean vmBlocked;

//	/** The legal intercept. */
//	private Boolean legalIntercept;

	/** The subscriber mailbox quota. */
	@Min(value = 0)
	private Integer subscriberMailboxQuota;

	/** The imap failed login count. */
	@Min(value = 0)
	private Integer imapFailedLoginCount;

	/** The subscriber blocked. */
	private Boolean subscriberBlocked;

	/** The mailbox locked. */
	private Boolean mailboxLocked;

	/** The date. */
	private DateTime date;

	/** The user login level. */
	private DropdownElement userLoginLevel;

//	/** The user login source. */
//	private String userLoginSource;

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

	private String unifiedMailboxId;
	
	/** the last deposit date */
	private String lastDepositDate;
	
	/** the last retrieval date */
	private String lastRetrievalDate;

	/** The language. */
	private DropdownElement language;
	
	/** The missed call notification */
	private DropdownElement missedCallNotif;

	/** The mailbox initialized. */
	private Boolean mailboxInitialized;
	
	/** The greeting type */
	private String greetingType;
	
	/** The MCC Service active flag */
	private Boolean mccServiceActive;
	
	/** The MCC Folder creation date */
	private String mccFolderCreationDate;

	/** The MCC voice messages count */
	private String mccVoiceMsgsNum;
	
	/** The MCC Service only flag */
	private Boolean mccServiceOnly;

	
	
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
	 * Gets the class of service.
	 *
	 * @return the class of service
	 */
	public DropdownElement getClassOfService() {
		return classOfService;
	}

	/**
	 * Sets the class of service.
	 *
	 * @param classOfService the new class of service
	 */
	public void setClassOfService(DropdownElement classOfService) {
		this.classOfService = classOfService;
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
	 * Gets the password suppression.
	 *
	 * @return the password suppression
	 */
	public Boolean getPasswordSuppression() {
		return passwordSuppression;
	}

	/**
	 * Sets the password suppression.
	 *
	 * @param passwordSuppression the new password suppression
	 */
	public void setPasswordSuppression(Boolean passwordSuppression) {
		this.passwordSuppression = passwordSuppression;
	}

	/**
	 * Gets the time zone.
	 *
	 * @return the time zone
	 */
	public DropdownElement getTimeZone() {
		return timeZone;
	}

	/**
	 * Sets the time zone.
	 *
	 * @param timeZone the new time zone
	 */
	public void setTimeZone(DropdownElement timeZone) {
		this.timeZone = timeZone;
	}

	/**
	 * Gets the cli presentation enabled.
	 *
	 * @return the cli presentation enabled
	 */
	public Boolean getCliPresentationEnabled() {
		return cliPresentationEnabled;
	}

	/**
	 * Sets the cli presentation enabled.
	 *
	 * @param cliPresentationEnabled the new cli presentation enabled
	 */
	public void setCliPresentationEnabled(Boolean cliPresentationEnabled) {
		this.cliPresentationEnabled = cliPresentationEnabled;
	}

	/**
	 * Gets the notification type.
	 *
	 * @return the notification type
	 */
	public DropdownElement getNotificationType() {
		return notificationType;
	}

	/**
	 * Sets the notification type.
	 *
	 * @param notificationType the new notification type
	 */
	public void setNotificationType(DropdownElement notificationType) {
		this.notificationType = notificationType;
	}

	/**
	 * Gets the failed login count.
	 *
	 * @return the failed login count
	 */
	public Integer getFailedLoginCount() {
		return failedLoginCount;
	}

	/**
	 * Sets the failed login count.
	 *
	 * @param failedLoginCount the new failed login count
	 */
	public void setFailedLoginCount(Integer failedLoginCount) {
		this.failedLoginCount = failedLoginCount;
	}

	/**
	 * Gets the apple vvm status changed.
	 *
	 * @return the apple vvm status changed
	 */
	public DropdownElement getAppleVvmStatusChanged() {
		return appleVvmStatusChanged;
	}

	/**
	 * Sets the apple vvm status changed.
	 *
	 * @param appleVvmStatusChanged the new apple vvm status changed
	 */
	public void setAppleVvmStatusChanged(DropdownElement appleVvmStatusChanged) {
		this.appleVvmStatusChanged = appleVvmStatusChanged;
	}

	/**
	 * Gets the vm blocked.
	 *
	 * @return the vm blocked
	 */
	public Boolean getVmBlocked() {
		return vmBlocked;
	}

	/**
	 * Sets the vm blocked.
	 *
	 * @param vmBlocked the new vm blocked
	 */
	public void setVmBlocked(Boolean vmBlocked) {
		this.vmBlocked = vmBlocked;
	}

//	/**
//	 * Gets the legal intercept.
//	 *
//	 * @return the legal intercept
//	 */
//	public Boolean getLegalIntercept() {
//		return legalIntercept;
//	}
//
//	/**
//	 * Sets the legal intercept.
//	 *
//	 * @param legalIntercept the new legal intercept
//	 */
//	public void setLegalIntercept(Boolean legalIntercept) {
//		this.legalIntercept = legalIntercept;
//	}

	/**
	 * Gets the subscriber mailbox quota.
	 *
	 * @return the subscriber mailbox quota
	 */
	public Integer getSubscriberMailboxQuota() {
		return subscriberMailboxQuota;
	}

	/**
	 * Sets the subscriber mailbox quota.
	 *
	 * @param subscriberMailboxQuota the new subscriber mailbox quota
	 */
	public void setSubscriberMailboxQuota(Integer subscriberMailboxQuota) {
		this.subscriberMailboxQuota = subscriberMailboxQuota;
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
	public Boolean getSubscriberBlocked() {
		return subscriberBlocked;
	}

	/**
	 * Sets the subscriber blocked.
	 *
	 * @param subscriberBlocked the new subscriber blocked
	 */
	public void setSubscriberBlocked(Boolean subscriberBlocked) {
		this.subscriberBlocked = subscriberBlocked;
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
	 * Gets the date.
	 *
	 * @return the date
	 */
	public DateTime getDate() {
		return date;
	}

	/**
	 * Sets the date.
	 *
	 * @param date the new date
	 */
	public void setDate(DateTime date) {
		this.date = date;
	}

	/**
	 * Gets the user login level.
	 *
	 * @return the user login level
	 */
	public DropdownElement getUserLoginLevel() {
		return userLoginLevel;
	}

	/**
	 * Sets the user login level.
	 *
	 * @param userLoginLevel the new user login level
	 */
	public void setUserLoginLevel(DropdownElement userLoginLevel) {
		this.userLoginLevel = userLoginLevel;
	}

//	/**
//	 * Gets the user login source.
//	 *
//	 * @return the user login source
//	 */
//	public String getUserLoginSource() {
//		return userLoginSource;
//	}
//
//	/**
//	 * Sets the user login source.
//	 *
//	 * @param userLoginSource the new user login source
//	 */
//	public void setUserLoginSource(String userLoginSource) {
//		this.userLoginSource = userLoginSource;
//	}

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
	 * Gets the used quota.
	 *
	 * @return the used quota
	 */
	public String getUsedQuota() {
		return usedQuota;
	}

	/**
	 * Sets the used quota.
	 *
	 * @param usedQuota the new used quota
	 */
	public void setUsedQuota(String usedQuota) {
		this.usedQuota = usedQuota;
	}

	/**
	 * Gets the new msg count.
	 *
	 * @return the new msg count
	 */
	public Integer getNewMsgCount() {
		return newMsgCount;
	}

	/**
	 * Sets the new msg count.
	 *
	 * @param newMsgCount the new new msg count
	 */
	public void setNewMsgCount(Integer newMsgCount) {
		this.newMsgCount = newMsgCount;
	}

	/**
	 * Gets the saved msg count.
	 *
	 * @return the saved msg count
	 */
	public Integer getSavedMsgCount() {
		return savedMsgCount;
	}

	/**
	 * Sets the saved msg count.
	 *
	 * @param savedMsgCount the new saved msg count
	 */
	public void setSavedMsgCount(Integer savedMsgCount) {
		this.savedMsgCount = savedMsgCount;
	}

	/**
	 * Gets the num of msg.
	 *
	 * @return the num of msg
	 */
	public Integer getNumOfMsg() {
		return numOfMsg;
	}

	/**
	 * Sets the num of msg.
	 *
	 * @param numOfMsg the new num of msg
	 */
	public void setNumOfMsg(Integer numOfMsg) {
		this.numOfMsg = numOfMsg;
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
	 * Returns language value.
	 *
	 * @return the language value.
	 */
	public DropdownElement getLanguage() {
		return language;
	}

	/**
	 * Sets language to given value.
	 *
	 * @param language the language to set
	 */
	public void setLanguage(DropdownElement language) {
		this.language = language;
	}

	/**
	 * Returns missedCallNotif value.
	 *
	 * @return the missedCallNotif value.
	 */
	public DropdownElement getMissedCallNotif() {
		return missedCallNotif;
	}

	/**
	 * Sets missedCallNotif to given value.
	 *
	 * @param missedCallNotif the missedCallNotif to set
	 */
	public void setMissedCallNotif(DropdownElement missedCallNotif) {
		this.missedCallNotif = missedCallNotif;
	}

	/**
	 * Returns mailboxInitialized value.
	 *
	 * @return the mailboxInitialized value.
	 */
	public Boolean getMailboxInitialized() {
		return mailboxInitialized;
	}

	/**
	 * Sets mailboxInitialized to given value.
	 *
	 * @param mailboxInitialized the mailboxInitialized to set
	 */
	public void setMailboxInitialized(Boolean mailboxInitialized) {
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
	public Boolean getMccServiceActive() {
		return mccServiceActive;
	}

	/**
	 * Sets mccServiceActive to given value.
	 *
	 * @param mccServiceActive the mccServiceActive to set
	 */
	public void setMccServiceActive(Boolean mccServiceActive) {
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
	 * @param mccFolderCreationDate the mccFolderCreationDate to set
	 */
	public void setMccFolderCreationDate(String mccFolderCreationDate) {
		this.mccFolderCreationDate = mccFolderCreationDate;
	}

	/**
	 * Returns mccVoiceMsgsNum value.
	 *
	 * @return the mccVoiceMsgsNum value.
	 */
	public String getMccVoiceMsgsNum() {
		return mccVoiceMsgsNum;
	}

	/**
	 * Sets mccVoiceMsgsNum to given value.
	 *
	 * @param mccVoiceMsgsNum the mccVoiceMsgsNum to set
	 */
	public void setMccVoiceMsgsNum(String mccVoiceMsgsNum) {
		this.mccVoiceMsgsNum = mccVoiceMsgsNum;
	}

	/**
	 * Returns mccServiceOnly value.
	 *
	 * @return the mccServiceOnly value.
	 */
	public Boolean getMccServiceOnly() {
		return mccServiceOnly;
	}

	/**
	 * Sets mccServiceOnly to given value.
	 *
	 * @param mccServiceOnly the mccServiceOnly to set
	 */
	public void setMccServiceOnly(Boolean mccServiceOnly) {
		this.mccServiceOnly = mccServiceOnly;
	}

}
