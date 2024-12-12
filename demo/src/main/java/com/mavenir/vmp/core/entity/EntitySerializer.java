package com.mavenir.vmp.core.entity;

import java.io.IOException;

import org.springframework.data.domain.Persistable;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * Serializer that writes entities as their identifier.
 *
 * @param <T> entity type
 */
public class EntitySerializer<T> extends JsonSerializer<T> {

	@Override
	public void serialize(T value, JsonGenerator jgen, SerializerProvider provider) throws IOException {

		Persistable<?> persistable = (Persistable<?>) value;
		Number id = (Number) persistable.getId();
		jgen.writeNumber(id.longValue());
	}

}
