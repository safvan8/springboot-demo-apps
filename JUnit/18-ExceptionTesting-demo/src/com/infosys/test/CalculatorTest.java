package com.infosys.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.infosys.service.Calculator;

class CalculatorTest {
	private Calculator cobj = new Calculator();

	@Test
	void divisionValidTest() {
		assertEquals(2, cobj.division(10, 5));
	}

	@Test
	void divisionInvalidTest() {
		Exception exception = assertThrows(ArithmeticException.class, () -> cobj.division(10, 0));
		
		System.err.println(exception.getMessage());
		
		assertEquals("/ by zero", exception.getMessage());
	}

}
