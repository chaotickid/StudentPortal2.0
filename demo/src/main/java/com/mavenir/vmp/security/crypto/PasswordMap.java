package com.mavenir.vmp.security.crypto;

import com.mavenir.vmp.user.EditUserVM;
import com.mavenir.vmp.user.User;
import com.mavenir.vmp.user.UserPasswordVM;
import com.mavenir.vmp.user.UserVM;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Condition;
import org.modelmapper.Converter;
import org.modelmapper.PropertyMap;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Password map.
 *
 */
@Service
public class PasswordMap {

	/** Condition. */
	private final Condition<String, String> condition;

	/** Encode. */
	private final Converter<String, String> encode;

	@Autowired
	public PasswordMap(final Crypto crypto, final PasswordEncoder passwordEncoder) {
		this.condition = new Condition<String, String>() {

			@Override
			public boolean applies(MappingContext<String, String> context) {
				return context.getSource() != null;
			}

		};

		this.encode = new AbstractConverter<String, String>() {

			@Override
			protected String convert(String source) {
				return passwordEncoder.encode(source);
			}

		};
	}

	/**
	 * User map.
	 *
	 */
	public static class UserMap extends PropertyMap<User, UserVM> {

		@Override
		protected void configure() {
			skip().setPassword(null);
		}

	}

	/**
	 * User model map.
	 *
	 */
	public class UserModelMap extends PropertyMap<UserVM, User> {

		@Override
		protected void configure() {
			when(condition).using(encode).map().setPassword(source.getPassword());
		}
	}

	/**
	 * User model map.
	 *
	 */
	public class EditUserModelMap extends PropertyMap<EditUserVM, User> {

		@Override
		protected void configure() {
			when(condition).using(encode).map().setPassword(source.getPassword());
		}
	}

	 /**
   * Password user map.
   *
   */
	public class PasswordUserMap extends PropertyMap<UserPasswordVM, User> {

		@Override
		protected void configure() {
			when(condition).using(encode).map().setPassword(source.getNewPassword());
		}

	}

}
