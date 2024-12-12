/**
 *
 */
package com.mavenir.vmp.external;

/**
 * The Class DropdownElement.
 *
 * @author Vlatka, OptimIT
 */
public class DropdownElement {

	/** The value. */
	private String value;

	/** The text. */
	private String text;

	/**
	 * Instantiates a new dropdown element.
	 */
	public DropdownElement() {

	}

	/**
	 * Instantiates a new dropdown element.
	 *
	 * @param value the value
	 * @param text the text
	 */
	public DropdownElement(String value, String text) {
		this.value = value;
		this.text = text;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 *
	 * @param value the new value
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * Gets the text.
	 *
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Sets the text.
	 *
	 * @param text the new text
	 */
	public void setText(String text) {
		this.text = text;
	}

}
