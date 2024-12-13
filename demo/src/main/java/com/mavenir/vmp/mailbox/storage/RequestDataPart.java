/**
 * 
 */
package com.mavenir.vmp.mailbox.storage;

/**
 * @author Dhinesh Prasad, Mavenir Systems
 *
 */
public class RequestDataPart {
	
	public String id;
	
	public String node;

	public RequestDataPart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RequestDataPart(String id, String node) {
		super();
		this.id = id;
		this.node = node;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}
	
}
