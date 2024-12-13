package com.mavenir.vmp.mailbox.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * The Class EditSubscriberRequest.
 */
@JacksonXmlRootElement(localName = "attributes")
public class EditSubscriberRequest extends AbstractSubscriberRequest {

	/** The msisdn. */
	private String newMsisdn;

	/** The subscriber blocked. */
	private String subscriberBlocked;

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
