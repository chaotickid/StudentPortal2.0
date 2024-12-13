/**
 * 
 */
package com.mavenir.vmp.mailbox.storage;

import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author Dhinesh Prasad, Mavenir Systems
 *
 */

//@Embeddable
public class RequestDataPK implements Serializable{
	
	private static final long serialVersionUID = -5254744731634927448L;

	@NotNull
	private String type;
	
	@NotNull
	private String id;

	public RequestDataPK() {
		super();
	}

	public RequestDataPK(String type, String id) {
		super();
		this.type = type;
		this.id = id;
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
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return (type + id).hashCode();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
        if (obj == null) return false;
        if (!(obj instanceof RequestDataPK)) return false;
        RequestDataPK pk = (RequestDataPK) obj;
        return pk.type.equals(type) && pk.id.equals(id);
	}
}