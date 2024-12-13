package com.mavenir.vmp.mailbox.template;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.mavenir.vmp.mailbox.model.MailboxResponse;

import java.util.List;

/**
 * The Class VmpTemplates.
 */
@JacksonXmlRootElement(localName = "vmp_templates_basic")
public class VmpTemplatesBasic {

	/** The error cause. */
	private MailboxResponse response;

	/** The template. */
	@JacksonXmlProperty(localName = "vmp_template_basic")
	@JacksonXmlElementWrapper(useWrapping = false)
	private List<VmpTemplateBasic> vmpTemplateBasic;

	/**
	 * Gets the template.
	 *
	 * @return the template
	 */
	public List<VmpTemplateBasic> getTemplate() {
		return this.vmpTemplateBasic;
	}

	/**
	 * Sets the template.
	 *
	 * @param template the new template
	 */
	public void setTemplate(List<VmpTemplateBasic> template) {
		this.vmpTemplateBasic = template;
	}

	/**
	 * Gets the error cause.
	 *
	 * @return the error cause
	 */
	public MailboxResponse getResponse() {
		return response;
	}

	/**
	 * Sets the error cause.
	 *
	 * @param errorCause the new error cause
	 */
	public void setResponse(MailboxResponse response) {
		this.response = response;
	}
}
