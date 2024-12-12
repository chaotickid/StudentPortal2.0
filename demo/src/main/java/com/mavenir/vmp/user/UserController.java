/**
 *
 */
package com.mavenir.vmp.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;
import com.mavenir.vmp.core.web.WebPreconditions;
import com.mavenir.vmp.security.handler.AccountLockService;
import org.joda.time.DateTime;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

/**
 * The Class UserController.
 *
 * @author developer, OptimIT
 */
@RestController
@RequestMapping("users")
public class UserController {

	/** The repository. */
	@Autowired
	private UserRepository repository;

	/** The mapper. */
	@Autowired
	private ModelMapper mapper;

	/** The object mapper. */
	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private UserService service;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AccountLockService accountService;

	/**
	 * Index.
	 *
	 * @return the list
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping
	public Page<UserVM> index(Pageable page) {
		return mapper.map(repository.findAll(page), UserVM.PAGE_TYPE);
	}

	/**
	 * Gets the user.
	 *
	 * @param user the user
	 * @return the user
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping("{user}")
	public UserVM getUser(@PathVariable User user) {
		WebPreconditions.checkNotNull(user);
		return mapper.map(user, UserVM.class);
	}

	/**
	 * Save.
	 *
	 * @param userVm the user vm
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(method = RequestMethod.POST)
	public void save(@RequestBody	@Valid UserVM userVm) {
		WebPreconditions.checkNotNull(userVm);
		User user = mapper.map(userVm, User.class);
		user.setLastModified(DateTime.now());
		service.save(user);
	}

	/**
	 * Update.
	 *
	 * @param user the user
	 * @param userVm the user vm
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "{user}", method = RequestMethod.POST)
	public void update(@PathVariable User user, @RequestBody	@Valid EditUserVM userVm) {
		WebPreconditions.checkNotNull(user);
		WebPreconditions.checkNotNull(userVm);
		User currentUser = service.getCurrentUser();
		if (user.equals(currentUser) && !userVm.isEnabled()) {
			throw new DataIntegrityViolationException("Cannot disable currently logged in user.");
		}

		if (user.equals(currentUser) && userVm.isLocked()) {
			throw new DataIntegrityViolationException("Cannot lock currently logged in user.");
		}

		if (user.equals(currentUser) && userVm.getRole() != user.getRole()) {
			throw new DataIntegrityViolationException("Cannot change role of currently logged in user.");
		}
		if (user.isLocked() && !userVm.isLocked()) {
			accountService.loginSuccess(user.getUsername());
		}
		mapper.map(userVm, user);
		user.setLastModified(DateTime.now());
		service.save(user);
	}

	/**
	 * Delete.
	 *
	 * @param user the user
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "{user}", method = RequestMethod.DELETE)
	public void delete(@PathVariable User user) {
		WebPreconditions.checkNotNull(user);
		if (user.equals(service.getCurrentUser())) {
			throw new DataIntegrityViolationException("Cannot delete current user");
		}
		repository.delete(user);
	}

	/**
	 * Returns true if exist another user with the same name.
	 *
	 *  @param id user id
	 *  @param name user name
	 */
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "existUserWithSameName", method = RequestMethod.GET)
	public boolean existUserWithSameName(Long id, String name) {

		if (id == null) {
			if (repository.countBySameName(name) > 0) {
				return true;
			}
		}	else {
			if (repository.countBySameNameAndDifferentId(name, id) > 0) {
				return true;
			}

		}
		return false;
	}

	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	@PreAuthorize("hasAnyRole('ROLE_SIMPLE','ROLE_INTERMEDIATE','ROLE_ADVANCED','ROLE_ADMIN')")
	@RequestMapping(value = "getCurrent", method = RequestMethod.GET)
	public UserPropertiesVM getCurrentUser() {
		UserPropertiesVM vm = mapper.map(service.getCurrentUser(), UserPropertiesVM.class);
		return vm;
	}

	@PreAuthorize("hasAnyRole('ROLE_SIMPLE','ROLE_INTERMEDIATE','ROLE_ADVANCED','ROLE_ADMIN')")
	@RequestMapping(value = "saveCurrent", method = RequestMethod.POST)
	public void saveCurrentUser(@RequestBody @Valid UserPropertiesVM vm) {
		WebPreconditions.checkNotNull(vm);
		User user = service.getCurrentUser();
		user.setFirstName(vm.getFirstName());
		user.setLastName(vm.getLastName());
		service.save(user);
	}

	@PreAuthorize("hasAnyRole('ROLE_SIMPLE','ROLE_INTERMEDIATE','ROLE_ADVANCED','ROLE_ADMIN')")
	@RequestMapping(value = "updatePassword", method = RequestMethod.POST)
	public boolean updatePassword(@RequestBody @Valid UserPasswordVM vm) {
		WebPreconditions.checkNotNull(vm);
		User user = service.getCurrentUser();

		String enteredPassword = Strings.nullToEmpty(vm.getPassword());

		if (service.passwordMatches(enteredPassword, user.getPassword())) {
			vm.setNewPassword(Strings.nullToEmpty(vm.getNewPassword()));
			mapper.map(vm, user);
			service.save(user);
			return true;
		}	else {
			return false;
		}
	}
}
