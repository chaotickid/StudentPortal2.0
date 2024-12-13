/**
 *
 */
package com.mavenir.vmp.mailbox.vm;

import com.mavenir.vmp.external.DropdownElement;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

/**
 * @author developer, OptimIT
 *
 */
public class MailboxEditSimpleVM {

	/** The msisdn. */
	@NotNull
	private String msisdn;

	/** The time zone. */
	private DropdownElement timeZone;

	/** The notification type. */
	private DropdownElement notificationType;

	/** The failed login count. */
	@Min(value = 0)
	private Integer failedLoginCount;

	/** The pin. */
	private String pin;

	/** The imap failed login count. */
	@Min(value = 0)
	private Integer imapFailedLoginCount;

	/** The user login level. */
	private DropdownElement userLoginLevel;

	/** The imap password. */
	private String imapPassword;
	
	/** The language. */
	private DropdownElement language;
	
	/** The missed call notification. */
	private DropdownElement missedCallNotif;

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public DropdownElement getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(DropdownElement timeZone) {
		this.timeZone = timeZone;
	}

	public DropdownElement getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(DropdownElement notificationType) {
		this.notificationType = notificationType;
	}

	public Integer getFailedLoginCount() {
		return failedLoginCount;
	}

	public void setFailedLoginCount(Integer failedLoginCount) {
		this.failedLoginCount = failedLoginCount;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public Integer getImapFailedLoginCount() {
		return imapFailedLoginCount;
	}

	public void setImapFailedLoginCount(Integer imapFailedLoginCount) {
		this.imapFailedLoginCount = imapFailedLoginCount;
	}

	public DropdownElement getUserLoginLevel() {
		return userLoginLevel;
	}

	public void setUserLoginLevel(DropdownElement userLoginLevel) {
		this.userLoginLevel = userLoginLevel;
	}

	public String getImapPassword() {
		return imapPassword;
	}

	public void setImapPassword(String imapPassword) {
		this.imapPassword = imapPassword;
	}

	public DropdownElement getLanguage() {
		return language;
	}

	public void setLanguage(DropdownElement language) {
		this.language = language;
	}

	public DropdownElement getMissedCallNotif() {
		return missedCallNotif;
	}

	public void setMissedCallNotif(DropdownElement missedCallNotif) {
		this.missedCallNotif = missedCallNotif;
	}
}
