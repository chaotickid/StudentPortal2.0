package com.mavenir.vmp.core;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import com.mavenir.vmp.core.jpa.PageConverter;
import com.mavenir.vmp.external.DropdownElement;
//import com.mavenir.vmp.security.crypto.PasswordMap;

/**
 * ModelMapper configuration.
 */
@Configuration
public class MapperConfig {

	/**
	 * Returns the ModelMapper.
	 *
	 * @param reflections Reflections
	 * @return model mapper
	 */
//	@Bean
//	public ModelMapper modelMapper(PasswordMap passwordMap) {
//		ModelMapper mapper = new ModelMapper();
//		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//		mapper.addMappings(new PasswordMap.UserMap());
//		mapper.addMappings(passwordMap.new UserModelMap());
//		mapper.addMappings(passwordMap.new EditUserModelMap());
//		mapper.addMappings(passwordMap.new PasswordUserMap());
//		mapper.getConfiguration().getConverters().add(0, new PageConverter());
//		mapper.addMappings(new DropdownMapToInteger());
//		mapper.addMappings(new DropdownMapToString());
//		return mapper;
//	}

	@Service
	private static class DropdownMapToInteger extends PropertyMap<DropdownElement, Integer> {
		@Override
		protected void configure() {
			if (source.getValue() != null) {
				destination = Integer.parseInt(source.getValue());
			}
		}
	}

	@Service
	private static class DropdownMapToString extends PropertyMap<DropdownElement, String> {
		@Override
		protected void configure() {
			if (source.getValue() != null) {
				destination = source.getValue();
			}
		}
	}

}
