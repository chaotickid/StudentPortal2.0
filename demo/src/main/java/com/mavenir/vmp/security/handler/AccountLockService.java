/**
 *
 */
package com.mavenir.vmp.security.handler;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.mavenir.vmp.config.EnvironmentProperties;
import com.mavenir.vmp.user.User;
import com.mavenir.vmp.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.stereotype.Service;

/**
 * @author developer, OptimIT
 *
 */
@Service
public class AccountLockService {

	/** The repository. */
	private final UserRepository repository;

	/** The max login attempts. */
	private final int maxLoginAttempts;

	/** The attempts. */
	private final LoadingCache<String, Integer> attempts;

	@Autowired
	public AccountLockService(UserRepository repository, EnvironmentProperties properties) {
		this.repository = repository;
		this.maxLoginAttempts = properties.getMaxLoginAttempts();
		attempts = createCache();
		unlockAllUsers(properties);
	}

	private LoadingCache<String, Integer> createCache() {
		return CacheBuilder.newBuilder()
		.build(new CacheLoader<String, Integer>() {
			@Override
			public Integer load(String key) {
				return attempts.getIfPresent(key);
			}
		});
	}

	/**
	 * Unlocks all users on application startup.
	 */
	private void unlockAllUsers(EnvironmentProperties properties) {
		if (properties.isUnlockUsersOnStartup()) {
			repository.unlockAllUsers();
		}
	}

	private void lockUser(User user) {
		if (user != null) {
			user.setLocked(true);
			repository.save(user);
			throw new LockedException("locked");
		}
	}

	public void loginSuccess(String username) {
		attempts.invalidate(username);
	}

	public void loginFailed(String username) {
		User user = repository.findByUsername(username);
		if (user != null) {
			Integer att = attempts.getIfPresent(username);
			if (att == null) {
				attempts.put(username, 1);
			} else {
				attempts.put(username, ++att);
				if (att >= maxLoginAttempts) {
					lockUser(user);
				}
			}
		}
	}
}
