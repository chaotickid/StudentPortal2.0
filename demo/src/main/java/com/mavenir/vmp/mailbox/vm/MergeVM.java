/**
 *
 */
package com.mavenir.vmp.mailbox.vm;

import com.mavenir.vmp.export.ExportType;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

/**
 * @author developer, OptimIT
 *
 */
@ExportType
public class MergeVM {

	@NotNull
	private String primaryMsisdn;

	@NotNull
	@Size(min = 1)
	private Set<String> secondaryMsisdns;

	public MergeVM() {
		this.secondaryMsisdns = new HashSet<String>();
	}

	public String getPrimaryMsisdn() {
		return primaryMsisdn;
	}

	public void setPrimaryMsisdn(String primaryMsisdn) {
		this.primaryMsisdn = primaryMsisdn;
	}

	public Set<String> getSecondaryMsisdns() {
		return secondaryMsisdns;
	}

	public void setSecondaryMsisdns(Set<String> secondaryMsisdns) {
		this.secondaryMsisdns = secondaryMsisdns;
	}
}
