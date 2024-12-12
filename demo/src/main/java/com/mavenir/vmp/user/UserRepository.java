package com.mavenir.vmp.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * User JPA repository.
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * Returns user with the specified name.
	 *
	 * @param name user's name
	 */
	User findByUsername(String name);

	/**
	 * Returns a number of users with same name and different id.
	 *
	 * @param name User name
	 * @param id User id
	 */
	@Query("SELECT COUNT(u) FROM User u WHERE u.username = ?1 and u.id != ?2")
	Integer countBySameNameAndDifferentId(String name, long id);

	/**
	 * Returns a number of users with same name.
	 *
	 * @param name User name
	 */
	@Query("SELECT COUNT(u) FROM User u WHERE u.username = ?1")
	Integer countBySameName(String name);

	@Modifying
	@Query("UPDATE User u SET u.locked = false")
	@Transactional
	void unlockAllUsers();
}
