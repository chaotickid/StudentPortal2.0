//package com.mavenir.vmp.mailbox.storage;
//
//import com.mavenir.vmp.mailbox.storage.RequestData;
//import jakarta.transaction.Transactional;
//import org.springframework.data.domain.Page;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//import org.springframework.data.domain.Pageable;
//
//@Repository
//public interface RequestDataRepository extends JpaRepository<RequestData, RequestDataPK> {
//
//	/**
//	 * Returns all the valid IDs for the given request type
//	 *
//	 * @param type Request type
//	 * @param pageable Pageable object to handle pagination
//	 * @return Page of RequestData
//	 */
//	@Query("SELECT r FROM RequestData r WHERE r.type = ?1 AND r.expiryTime >= CURRENT_TIMESTAMP")
//	Page<RequestData> findAllByType(String type, Pageable pageable);
//
//	/**
//	 * Deletes all the expired IDs for the given request type
//	 *
//	 * @param type Request type
//	 */
//	@Modifying
//	@Transactional
//	@Query("DELETE FROM RequestData r WHERE r.type = ?1 AND r.expiryTime < CURRENT_TIMESTAMP")
//	void deleteExpiredByType(String type);
//
//	/**
//	 * Deletes all the expired IDs
//	 */
//	@Modifying
//	@Transactional
//	@Query("DELETE FROM RequestData r WHERE r.expiryTime < CURRENT_TIMESTAMP")
//	void deleteAllExpired();
//}
