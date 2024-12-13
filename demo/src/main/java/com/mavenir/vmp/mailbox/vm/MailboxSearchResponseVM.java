/**
 *
 */
package com.mavenir.vmp.mailbox.vm;


/**
 * The Class MailboxSearchResponseVM.
 *
 * @author Vlatka, OptimIT
 */
public class MailboxSearchResponseVM {

	/** The status code. */
	private MailboxResponseVM responseStatus;

	/** The mailbox. */
	private MailboxSearchVM mailbox;

	/**
	 * Instantiates a new mailbox search response vm.
	 *
	 * @param statusCode the status code
	 * @param mailbox the mailbox
	 */
	public MailboxSearchResponseVM(MailboxResponseVM responseStatus, MailboxSearchVM mailbox) {
		this.responseStatus = responseStatus;
		this.mailbox = mailbox;
	}

	/**
	 * Gets the status code.
	 *
	 * @return the status code
	 */
	public MailboxResponseVM getResponseStatus() {
		return responseStatus;
	}

	/**
	 * Sets the status code.
	 *
	 * @param statusCode the new status code
	 */
	public void setResponseStatus(MailboxResponseVM responseStatus) {
		this.responseStatus = responseStatus;
	}

	/**
	 * Gets the mailbox.
	 *
	 * @return the mailbox
	 */
	public MailboxSearchVM getMailbox() {
		return mailbox;
	}

	/**
	 * Sets the mailbox.
	 *
	 * @param mailbox the new mailbox
	 */
	public void setMailbox(MailboxSearchVM mailbox) {
		this.mailbox = mailbox;
	}

}
