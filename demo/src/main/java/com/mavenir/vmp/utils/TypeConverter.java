/**
 *
 */
package com.mavenir.vmp.utils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

/**
 * The Class TypeConverter.
 */
public final class TypeConverter {

	/**
	 * The conversion map.
	 */
	private static Map<Class<?>, Map<Class<?>, Method>> conversionMap;

	static {
		loadMappings();
	}

	private TypeConverter() {

	}

	/**
	 * Load mappings.
	 */
	private static void loadMappings() {
		conversionMap = new HashMap<Class<?>, Map<Class<?>, Method>>();
		try {
			conversionMap.put(String.class, new HashMap<Class<?>, Method>());
			conversionMap.get(String.class).put(Integer.class, Integer.class.getMethod("parseInt", String.class));
			conversionMap.get(String.class).put(Long.class, Long.class.getMethod("parseLong", String.class));
			conversionMap.get(String.class).put(Boolean.class, Boolean.class.getMethod("parseBoolean", String.class));
			conversionMap.get(String.class).put(Byte.class, Byte.class.getMethod("parseByte", String.class));
			conversionMap.get(String.class).put(Double.class, Double.class.getMethod("parseDouble", String.class));
			conversionMap.get(String.class).put(Float.class, Float.class.getMethod("parseFloat", String.class));
			conversionMap.get(String.class).put(Short.class, Short.class.getMethod("parseShort", String.class));
		} catch (Exception e) {
			// This should not happen
		}
	}

	/**
	 * Convert.
	 *
	 * @param <T> the generic type
	 * @param <E> the element type
	 * @param value the value
	 * @param to the to
	 * @return the e
	 */
	public static <T, E> E convert(T value, Class<E> to) {
		if (value == null || to == null) {
			throw new IllegalArgumentException("Input and/or destination type value can not be null");
		}
		// No conversion necessary
		if (value.getClass().equals(to)) {
			return to.cast(value);
		}

		if (conversionMap != null && conversionMap.containsKey(value.getClass())) {
			Map<Class<?>, Method> mapping = conversionMap.get(value.getClass());
			if (mapping != null && mapping.containsKey(to)) {
				Method method = mapping.get(to);
				method.setAccessible(true);
				try {
					return to.cast(method.invoke(to, value));
				} catch (Exception e) {
					throw new UnsupportedOperationException("Unable to convert value to desired type");
				}
			}
		}
		throw new UnsupportedOperationException("Unable to convert value to desired type");
	}

	/**
	 * Convert.
	 *
	 * @param <T> the generic type
	 * @param <E> the element type
	 * @param value the value
	 * @param to the to
	 * @return the list
	 */
	public static <T, E> List<E> convert(List<T> value, final Class<E> to) {
		if (value == null || to == null) {
			throw new IllegalArgumentException("Input and/or destination type value can not be null");
		}
		return Lists.transform(value, new Function<T, E>() {

			@Override
			public E apply(T input) {
				return convert(input, to);
			}
		});
	}
}
