/**
 *
 */
package com.mavenir.vmp.mailbox.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.HashSet;
import java.util.Set;

/**
 * @author developer, OptimIT
 *
 */
@JacksonXmlRootElement(localName = "merge_request")
public class MergeRequest implements Requestable {

	private String requestId;

	private String priMsisdn;

	@JacksonXmlElementWrapper(useWrapping = false)
	private Set<String> secMsisdn;

	private String unifiedCosId;

	public MergeRequest() {
		this.secMsisdn = new HashSet<String>();
	}

	public String getRequestId() {
		return requestId;
	}

	@Override
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getPriMsisdn() {
		return priMsisdn;
	}

	public void setPriMsisdn(String priMsisdn) {
		this.priMsisdn = priMsisdn;
	}

	public Set<String> getSecMsisdn() {
		return secMsisdn;
	}

	public void setSecMsisdn(Set<String> secMsisdn) {
		this.secMsisdn = secMsisdn;
	}

	public String getUnifiedCosId() {
		return unifiedCosId;
	}

	public void setUnifiedCosId(String unifiedCosId) {
		this.unifiedCosId = unifiedCosId;
	}

}
