/**
 * 
 */
package com.mavenir.vmp.mailbox.storage;

import org.joda.time.DateTime;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

/**
 * @author Dhinesh Prasad, Mavenir Systems
 *
 */

@Entity
@IdClass(RequestDataPK.class)
@Table(name = "request_data")
public class RequestData {

	@NotNull
	@Id
	private String type;
	
	@NotNull
	@Id
	private String id;
	
	@Column(name="expiry_time", nullable=false)
	private DateTime expiryTime;
	
	@Column
	private String node;

	public RequestData() {
		super();
	}

	public RequestData(String type, String id, String node, DateTime expiryTime) {
		super();
		this.type = type;
		this.id = id;
		this.node = node;
		this.expiryTime = expiryTime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public DateTime getExpiryTime() {
		return expiryTime;
	}

	public void setExpiryTime(DateTime expiryTime) {
		this.expiryTime = expiryTime;
	}

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}
	
}
