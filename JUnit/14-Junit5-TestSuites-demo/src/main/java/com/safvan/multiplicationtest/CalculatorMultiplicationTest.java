package com.safvan.multiplicationtest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.safvan.service.Calculator;

public class CalculatorMultiplicationTest {
	private Calculator cobj = new Calculator();

	@Test
	void multiplicationValidTest() {
		assertEquals(50, cobj.multiplication(10, 5));
	}
}
