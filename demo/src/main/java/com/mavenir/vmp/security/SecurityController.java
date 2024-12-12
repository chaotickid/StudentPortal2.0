package com.mavenir.vmp.security;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.mavenir.vmp.security.handler.UserLoggedOutException;
import com.mavenir.vmp.user.Role;
import com.mavenir.vmp.user.User;
import com.mavenir.vmp.user.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.ServletRequest;
import java.util.Map;

/**
 * Security controller.
 *
 */
@RestController
@RequestMapping("security")
public class SecurityController {

	private static final String ROOT_URL = "/";
	private static final String FIND_SUBSCRIBER_URL = "/findSubscriber";
	private static final String EDIT_SUBSCRIBER_URL = "/editSubscriber";
	private static final String CREATE_SUBSCRIBER_URL = "/createSubscriber";
	private static final String DELETE_SUBSCRIBER_URL = "/deleteSubscriber";
	private static final String SETTINGS_URL = "/settings";
	private static final String ABOUT_URL = "/about";
	private static final String USER_PROPERTIES_URL = "/userProperties";
	private static final String MERGE_URL = "/merge";
	private static final String SPLIT_URL = "/split";
	private static final String VOICEMAIL_URL = "/voicemail";
	private static final String BULK_PROVISIONING_URL = "/bulkProvisioning";
	private static final String BULLETIN_DEPOSIT_URL = "/bulletinDeposit";
	private static final String BULLETIN_RETRIEVE_URL = "/bulletinRetrieve";
	private static final String BULLETIN_DELETE_URL = "/bulletinDelete";
	private static final String SINGLE_RECOVERY_URL = "/singleRecovery";
	private static final String BULK_RECOVERY_URL = "/bulkRecovery";
	private static final String MESSAGE_RECOVERY_URL = "/messageRecovery";
	private static final String RELOCATION_SUBSCRIBER_URL = "/subscriberRelocation";

	private static final Map<Role, ImmutableSet<String>> ALLOWED_URLS =
			ImmutableMap.<Role, ImmutableSet<String>>builder()
			.put(Role.ROLE_SIMPLE, ImmutableSet.<String>of(
					FIND_SUBSCRIBER_URL, ABOUT_URL, USER_PROPERTIES_URL))
			.put(Role.ROLE_INTERMEDIATE, ImmutableSet.<String>of(
					FIND_SUBSCRIBER_URL, EDIT_SUBSCRIBER_URL, ABOUT_URL, USER_PROPERTIES_URL))
			.put(Role.ROLE_ADVANCED, ImmutableSet.<String>of(
					FIND_SUBSCRIBER_URL, EDIT_SUBSCRIBER_URL, DELETE_SUBSCRIBER_URL, CREATE_SUBSCRIBER_URL, ABOUT_URL, USER_PROPERTIES_URL,
					MERGE_URL, SPLIT_URL, VOICEMAIL_URL, BULK_PROVISIONING_URL, BULLETIN_DEPOSIT_URL, BULLETIN_RETRIEVE_URL, BULLETIN_DELETE_URL,
					SINGLE_RECOVERY_URL, BULK_RECOVERY_URL, MESSAGE_RECOVERY_URL, RELOCATION_SUBSCRIBER_URL ))
			.put(Role.ROLE_ADMIN, ImmutableSet.<String>of(
					SETTINGS_URL, ABOUT_URL, USER_PROPERTIES_URL))
			.build();

	/** Mapper. */
	@Autowired
	private ModelMapper mapper;

	/** User service. */
	@Autowired
	private UserService userService;

	/**
	 * Returns security data for current user.
	 *
	 * @param request servlet request
	 */
	@RequestMapping(method = RequestMethod.GET)
	public SecurityRespone index(ServletRequest request) {
		User user = userService.getCurrentUser();
		if (user == null) {
			throw new UserLoggedOutException("User logged out.");
		}
		UserSecurity userSecurity = mapper.map(user, UserSecurity.class);
		userSecurity.setRoles(userService.getCurrentRoles());

		CsrfToken token = (CsrfToken) request.getAttribute(CsrfToken.class.getName());

		return new SecurityRespone(token.getToken(), userSecurity);
	}

	@RequestMapping(value = "navigation", method = RequestMethod.GET)
	public NavigationVM getNavigation() {
		Role currentRole = userService.getCurrentUserRole();
		NavigationVM vm = new NavigationVM();
		vm.setFindSubscriber(userService.hasCurrentAnyRole(currentRole, Role.ROLE_SIMPLE, Role.ROLE_INTERMEDIATE, Role.ROLE_ADVANCED));
		vm.setEditSubscriber(userService.hasCurrentAnyRole(currentRole, Role.ROLE_INTERMEDIATE, Role.ROLE_ADVANCED));
		vm.setCreateSubscriber(currentRole == Role.ROLE_ADVANCED);
		vm.setDeleteSubscriber(currentRole == Role.ROLE_ADVANCED);
		vm.setSettings(currentRole == Role.ROLE_ADMIN);
		vm.setAbout(userService.hasCurrentAnyRole(currentRole, Role.ROLE_SIMPLE, Role.ROLE_INTERMEDIATE, Role.ROLE_ADVANCED, Role.ROLE_ADMIN));
		vm.setMerge(userService.hasCurrentAnyRole(currentRole, Role.ROLE_ADVANCED));
		vm.setSplit(userService.hasCurrentAnyRole(currentRole, Role.ROLE_ADVANCED));
		vm.setBulkProvisioning(userService.hasCurrentAnyRole(currentRole, Role.ROLE_ADVANCED));
		vm.setVoicemail(userService.hasCurrentAnyRole(currentRole, Role.ROLE_ADVANCED));
		vm.setBulletinDeposit(userService.hasCurrentAnyRole(currentRole, Role.ROLE_ADVANCED));
		vm.setBulletinRetrieve(userService.hasCurrentAnyRole(currentRole, Role.ROLE_ADVANCED));
		vm.setBulletinDelete(userService.hasCurrentAnyRole(currentRole, Role.ROLE_ADVANCED));
		vm.setSingleRecovery(userService.hasCurrentAnyRole(currentRole, Role.ROLE_ADVANCED));
		vm.setBulkRecovery(userService.hasCurrentAnyRole(currentRole, Role.ROLE_ADVANCED));
		vm.setMessageRecovery(userService.hasCurrentAnyRole(currentRole, Role.ROLE_ADVANCED));
		vm.setSubscriberRelocation(userService.hasCurrentAnyRole(currentRole, Role.ROLE_ADVANCED));
		
		return vm;
	}

	/**
	 * Check path.
	 *
	 * @param path
	 *            the path
	 * @return the string
	 */
	@PreAuthorize("hasAnyRole('ROLE_SIMPLE', 'ROLE_INTERMEDIATE', 'ROLE_ADVANCED', 'ROLE_ADMIN')")
	@RequestMapping(value = "checkPath", method = RequestMethod.POST)
	public String checkPath(@RequestBody String path) {
		Role currentRole = userService.getCurrentUserRole();
		if (currentRole == null) {
			throw new UserLoggedOutException("User logged out.");
		}
		ImmutableSet<String> allowedUrls = ALLOWED_URLS.get(currentRole);
		// If it's root url, redirect to starting page
		if (ROOT_URL.equals(path)) {
			return ROOT_URL;
		}
		// Check simple paths such as /findSubscriber
		if (allowedUrls.contains(path)) {
			return path;
		}
		// Fall back check, checks a bit more complex paths such as /editSubscriber/612...
		for (String url : allowedUrls) {
			if (path.startsWith(url)) {
				return path;
			}
		}
		// Path not allowed, return user to his starting page
		return ROOT_URL;
	}
}
