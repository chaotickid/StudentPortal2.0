package com.mavenir.vmp.mailbox.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * The Class MailboxVM.
 */
public class MailboxSearchResponse {

	/** The msisdn. */
	private String msisdn;

	/** The attribute list. */
	@JacksonXmlProperty(localName = "attributeList")
	private MailboxSearchResponseAttributes attributeList;

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
	 * Gets the attribute list.
	 *
	 * @return the attribute list
	 */
	public MailboxSearchResponseAttributes getAttributeList() {
		return attributeList;
	}

	/**
	 * Sets the attribute list.
	 *
	 * @param attributeList the new attribute list
	 */
	public void setAttributeList(MailboxSearchResponseAttributes attributeList) {
		this.attributeList = attributeList;
	}

}
