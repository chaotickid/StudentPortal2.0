package com.mavenir.vmp.mailbox.vm;

import com.mavenir.vmp.export.ExportType;

/**
 * The Class MailboxEditVM.
 */
@ExportType
public class MailboxEditVM extends MailboxVM implements IMailboxVM {

	/** The msisdn. */
	private String newMsisdn;

	/** The pin. */
	private String pin;

	/** The imap password. */
	private String imapPassword;

	/**
	 * Gets the value of the new msisdn property.
	 *
	 * @return
	 *         possible object is {@link String }
	 */
	public String getNewMsisdn() {
		return newMsisdn;
	}

	/**
	 * Sets the value of the new msisdn property.
	 *
	 * @param value
	 *        allowed object is {@link String }
	 */
	public void setNewMsisdn(String value) {
		this.newMsisdn = value;
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

	@Override
	public boolean isCreateVM() {
		return false;
	}

	@Override
	public boolean isEditVM() {
		return true;
	}

	@Override
	public boolean isSearchVM() {
		return false;
	}

}
