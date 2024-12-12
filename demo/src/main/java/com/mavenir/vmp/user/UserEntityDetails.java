package com.mavenir.vmp.user;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

/**
 * User entity details.
 *
 * @useCase 1
 */
public final class UserEntityDetails extends org.springframework.security.core.userdetails.User {

	/** Serial version UID. */
	private static final long serialVersionUID = 1L;

	public UserEntityDetails(User user, Collection<Role> mappedRoles) {
		super(user.getId().toString(), user.getPassword() == null ? "" : user.getPassword(), createAuthorities(Iterables
				.concat(Arrays.asList(user.getRole()), mappedRoles)));
	}

	public UserEntityDetails(User user, Collection<Role> mappedRoles, boolean enabled) {
		super(user.getId().toString(), user.getPassword() == null ? "" : user.getPassword(), enabled, true, true, true,
				createAuthorities(Iterables.concat(Arrays.asList(user.getRole()), mappedRoles)));
	}

	public UserEntityDetails(User user, Collection<Role> mappedRoles, boolean enabled, boolean accountNonLocked) {
		super(user.getId().toString(), user.getPassword() == null ? "" : user.getPassword(), enabled, true, true, accountNonLocked,
				createAuthorities(Iterables.concat(Arrays.asList(user.getRole()), mappedRoles)));
	}

	/**
	 * Creates granted authorities from the given groups.
	 *
	 * @param roles the roles
	 * @return the sets the
	 */
	private static Set<GrantedAuthority> createAuthorities(Iterable<Role> roles) {
		ImmutableSet.Builder<GrantedAuthority> authorities = ImmutableSet.builder();
		for (Role role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.name()));
		}
		return authorities.build();
	}

}
