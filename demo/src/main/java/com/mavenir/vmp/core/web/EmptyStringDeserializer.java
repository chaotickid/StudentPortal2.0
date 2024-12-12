package com.mavenir.vmp.core.web;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * JSON deserializer that trims all strings except passwords.
 *
 * Empty strings are transformed into null values.
 *
 */
public class EmptyStringDeserializer extends JsonDeserializer<String> {

	/** String deserializer. */
	private final JsonDeserializer<String> deserializer;

	/**
	 * Creates string trimmer deserializer from the default Jackson string deserializer.
	 */
	public EmptyStringDeserializer() {
		this(StringDeserializer.instance);
	}

	/**
	 * Creates string trimmer deserializer from the given string deserializer.
	 *
	 * @param deserializer string deserializer
	 */
	public EmptyStringDeserializer(JsonDeserializer<String> deserializer) {
		this.deserializer = deserializer;
	}

	/**
	 * Returns deserialized trimmed string.
	 *
	 * @param jp JSON parser
	 * @param ctxt deserialization context
	 */
	@Override
	public String deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
		String value = deserializer.deserialize(jp, ctxt);
		return value.isEmpty() ? null : value;
	}

	/**
	 * Empty string deserializer module.
	 *
	 */
	@Component
	public static class EmptyStringDeserializerModule extends SimpleModule {

		/** Serial version UID. */
		private static final long serialVersionUID = 1L;

		public EmptyStringDeserializerModule() {
			addDeserializer(String.class, new EmptyStringDeserializer());
		}

	}

}
