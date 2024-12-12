/**
 *
 */
package com.mavenir.vmp.utils;

import java.util.Random;

/**
 * @author Vlatka, OptimIT
 */
public final class StringUtil {

	private StringUtil() {

	}

	/**
	 * The Enum string type.
	 */
	public enum Type {

		/** The numeric. */
		NUMERIC,

		/** The alpha lower. */
		ALPHA_LOWER,

		/** The alpha upper. */
		ALPHA_UPPER,

		/** The alpha lower upper. */
		ALPHA_LOWER_UPPER,

		/** The alphanumeric. */
		ALPHANUMERIC;
	}

	/**
	 * Generate numeric string.
	 *
	 * @param minLength the min length
	 * @param maxLength the max length
	 * @param type the type
	 * @return the string
	 */
	public static String generateRandomString(int minLength, int maxLength, Type type) {
		String characters = getStringType(type);
		int length = IntegerUtil.getIntegerInRange(minLength, maxLength);
		Random random = new Random();
		char[] text = new char[length];
		for (int i = 0; i < length; i++) {
			text[i] = characters.charAt(random.nextInt(characters.length()));
		}
		return new String(text);
	}

	/**
	 * Gets the alphabet in upper case.
	 *
	 * @return the alphabet upper
	 */
	public static String getAlphabetUpper() {
		StringBuilder builder = new StringBuilder("");
		for (char alphabet = 'A'; alphabet <= 'Z'; alphabet++) {
			builder.append(alphabet);
		}
		return builder.toString();
	}

	/**
	 * Gets the alphabet in lower case.
	 *
	 * @return the alphabet lower
	 */
	public static String getAlphabetLower() {
		StringBuilder builder = new StringBuilder("");
		for (char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
			builder.append(alphabet);
		}
		return builder.toString();
	}

	/**
	 * Gets the alphabet in lower and upper case.
	 *
	 * @return the alphabet lower and upper
	 */
	public static String getAlphabetLowerAndUpper() {
		StringBuilder builder = new StringBuilder("");
		builder.append(getAlphabetLower());
		builder.append(getAlphabetUpper());
		return builder.toString();
	}

	/**
	 * Gets the numbers.
	 *
	 * @return the numbers
	 */
	public static String getNumbers() {
		StringBuilder builder = new StringBuilder("");
		for (char alphabet = '0'; alphabet <= '9'; alphabet++) {
			builder.append(alphabet);
		}
		return builder.toString();
	}

	/**
	 * Gets the alphabet in lower and upper case and numbers.
	 *
	 * @return the alphabet and numbers
	 */
	public static String getAlphabetAndNumbers() {
		StringBuilder builder = new StringBuilder("");
		builder.append(getAlphabetLowerAndUpper());
		builder.append(getNumbers());
		return builder.toString();
	}

	/**
	 * Gets the first n characters. If number of characters is greater than string length, whole string is returned.
	 *
	 * @param string the string
	 * @param numberOfCharacters the number of characters
	 * @return the first n characters
	 */
	public static String getFirstNCharacters(String string, int numberOfCharacters) {
		if (numberOfCharacters > string.length()) {
			return string;
		}
		return string.substring(0, numberOfCharacters);
	}

	/**
	 * Gets the last n characters. If number of characters is greater than string length, whole string is returned.
	 *
	 * @param string the string
	 * @param numberOfCharacters the number of characters
	 * @return the last n characters
	 */
	public static String getLastNCharacters(String string, int numberOfCharacters) {
		if (numberOfCharacters > string.length()) {
			return string;
		}
		return string.substring(string.length() - numberOfCharacters, string.length());
	}

	/**
	 * Gets the string type.
	 *
	 * @param type the type
	 * @return the string type
	 */
	private static String getStringType(Type type) {
		switch (type) {
		case ALPHA_LOWER:
			return getAlphabetLower();
		case ALPHA_UPPER:
			return getAlphabetUpper();
		case ALPHA_LOWER_UPPER:
			return getAlphabetLowerAndUpper();
		case ALPHANUMERIC:
			return getAlphabetAndNumbers();
		case NUMERIC:
			return getNumbers();
		default:
			return "";
		}
	}
}
