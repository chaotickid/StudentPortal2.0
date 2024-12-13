/**
 * 
 */
package com.mavenir.vmp.mailbox.storage;

import com.mavenir.vmp.config.EnvironmentProperties;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * @author Dhinesh Prasad, Mavenir Systems
 *
 */

@RestController
@RequestMapping("cache")
public class MailboxStorageController {

	private final Logger logger = LoggerFactory.getLogger(MailboxStorageController.class);

	/** The environment properties. */
	@Autowired
	private EnvironmentProperties environmentProperties;

	@Autowired
	private DataSource dataSource;
	
//	/** The repository. */
//	@Autowired
//	private RequestDataRepository repository;

	/**
	 * Returns the valid request IDs for that request type.
	 *
	 * @param type the request type
	 * @return the valid request IDs
	 */
	@PreAuthorize("hasRole('ROLE_ADVANCED')")
	@RequestMapping(value = "{type}", method = RequestMethod.GET)
	public List<RequestDataPart> getStoredId(@PathVariable String type) {
//		List<RequestDataPart> dataParts = new ArrayList<>();
//
//		// Create Pageable object with sorting by expiryTime
//		Pageable pageable = PageRequest.of(0, environmentProperties.getStatusLimit(), Sort.Direction.DESC, "expiryTime");
//
//		// Fetch paginated data from the repository
//		Page<RequestData> pageResult = repository.findAllByType(type, pageable);
//
//		// Delete expired entries after retrieving the data
//		repository.deleteExpiredByType(type);
//
//		// Process each entry from the paginated result
//		for (RequestData requestData : pageResult.getContent()) {
//			RequestDataPart dataPart = new RequestDataPart(requestData.getId(), requestData.getNode());
//			dataParts.add(dataPart);
//		}
//
//		// Return the processed list
		return null;
	}
	
	/**
	 * Saves the request id and type with an expiry time
	 *
	 * @param type the request type
	 * @param id the request id
	 */
	@PreAuthorize("hasRole('ROLE_ADVANCED')")
	@RequestMapping(value = "{type}/{id}/{node}", method = RequestMethod.GET)
	public void storeId(@PathVariable String type, @PathVariable String id, @PathVariable String node) {
		node = new String(Base64.getDecoder().decode(node));
		RequestData data = 
				new RequestData(type, id, node,
						new DateTime(System.currentTimeMillis() + (environmentProperties.getCacheTTL() * (long)(24 * 60 * 60 * 1000))));
		//repository.saveAndFlush(data);
	}

}
