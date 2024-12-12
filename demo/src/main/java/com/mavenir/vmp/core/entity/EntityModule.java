package com.mavenir.vmp.core.entity;

import jakarta.persistence.Entity;

import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.module.SimpleModule;

/**
 * Entity module.
 *
 */
@Component
public class EntityModule extends SimpleModule {

	/** Serial version UID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructs new Jackson entity module.
	 *
	 * @param entityClass entity class
	 * @param context application context
	 */
	@Autowired
	public EntityModule(Reflections reflections) {
		for (Class<?> entityClass : reflections.getTypesAnnotatedWith(Entity.class)) {
			addEntitySerializer(entityClass);
		}
	}

	/**
	 * Registers entity serializer for the given entity class.
	 *
	 * @param <T> entity type
	 * @param entityClass entity class
	 */
	private <T> void addEntitySerializer(Class<T> entityClass) {
		addSerializer(entityClass, new EntitySerializer<T>());
	}

}
