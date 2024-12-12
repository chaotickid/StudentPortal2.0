/**
 *
 */
package com.mavenir.vmp.user;

import com.mavenir.vmp.export.ExportType;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.Page;

import jakarta.validation.constraints.NotNull;
import java.lang.reflect.Type;
import java.util.List;

/**
 *
 */
@ExportType
public class UserVM extends AbstractUser {

	/** ModelMapper list type. */
	public static final Type LIST_TYPE = (new TypeToken<List<UserVM>>() {	}).getType();

	/** ModelMapper list type. */
	public static final Type PAGE_TYPE = (new TypeToken<Page<UserVM>>() {	}).getType();

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/** Encrypted login password. */
	@NotNull
	private String password;

	@Override
	public void setId(Long id) {
		super.setId(id);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
