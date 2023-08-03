package com.infosys.divisiontest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.infosys.service.Calculator;

public class CalculatorDivisionTest {
	private Calculator cobj = new Calculator();

	@Test
	void divisionValidTest() {
		assertEquals(2, cobj.division(10, 5));
	}

}
