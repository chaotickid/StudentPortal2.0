package com.mavenir.vmp.mailbox.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * The Class CreateSubscriberRequest.
 */
@JacksonXmlRootElement(localName = "attributes")
public class CreateSubscriberRequest extends AbstractSubscriberRequest {

	/** The template. */
	private String template;

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

}
