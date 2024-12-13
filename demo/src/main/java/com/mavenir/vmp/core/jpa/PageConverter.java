package com.mavenir.vmp.core.jpa;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.internal.typetools.TypeResolver;
import org.modelmapper.internal.util.Types;
import org.modelmapper.spi.ConditionalConverter;
import org.modelmapper.spi.Mapping;
import org.modelmapper.spi.MappingContext;
import org.modelmapper.spi.PropertyInfo;
import org.modelmapper.spi.PropertyMapping;
import org.springframework.core.ResolvableType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

/**
 * Converter for Page instances.
 *
 */
public class PageConverter implements ConditionalConverter<Page<Object>, Page<Object>> {

	@Override
	public MatchResult match(Class<?> sourceType, Class<?> destinationType) {
		if (Page.class.isAssignableFrom(sourceType) && Page.class.isAssignableFrom(destinationType)) {
			return MatchResult.FULL;
		} else {
			return MatchResult.NONE;
		}
	}

	@Override
	public Page<Object> convert(MappingContext<Page<Object>, Page<Object>> context) {
		Page<Object> source = context.getSource();
		if (source == null) {
			return null;
		}

		Class<?> elementType = getElementType(context);
		List<Object> content = new ArrayList<Object>(source.getContent().size());

		for (Object sourceElement : source.getContent()) {
			Object element;
			if (sourceElement == null) {
				element = null;
			} else {
				MappingContext<?, ?> elementContext = context.create(sourceElement, elementType);
				element = context.getMappingEngine().map(elementContext);
			}

			content.add(element);
		}

		PageRequest pageable = PageRequest.of(source.getNumber(), source.getSize(), source.getSort());
		return new PageImpl<Object>(content, pageable, source.getTotalElements());
	}

	/**
	 * Returns the contained element type for the given mapping context.
	 *
	 * Copied from {@link org.modelmapper.internal.converter.CollectionConverter CollectionConverter}.
	 *
	 * @param context mapping context
	 */
	//TODO:: alternate approach used
	/*private Class<?> getElementType(MappingContext<Page<Object>, Page<Object>> context) {
		Mapping mapping = context.getMapping();

		if (mapping instanceof PropertyMapping) {
			PropertyInfo info = ((PropertyMapping) mapping).getLastDestinationProperty();
			Class<?> type = TypeResolver.resolveArgument(info.getGenericType(), info.getInitialType());
//			return null;
			return type == Unknown.class ? Object.class : type;
		} else if (context.getGenericDestinationType() instanceof ParameterizedType) {
			ParameterizedType type = (ParameterizedType) context.getGenericDestinationType();
			return Types.rawTypeFor(type.getActualTypeArguments()[0]);
		} else {
			return Object.class;
		}
	}*/
	private Class<?> getElementType(MappingContext<Page<Object>, Page<Object>> context) {
		Mapping mapping = context.getMapping();

		if (mapping instanceof PropertyMapping) {
			PropertyInfo info = ((PropertyMapping) mapping).getLastDestinationProperty();

			// Resolve the generic argument using ResolvableType
			ResolvableType resolvableType = ResolvableType.forType(info.getGenericType());
			Class<?> resolvedType = resolvableType.resolve();

			return resolvedType == TypeResolver.Unknown.class ? Object.class : resolvedType;
		} else if (context.getGenericDestinationType() instanceof ParameterizedType) {
			// Handle ParameterizedType cases with ResolvableType
			ResolvableType resolvableType = ResolvableType.forType(context.getGenericDestinationType());
			return resolvableType.getGenerics()[0].resolve(Object.class);
		} else {
			return Object.class;
		}
	}

}