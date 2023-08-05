package com.safvan.divisiontest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.safvan.service.Calculator;

public class CalculatorDivisionTest {
	private Calculator cobj = new Calculator();

	@Test
	void divisionValidTest() {
		assertEquals(2, cobj.division(10, 5));
	}

}
