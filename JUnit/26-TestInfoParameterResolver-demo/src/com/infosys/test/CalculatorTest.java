package com.infosys.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import com.infosys.service.Calculator;

@DisplayName("Test class to demonstrate TestInfo")
class CalculatorTest {
	private Calculator cobj = new Calculator();

	public CalculatorTest(TestInfo testInfo) {
		assertEquals("Test class to demonstrate TestInfo", testInfo.getDisplayName());
		System.out.println("CalculatorTest.CalculatorTest()");
	}

	@BeforeEach
	public void setUp(TestInfo testInfo) {
		String displayName = testInfo.getDisplayName();
		assertTrue(displayName.equals("Addition Test") || displayName.equals("Multiplication Test"));
		System.out.println("CalculatorTest.setUp()");
	}

	@DisplayName("Addition Test")
	@Tag("addition-tag")
	@Test
	void additionTest(TestInfo testInfo) {
		assertEquals("Addition Test", testInfo.getDisplayName());
		assertTrue(testInfo.getTags().contains("addition-tag"));
		assertEquals(2, cobj.addition(1, 1));
		System.out.println("CalculatorTest.additionTest()");
	}

	@DisplayName("Multiplication Test")
	@Test
	void multiplicationTest() {
		assertEquals(4, cobj.multiplication(2, 2));
		System.out.println("CalculatorTest.multiplicationTest()");
	}

}
