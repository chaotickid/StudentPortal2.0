package com.mavenir.vmp.user;

import jakarta.validation.constraints.Size;

/**
 * Abstract group.
 *
 */
public class AbstractGroup {

	/** External security system group name. */
	@Size(max = 100)
	private String mappedName;

	public String getMappedName() {
		return mappedName;
	}

	public void setMappedName(String mappedName) {
		this.mappedName = mappedName;
	}

}
