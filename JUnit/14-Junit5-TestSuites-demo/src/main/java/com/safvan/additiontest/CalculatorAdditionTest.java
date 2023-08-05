package com.safvan.additiontest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.safvan.service.Calculator;

public class CalculatorAdditionTest {
	private Calculator cobj = new Calculator();

	@Test
	void additionValidTest() {
		assertEquals(15, cobj.addition(10, 5));
	}

}
