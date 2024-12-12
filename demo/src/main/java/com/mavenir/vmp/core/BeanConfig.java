package com.mavenir.vmp.core;

import java.util.HashSet;
import java.util.Set;
import org.reflections.Reflections;
//import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
//import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
//import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
//import com.mavenir.vmp.Application;

/**
 * Configuration for bean classes.
 */
@Configuration
public class BeanConfig {

//	@Bean
//	public EmbeddedServletContainerCustomizer containerCustomizer() {
//		return new EmbeddedServletContainerCustomizer() {
//			@Override
//			public void customize(ConfigurableEmbeddedServletContainer container) {
//				container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"));
//			}
//		};
//	}

	/**
	 * Returns password encoder.
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * Returns reflections for all classes under the base package.
	 *
	 * @return reflections
	 */
//	@Bean
//	public Reflections reflections() {
//		return new Reflections(Application.class.getPackage().getName());
//	}

	/**
	 * Returns subtype module.
	 *
	 * @param reflections reflections
	 * @return subtype module
	 */
	@Bean
	public Module subtypeModule(Reflections reflections) {
		return new SubtypeModule(reflections);
	}

	/**
	 * Returns Jackson Joda module.
	 *
	 * @return joda module
	 */
	@Bean
	public JodaModule jodaModule() {
		return new JodaModule();
	}

	/**
	 * Returns the JSR-303 bean validator.
	 *
	 * @return validator factory
	 */
	@Bean
	public LocalValidatorFactoryBean validator() {
		return new LocalValidatorFactoryBean();
	}

	/**
	 * Returns object mapper.
	 *
	 * @return object mapper
	 */
	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return objectMapper;
	}

	@Bean
	public XmlMapper xmlMapper() {
		XmlMapper mapper = new XmlMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//		mapper.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
		return mapper;
	}

	/**
	 * Subtype module.
	 */
	private static final class SubtypeModule extends SimpleModule {

		/** Serial version UID. */
		private static final long serialVersionUID = 1L;

		/**
		 * @param reflections reflections
		 */
		public SubtypeModule(Reflections reflections) {
			Set<Class<?>> classes = new HashSet<Class<?>>();
			for (Class<?> clazz : reflections.getTypesAnnotatedWith(JsonTypeInfo.class)) {
				classes.addAll(reflections.getSubTypesOf(clazz));
			}
			registerSubtypes(classes.toArray(new Class<?>[classes.size()]));
		}

	}
}
