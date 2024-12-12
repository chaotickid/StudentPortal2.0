/**
 *
 */
package com.mavenir.vmp.property;

import com.mavenir.vmp.config.EnvironmentProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author developer, OptimIT
 *
 */
@RestController
@RequestMapping("property")
public class PropertiesController {

	@Autowired
	private EnvironmentProperties properties;

	@RequestMapping("timeFormat")
	public String getTimeFormat() {
		return properties.getTimeFormat();
	}

	@RequestMapping("globalTimeFormat")
	public String getGlobalTimeFormat() {
		return properties.getGlobalTimeFormat();
	}

}
