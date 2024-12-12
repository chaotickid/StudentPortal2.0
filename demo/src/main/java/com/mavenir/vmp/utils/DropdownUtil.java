/**
 *
 */
package com.mavenir.vmp.utils;

import java.util.ArrayList;
import java.util.List;
import com.google.common.base.Strings;
import com.mavenir.vmp.external.DropdownElement;

/**
 * @author Vlatka, OptimIT
 *
 */
public final class DropdownUtil {

	private DropdownUtil() {

	}

	/**
	 * Parses the dropdown values.
	 *
	 * @param stringValues the string values
	 * @return the list
	 */
	public static List<DropdownElement> parseDropdownValues(String stringValues) {
		List<DropdownElement> dropdownValues = new ArrayList<DropdownElement>();
		if (stringValues == null || stringValues.trim().isEmpty()) return dropdownValues;
		String[] elements = stringValues.split(",");
		for (String element : elements) {
			String[] pair = element.trim().split(":");
			String value = pair[0].trim();
			String text = pair[1].trim();
			dropdownValues.add(new DropdownElement(value, text));
		}
		return dropdownValues;
	}

	/**
	 * Gets the dropdown element text.
	 *
	 * @param dropdown the dropdown
	 * @param elementValue the element value
	 * @return the dropdown element text
	 */
	public static DropdownElement getDropdownElement(List<DropdownElement> dropdown, String elementValue) {
		for (DropdownElement element : dropdown) {
			if (element.getValue().equalsIgnoreCase(elementValue)) {
				return element;
			}
		}
		return null;
	}

	/**
	 * Check dropdown validity.
	 *
	 * @param stringValues the string values
	 * @return the string
	 */
	public static String checkDropdownValidity(String stringValues, String propertyName) {
		String[] elements = stringValues.split(",");
		if (stringValues.isEmpty() || elements.length == 0) {
			return "Dropdown elements for property " + propertyName + " are not defined or not in correct format (dropdown elements must be " +
					"separated by ',', system and text value in each dropdown element must be separated by ':')";
		}
		for (String element : elements) {
			String errorMsg = "Dropdown element for property " + propertyName + " is not in correct format. Element's system and text value " +
					"should be both defined and separated by ':' ({system_value}:{text_value}) but are: '" + element + "'";
			String[] pair = element.trim().split(":");
			if (pair.length != 2) {
				return errorMsg;
			}
			String value = pair[0].trim();
			String text = pair[1].trim();
			if (Strings.isNullOrEmpty(value) || Strings.isNullOrEmpty(text)) {
				return errorMsg;
			}
		}
		return "";
	}

	/**
	 * Check dropdown system value integer.
	 *
	 * @param stringValues the string values
	 * @param propertyName the property name
	 * @return the string
	 */
	public static String checkDropdownSystemValueInteger(String stringValues, String propertyName) {
		String[] elements = stringValues.split(",");
		for (String element : elements) {
			String[] pair = element.trim().split(":");
			String value = pair[0].trim();
			try {
				Integer.parseInt(value);
			} catch (Exception e) {
				return "System value for dropdown element '" + element + "' of property " + propertyName + " must be integer but is '" + value + "'";
			}
		}
		return "";
	}
}
