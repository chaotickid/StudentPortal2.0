/**
 *
 */
package com.mavenir.vmp.utils;

/**
 * The Class ObjectUtil.
 *
 * @author Vlatka, OptimIT
 */
public final class ObjectUtil {

	private ObjectUtil() {

	}

	/**
	 * Checks if is only one null.
	 *
	 * @param value1 the value1
	 * @param value2 the value2
	 * @return true, if is only one null
	 */
	public static boolean isOnlyOneNull(Object value1, Object value2) {
		return
			(value1 == null && value2 != null) ||
			(value1 != null && value2 == null);
	}

	public static boolean isOnlyOneNullOrEmpty(String value1, String value2) {
		return
			(value1 == null && value2 != null && !value2.isEmpty()) ||
			(value1 != null && !value1.isEmpty() && value2 == null);
	}

	/**
	 * Are all null or empty.
	 *
	 * @param value1 the value1
	 * @param value2 the value2
	 * @return true, if successful
	 */
	public static boolean areAllNullOrEmpty(String value1, String value2) {
		return
			(value1 == null || value1.isEmpty()) && (value2 == null || value2.isEmpty());
	}

	/**
	 * Are all null.
	 *
	 * @param objects the objects
	 * @return true, if successful
	 */
	public static boolean areAllNull(Object... objects) {
		for (Object object : objects) {
			if (object != null) {
				return false;
			}
		}
		return true;
	}

}
