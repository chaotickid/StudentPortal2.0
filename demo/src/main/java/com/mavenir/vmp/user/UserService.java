package com.mavenir.vmp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * User service.
 *
 */
@Service
public class UserService {

	/** User repository. */
	@Autowired
	private UserRepository repository;

	 /** Password encoder. */
	@Autowired
  private PasswordEncoder passwordEncoder;

	/**
	 * Returns current user.
	 *
	 */
	public User getCurrentUser() {
		SecurityContext context = SecurityContextHolder.getContext();
		Authentication authentication = context.getAuthentication();
		if (authentication == null) {
			return null;
		}
		UserDetails details = (UserDetails) authentication.getPrincipal();
		return repository.findByUsername(details.getUsername());
	}

	/**
	 * Gets the current user role.
	 *
	 * @return the current user role
	 */
	public Role getCurrentUserRole() {
		User user = getCurrentUser();
		if (user != null) {
			return user.getRole();
		}
		return null;
	}

	/**
	 * Checks if is current role.
	 *
	 * @param role the role
	 * @return true, if is current role
	 */
	public boolean hasCurrentRole(Role role) {
		return getCurrentUserRole() == role;
	}

	/**
	 * Checks if is current any role.
	 *
	 * @param roles the roles
	 * @return true, if is current any role
	 */
	public boolean hasCurrentAnyRole(Role currentRole, Role... roles) {
		for (Role role : roles) {
			if (currentRole == role) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns current user role names.
	 */
	public List<String> getCurrentRoles() {
		SecurityContext context = SecurityContextHolder.getContext();
		List<String> roles = new ArrayList<String>();
		for (GrantedAuthority authority : context.getAuthentication().getAuthorities()) {
			String name = authority.getAuthority();
			roles.add(name);
		}
		return roles;
	}

  /**
   * Returns true if the encoded and raw password match, false if they do not.
   * @param rawPassword the raw password
   * @param encodedPassword the encoded password
   */
	public boolean passwordMatches(String rawPassword, String encodedPassword) {
		return passwordEncoder.matches(rawPassword, encodedPassword);
	}

	/**
	 * Saves user.
	 *
	 * @param user the user
	 * @return the user
	 */
	public User save(User user) {
		try {
			return repository.save(user);
		}	catch (JpaSystemException ex) {
			throw new DataIntegrityViolationException("Integrity constraint", ex);
		}
	}

  /**
   * Creates user details.
   *
   * @param username username
   *
   */
	public UserDetails createUserDetails(String name) {
		User user = repository.findByUsername(name);
		if (user == null) {
			throw new UsernameNotFoundException(name);
		}

		return new UserEntityDetails(user, Collections.<Role>emptyList(), user.isEnabled(), !user.isLocked());
	}

}
