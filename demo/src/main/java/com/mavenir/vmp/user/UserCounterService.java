package com.mavenir.vmp.user;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Metrics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author developer, OptimIT
 */
@Service
public class UserCounterService {

	private static final String COUNTER = "services.system.loggedin.";
	private static final String ADMINS = "admins";
	private static final String SIMPLE = "simple";
	private static final String INTERMEDIATE = "intermediate";
	private static final String ADVANCE = "advance";

	private final Counter adminCounter;
	private final Counter simpleCounter;
	private final Counter intermediateCounter;
	private final Counter advanceCounter;

	private final UserService userService;

	@Autowired
	public UserCounterService(MeterRegistry registry, UserService userService) {
		this.userService = userService;

		// Initialize counters
		this.adminCounter = Counter.builder(COUNTER + ADMINS)
				.description("Count of logged-in admins")
				.register(registry);

		this.simpleCounter = Counter.builder(COUNTER + SIMPLE)
				.description("Count of logged-in simple users")
				.register(registry);

		this.intermediateCounter = Counter.builder(COUNTER + INTERMEDIATE)
				.description("Count of logged-in intermediate users")
				.register(registry);

		this.advanceCounter = Counter.builder(COUNTER + ADVANCE)
				.description("Count of logged-in advanced users")
				.register(registry);
	}

	public double getAdminCount() {
		return adminCounter.count();
	}

	public double getSimpleCount() {
		return simpleCounter.count();
	}

	public double getIntermediateCount() {
		return intermediateCounter.count();
	}

	public double getAdvanceCount() {
		return advanceCounter.count();
	}

	public void incrementCounter() {
		incrementCounter(userService.getCurrentUserRole());
	}

	public void decrementCounter() {
		decrementCounter(userService.getCurrentUserRole());
	}

	private void incrementCounter(Role role) {
		if (role == null) {
			return;
		}
		switch (role) {
			case ROLE_ADMIN:
				adminCounter.increment();
				break;
			case ROLE_ADVANCED:
				advanceCounter.increment();
				break;
			case ROLE_INTERMEDIATE:
				intermediateCounter.increment();
				break;
			case ROLE_SIMPLE:
				simpleCounter.increment();
				break;
			default:
				break;
		}
	}

	private void decrementCounter(Role role) {
		if (role == null) {
			return;
		}
		switch (role) {
			case ROLE_ADMIN:
				adminCounter.increment();
				break;
			case ROLE_ADVANCED:
				advanceCounter.increment();
				break;
			case ROLE_INTERMEDIATE:
				intermediateCounter.increment();
				break;
			case ROLE_SIMPLE:
				simpleCounter.increment();
				break;
			default:
				break;
		}
	}
}
