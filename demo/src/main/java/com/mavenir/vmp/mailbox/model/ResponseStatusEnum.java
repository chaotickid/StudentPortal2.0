/**
 *
 */
package com.mavenir.vmp.mailbox.model;

import com.mavenir.vmp.export.ExportType;

/**
 * @author Vlatka, OptimIT
 *
 */
@ExportType
public enum ResponseStatusEnum {

	BAD_ATTRIBUTES("05"),
	SUCCESS("01"),
	SUBSCRIBER_DOESNT_EXIST("04"),
	SYSTEM_ERROR("99"),
	INTERNAL_ERROR("08");

	private String code;

	private ResponseStatusEnum(String code) {
		this.code = code;
	}

	public boolean equalsCode(String code) {
		return this.code.equalsIgnoreCase(code);
	}

	public String getCode() {
		return this.code;
	}
}
