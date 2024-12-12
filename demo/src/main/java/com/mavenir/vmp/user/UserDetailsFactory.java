package com.mavenir.vmp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * User details factory.
 *
 */
@Service
public class UserDetailsFactory implements UserDetailsService {

	/** User service. */
	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) {
		return userService.createUserDetails(username);
	}
}
