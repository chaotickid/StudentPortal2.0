/**
 *
 */
package com.mavenir.vmp.utils;

import java.util.Random;

/**
 * @author Vlatka, OptimIT
 *
 */
public final class IntegerUtil {

	private IntegerUtil() {

	}

	/**
	 * Gets the integer in range.
	 *
	 * @param min the min
	 * @param max the max
	 * @return the integer in range
	 */
	public static int getIntegerInRange(int min, int max) {
		Random random = new Random();
		int number = random.nextInt((max - min) + 1) + min;
		return number;
	}

}
