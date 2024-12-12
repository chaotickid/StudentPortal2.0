package com.mavenir.vmp.export;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for metadata.
 *
 */
@RestController
@RequestMapping("metadata")
public class MetadataController {

	/** Metadata service. */
	@Autowired
	private MetadataService metadataService;

	/**
	 * Returns all metadata.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public MetadataResponse index() {
		Map<String, Object> constraints = metadataService.getConstraints();
		Map<String, Object> enums = metadataService.getEnums();
		return new MetadataResponse(constraints, enums);
	}

}
