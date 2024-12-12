/**
 *
 */
package com.mavenir.vmp.user;

import com.mavenir.vmp.export.ExportType;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * The Class UserPropertiesVM.
 *
 * @author Vlatka, OptimIT
 */
@ExportType
public class UserPropertiesVM {

	/** The first name. */
	@NotNull
	@Size(min = 2, max = 50)
	private String firstName;

	/** The last name. */
	@NotNull
	@Size(min = 2, max = 50)
	private String lastName;

	/** The username. */
	private String username;

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
