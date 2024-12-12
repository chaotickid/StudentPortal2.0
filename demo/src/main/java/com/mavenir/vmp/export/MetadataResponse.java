package com.mavenir.vmp.export;

import java.util.Map;

/**
 * Metadata response.
 *
 */
public class MetadataResponse {

	/**
	 * Constants metadata.
	 */
	private final Map<String, Object> constraints;

	/**
	 * Enums metadata.
	 */
	private final Map<String, Object> enums;

	public MetadataResponse(Map<String, Object> constraints, Map<String, Object> enums) {
		this.constraints = constraints;
		this.enums = enums;
	}

	public Map<String, Object> getConstraints() {
		return constraints;
	}

	public Map<String, Object> getEnums() {
		return enums;
	}

}
