package com.safvan.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import com.safvan.service.Calculator;

class CalculatorTest {
	private Calculator cobj = new Calculator();

	@RegisterExtension
	public MyLoggerExtension le = new MyLoggerExtension("MyLoggerExtension registered for " + this.getClass());

	@Test
	void additionTest() {
		assertEquals(2, cobj.addition(1, 1));
	}
	
	@Test
	void multiplicationTest() {
		assertEquals(1, cobj.multiplication(1, 1));
	}

}
