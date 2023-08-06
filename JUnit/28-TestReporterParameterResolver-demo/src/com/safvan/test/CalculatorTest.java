package com.safvan.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;

import com.safvan.service.Calculator;

class CalculatorTest {
	private Calculator cobj = new Calculator();

	@Test
	void additionTest(TestReporter testReporter) {
		testReporter.publishEntry("Status Msg : Inside additionTest()");
		assertEquals(2, cobj.addition(1, 1));
	}

	@Test
	void subtractionTest(TestReporter testReporter) {
		testReporter.publishEntry("Custom Message", "Inside subtractionTest()");
		assertEquals(4, cobj.subtraction(6, 2));
	}

	@Test
	void multiplicationTest(TestReporter testReporter) {
		Map<String, String> myMap = new HashMap<>();
		myMap.put("Custom Message 1", "Inside multiplicationTest()");
		myMap.put("Custom Message 2", "Inputs are 2 and 2");
		testReporter.publishEntry(myMap);
		assertEquals(4, cobj.multiplication(2, 2));
	}

}
