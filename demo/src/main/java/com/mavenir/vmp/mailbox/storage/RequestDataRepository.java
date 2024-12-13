package com.mavenir.vmp.mailbox.storage;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import jakarta.transaction.Transactional;

@Repository
public interface RequestDataRepository extends JpaRepository<RequestData, RequestDataPK> {

	/**
	 * Returns all the valid IDs for the given request type using native query.
	 *
	 * @param type Request type
	 * @param pageable Pageable object for pagination
	 * @return Page of RequestData
	 */
	@Query(
			value = "SELECT * FROM request_data r WHERE r.type = :type AND r.expiry_time >= CURRENT_TIMESTAMP",
			countQuery = "SELECT COUNT(*) FROM request_data r WHERE r.type = :type AND r.expiry_time >= CURRENT_TIMESTAMP",
			nativeQuery = true
	)
	Page<RequestData> findAllByType(@org.springframework.data.repository.query.Param("type") String type, Pageable pageable);

	/**
	 * Deletes all the expired IDs for the given request type using native query.
	 *
	 * @param type Request type
	 */
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM request_data WHERE type = :type AND expiry_time < CURRENT_TIMESTAMP", nativeQuery = true)
	void deleteExpiredByType(@org.springframework.data.repository.query.Param("type") String type);

	/**
	 * Deletes all the expired IDs using native query.
	 */
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM request_data WHERE expiry_time < CURRENT_TIMESTAMP", nativeQuery = true)
	void deleteAllExpired();
}
