/**
 *
 */
package com.mavenir.vmp.about;

import com.mavenir.vmp.config.EnvironmentProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.text.DecimalFormat;
import java.util.HashMap;

/**
 * @author Vlatka, OptimIT
 *
 */
@Service
public class VmpMetrics {

	private final Logger logger = LoggerFactory.getLogger(VmpMetrics.class);

	@Autowired
	private EnvironmentProperties environmentProperties;

	/**
	 * Metrics.
	 *
	 * @return the hash map
	 */
	public HashMap<Metric, Object> getMetrics() {
		HashMap<Metric, Object> result = new HashMap<Metric, Object>();
		setHddMetrics(result);
		setMemoryMetrics(result);
		setClassesMetrics(result);
		setThreadMetrics(result);
		setHeapMetrics(result);
		//
		result.put(Metric.PROCESSORS, Runtime.getRuntime().availableProcessors());
		//
		result.put(Metric.UPTIME, ManagementFactory.getRuntimeMXBean().getUptime());
		//
		result.put(Metric.CPU_LOAD, ManagementFactory.getOperatingSystemMXBean().getSystemLoadAverage());
		//
		result.put(Metric.OPERATING_SYSTEM_NAME, ManagementFactory.getOperatingSystemMXBean().getName());
		//
		result.put(Metric.OPERATING_SYSTEM_VERSION, ManagementFactory.getOperatingSystemMXBean().getVersion());
		return result;
	}

	/**
	 * Sets the hdd metrics.
	 *
	 * @param result the result
	 */
	private void setHddMetrics(HashMap<Metric, Object> result) {
		try {
			File file = new File(environmentProperties.getMetric().getHddMountPoint());
			if (!file.exists()) {
				logger.error("Error checking HDD status: invalid mount point name!: " + environmentProperties.getMetric().getHddMountPoint());
				return;
			}
			float totalSpace = file.getTotalSpace();
			float usedSpace = totalSpace - file.getFreeSpace();
			float freeSpace = file.getUsableSpace();
			float systemReservedSpace = file.getFreeSpace() - freeSpace;
			float usedSpacePer = (usedSpace / totalSpace) * 100;
			float freeSpacePer = (freeSpace / totalSpace) * 100;
			float systemReservedSpacePer = (systemReservedSpace / totalSpace) * 100;
			DecimalFormat df = new DecimalFormat();
			df.setMaximumFractionDigits(2);
			// in GB
			result.put(Metric.HDD_TOTAL, df.format(totalSpace / 1024 / 1024 / 1024));
			// in GB
			result.put(Metric.HDD_USED, df.format(usedSpace / 1024 / 1024 / 1024));
			// in GB
			result.put(Metric.HDD_FREE, df.format(freeSpace / 1024 / 1024 / 1024));
			// in GB
			result.put(Metric.HDD_SYSTEM_RESERVED, df.format(systemReservedSpace / 1024 / 1024 / 1024));
			result.put(Metric.HDD_USED_PER, df.format(usedSpacePer));
			result.put(Metric.HDD_FREE_PER, df.format(freeSpacePer));
			result.put(Metric.HDD_SYSTEM_RESERVED_PER, df.format(systemReservedSpacePer));
		} catch (Exception e) {
			logger.error("Error checking HDD status: ", e);
			return;
		}
	}

	/**
	 * Sets the heap metrics.
	 *
	 * @param result the result
	 */
	private void setHeapMetrics(HashMap<Metric, Object> result) {
		// in MB
		result.put(Metric.HEAP_COMMITTED, ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getCommitted() / 1024 / 1024);
		// in MB
		result.put(Metric.HEAP_INIT, ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getInit() / 1024 / 1024);
		// in MB
		result.put(Metric.HEAP_MAX, ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getMax() / 1024 / 1024);
		// in MB
		result.put(Metric.HEAP_USED, ManagementFactory.getMemoryMXBean().getHeapMemoryUsage().getUsed() / 1024 / 1024);
	}

	/**
	 * Sets the memory metrics.
	 *
	 * @param result the result
	 */
	private void setMemoryMetrics(HashMap<Metric, Object> result) {
		float total = Runtime.getRuntime().totalMemory();
		float free = Runtime.getRuntime().freeMemory();
		float freePer = (free / total) * 100;
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		// in MB
		result.put(Metric.JVM_MEMORY_FREE, df.format(free / 1024 / 1024));
		// in MB
		result.put(Metric.JVM_MEMORY_TOTAL, df.format(total / 1024 / 1024));
		result.put(Metric.JVM_MEMORY_FREE_PER, df.format(freePer));
	}

	/**
	 * Sets the classes metrics.
	 *
	 * @param result the result
	 */
	private void setClassesMetrics(HashMap<Metric, Object> result) {
		result.put(Metric.CLASSES_LOADED, ManagementFactory.getClassLoadingMXBean().getTotalLoadedClassCount());
		result.put(Metric.CLASSES_TOTAL, ManagementFactory.getClassLoadingMXBean().getLoadedClassCount());
		result.put(Metric.CLASSES_UNLOADED, ManagementFactory.getClassLoadingMXBean().getUnloadedClassCount());
	}

	/**
	 * Sets the thread metrics.
	 *
	 * @param result the result
	 */
	private void setThreadMetrics(HashMap<Metric, Object> result) {
		result.put(Metric.THREADS_DAEMON, ManagementFactory.getThreadMXBean().getDaemonThreadCount());
		result.put(Metric.THREADS_PEAK, ManagementFactory.getThreadMXBean().getPeakThreadCount());
		result.put(Metric.THREADS_TOTAL, ManagementFactory.getThreadMXBean().getThreadCount());
	}

}
