package com.mavenir.vmp.export;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jakarta.validation.Validator;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.metadata.BeanDescriptor;
import jakarta.validation.metadata.ConstraintDescriptor;
import jakarta.validation.metadata.PropertyDescriptor;
import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.common.base.Throwables;

/**
 * Service for collecting exported metadata used on client-side.
 *
 */
@Service
public class MetadataService {

	/** Bean validation constants for validatable classes. */
	private final Map<String, Object> constraints;

	/** Field values for enum constants. */
	private final Map<String, Object> enums;

	@Autowired
	public MetadataService(Validator validator, Reflections reflections) {
		HashMap<String, Object> constraints = new HashMap<String, Object>();
		HashMap<String, Object> enums = new HashMap<String, Object>();

		for (Class<?> clazz : reflections.getTypesAnnotatedWith(ExportType.class)) {
			String simpleName = clazz.getSimpleName();
			if (clazz.isEnum()) {
				enums.put(simpleName, findEnumValues(clazz));
			} else if (!Modifier.isAbstract(clazz.getModifiers())) {
				constraints.put(simpleName, findClassConstraints(clazz, validator));
			}
		}

		this.constraints = Collections.unmodifiableMap(constraints);
		this.enums = Collections.unmodifiableMap(enums);
	}

	/**
	 * Scans validatable classes for bean validation constraints.
	 *
	 * @param clazz class to scan
	 * @param validator bean validation validator
	 */
	private Map<String, Object> findClassConstraints(Class<?> clazz, Validator validator) {
		Map<String, Object> fields = new HashMap<String, Object>();
		BeanDescriptor bean = validator.getConstraintsForClass(clazz);

		for (PropertyDescriptor property : bean.getConstrainedProperties()) {
			fields.put(property.getPropertyName(), findFieldConstraints(property));
		}

		for (Field field : clazz.getDeclaredFields()) {
			String name = field.getName();
			if (!fields.containsKey(name)) {
				fields.put(name, findTypeConstraints(field.getType()));
			}
		}

		return fields;
	}

	/**
	 * Returns bean validation constaints for specified field.
	 *
	 * @param property property descriptor
	 */
	private Map<String, Object> findFieldConstraints(PropertyDescriptor property) {
		Class<?> elementClass = property.getElementClass();
		Map<String, Object> fieldConstraints = findTypeConstraints(elementClass);

		for (ConstraintDescriptor<?> constraint : property.getConstraintDescriptors()) {
			String constraintName = constraint.getAnnotation().annotationType().getSimpleName();
			Map<String, Object> attributes = new HashMap<String, Object>(constraint.getAttributes());
			attributes.keySet().removeAll(Arrays.asList("groups", "message", "payload"));
			fieldConstraints.put(constraintName, attributes);
		}

		return fieldConstraints;
	}

	/**
	 * Returns bean validation constaints for specified type.
	 *
	 * @param clazz class object
	 */
	private Map<String, Object> findTypeConstraints(Class<?> clazz) {
		Map<String, Object> fieldConstraints = new HashMap<String, Object>();
		fieldConstraints.put("type", clazz.getSimpleName());
		if (clazz.isPrimitive()) {
			fieldConstraints.put(NotNull.class.getSimpleName(), Collections.emptyMap());
		}
		return fieldConstraints;
	}

	/**
	 * Scans enum constants.
	 *
	 * @param clazz class to scan
	 * @return
	 */
	private List<Object> findEnumValues(Class<?> clazz) {
		List<Field> fields = new ArrayList<Field>();
		for (Field field : clazz.getDeclaredFields()) {
			ExportField exportField = field.getAnnotation(ExportField.class);
			boolean exported = exportField != null ? exportField.value() : true;

			if (!field.isEnumConstant() && !field.getName().contains("$") && exported) {
				field.setAccessible(true);
				fields.add(field);
			}
		}

		List<Object> enumValues = new ArrayList<Object>();

		for (Object object : clazz.getEnumConstants()) {
			Enum<?> value = (Enum<?>) object;
			Map<String, Object> fieldValues = new HashMap<String, Object>();

			fieldValues.put("name", value.name());
			for (Field field : fields) {
				try {
					fieldValues.put(field.getName(), field.get(value));
				} catch (Exception e) {
					throw Throwables.propagate(e);
				}
			}
			enumValues.add(fieldValues);
		}

		return enumValues;
	}

	public Map<String, Object> getConstraints() {
		return constraints;
	}

	public Map<String, Object> getEnums() {
		return enums;
	}

}
