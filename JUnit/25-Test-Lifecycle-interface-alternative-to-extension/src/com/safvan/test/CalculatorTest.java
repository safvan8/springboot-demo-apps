package com.safvan.test;

import java.util.logging.Logger;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public interface CalculatorTest {
	public static final Logger logger = Logger.getLogger(CalculatorImplTest.class.getName());
	
	@BeforeAll
	default void beforeAllTests(TestInfo info) {
		logger.info("Inside BeforeAll method: " + info.getDisplayName());
	}

	@BeforeEach
	default void beforeEachTest(TestInfo info) {
		logger.info("Inside BeforeEach in method: " + info.getDisplayName());
	}

	@AfterEach
	default void afterEachTest(TestInfo info) {
		logger.info("Inside AfterEach in method: " + info.getDisplayName());
	}
	
	@AfterAll
	default void afterAllTests(TestInfo info) {
		logger.info("Inside AfterAll method: " + info.getDisplayName());
	}

}
