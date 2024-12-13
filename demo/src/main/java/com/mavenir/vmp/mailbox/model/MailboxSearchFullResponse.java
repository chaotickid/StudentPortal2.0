/**
 *
 */
package com.mavenir.vmp.mailbox.model;


/**
 * The Class MailboxSearchResponse.
 *
 * @author Vlatka, OptimIT
 */
public class MailboxSearchFullResponse {

	/** The vm. */
	private MailboxSearchResponse mailbox;

	/** The response. */
	private MailboxResponse response;

	/**
	 * Instantiates a new mailbox search response.
	 *
	 * @param vm the vm
	 * @param response the response
	 */
	public MailboxSearchFullResponse(MailboxSearchResponse vm, MailboxResponse response) {
		this.mailbox = vm;
		this.response = response;
	}

	/**
	 * Gets the response.
	 *
	 * @return the response
	 */
	public MailboxResponse getResponse() {
		return response;
	}

	/**
	 * Sets the response.
	 *
	 * @param response the new response
	 */
	public void setResponse(MailboxResponse response) {
		this.response = response;
	}

	/**
	 * Gets the vm.
	 *
	 * @return the vm
	 */
	public MailboxSearchResponse getMailbox() {
		return mailbox;
	}

	/**
	 * Sets the vm.
	 *
	 * @param vm the new vm
	 */
	public void setMailbox(MailboxSearchResponse vm) {
		this.mailbox = vm;
	}
}
