package com.safvan.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.logging.Logger;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import com.safvan.service.Calculator;

class CalculatorAddtionTest {
	private static final Logger logger = Logger.getLogger(CalculatorAddtionTest.class.getName());
	private Calculator cobj = new Calculator();
	private int a;
	private int b;

	@BeforeAll
	static void setUpBeforeClass(TestInfo test) {
		logger.info("Inside BeforeAll method: " + test.getDisplayName());
	}

	@BeforeEach
	void setUp(TestInfo test) {
		a = 20;
		b = 30;
		logger.info("Before Test:" + test.getDisplayName());
	}

	@Test
	@Tag("Success")
	void additionValidTest() {
		assertEquals(50, cobj.addition(a, b));
	}

	@Test
	@Tag("Failure")
	void additionInvalidTest() {
		assertEquals(40, cobj.addition(a, b));
	}

	@Test
	@Tag("Cloud")
	@Tag("Failure")
	void additionCloudTest() {
		assertNotEquals(50, cobj.addition(a, b));
	}

	@AfterEach
	void tearDown(TestInfo test) {
		a = 0;
		b = 0;
		logger.info("After Test:" + test.getDisplayName());
	}

	@AfterAll
	static void tearDownAfterClass(TestInfo test) {
		logger.info("Inside AfterAll method: " + test.getDisplayName());
	}

}
