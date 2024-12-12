package com.mavenir.vmp.user;

import org.joda.time.DateTime;
import org.springframework.data.jpa.domain.AbstractPersistable;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Abstract user.
 *
 */
@MappedSuperclass
public class AbstractUser extends AbstractPersistable<Long> {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@NotNull
	@Size(min = 2, max = 50)
	private String username;

	@NotNull
	@Size(min = 2, max = 50)
	private String firstName;

	@NotNull
	@Size(min = 2, max = 50)
	private String lastName;

	@NotNull
	@Enumerated(EnumType.STRING)
	private Role role;

	private DateTime lastModified;

	/** Flag indicating is used account enabled. */
	private boolean enabled;

	/** The unlocked. */
	private boolean locked;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public DateTime getLastModified() {
		return lastModified;
	}

	public void setLastModified(DateTime lastModified) {
		this.lastModified = lastModified;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean active) {
		this.locked = active;
	}
}
