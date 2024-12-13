/**
 *
 */
package com.mavenir.vmp.about;

import com.mavenir.vmp.config.EnvironmentProperties;
import com.mavenir.vmp.user.Role;
import com.mavenir.vmp.user.UserCounterService;
import com.mavenir.vmp.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.HashMap;
import java.util.Properties;

/**
 * The Class AboutController.
 *
 * @author developer, OptimIT
 */
@RestController
@RequestMapping("about")
public class AboutController {

	/** The service. */
	@Autowired
	private UserCounterService userCounterService;

	/** The about service. */
	@Autowired
	private AboutService aboutService;

	@Autowired
	private ApplicationContext context;

	@Autowired
	private UserService userService;

	@Autowired
	private VmpMetrics vmpMetrics;

	/** The environment properties. */
	@Autowired
	private EnvironmentProperties environmentProperties;

	/**
	 * Index.
	 *
	 * @return the about vm
	 */
	@PreAuthorize("hasAnyRole('ROLE_SIMPLE','ROLE_INTERMEDIATE','ROLE_ADVANCED', 'ROLE_ADMIN')")
	@RequestMapping
	public AboutVM index() {
		HashMap<Metric, Object> metrics = vmpMetrics.getMetrics();
		AboutVM result = new AboutVM();

		if (userService.hasCurrentRole(Role.ROLE_ADMIN)) {
			result.setAdminCount(String.valueOf(userCounterService.getAdminCount()));
			result.setSimpleCount(String.valueOf(userCounterService.getSimpleCount()));
			result.setSimpleCount(String.valueOf(userCounterService.getIntermediateCount()));
			result.setAdvanceCount(String.valueOf(userCounterService.getAdvanceCount()));
		}

		result.setUptime(String.valueOf(ManagementFactory.getRuntimeMXBean().getUptime()));
		result.setCcpsVersion(environmentProperties.getAppVersion());
		result.setVmpVersion(getVmpVersion());
		result.setMemoryFree(getMetric(metrics, Metric.JVM_MEMORY_FREE));
		result.setMemoryTotal(getMetric(metrics, Metric.JVM_MEMORY_TOTAL));
		result.setMemoryFreePercentage(getMetric(metrics, Metric.JVM_MEMORY_FREE_PER));
		result.setProcessors(getMetric(metrics, Metric.PROCESSORS));
		result.setCpuLoad(getMetric(metrics, Metric.CPU_LOAD));
		result.setHddFree(getMetric(metrics, Metric.HDD_FREE));
		result.setHddFreePercentage(getMetric(metrics, Metric.HDD_FREE_PER));
		result.setHddSystemReserved(getMetric(metrics, Metric.HDD_SYSTEM_RESERVED));
		result.setHddSystemReservedPercentage(getMetric(metrics, Metric.HDD_SYSTEM_RESERVED_PER));
		result.setHddTotal(getMetric(metrics, Metric.HDD_TOTAL));
		result.setHddUsed(getMetric(metrics, Metric.HDD_USED));
		result.setHddUsedPercentage(getMetric(metrics, Metric.HDD_USED_PER));

		return result;
	}

	/**
	 * Gets the vmp version.
	 *
	 * @return the vmp version
	 */
	private String getVmpVersion() {
		Properties prop = new Properties();
		Resource resource = context.getResource("/META-INF/MANIFEST.MF");
		try {
			prop.load(resource.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}
		return prop.getProperty("Implementation-Version");
	}

	/**
	 * Gets the metric.
	 *
	 * @param metricEnum the metric enum
	 * @return the metric
	 */
	public String getMetric(HashMap<Metric, Object> metrics, Metric metric) {
		if (metrics.containsKey(metric)) {
			return metrics.get(metric).toString();
		}
		return null;
	}
}
