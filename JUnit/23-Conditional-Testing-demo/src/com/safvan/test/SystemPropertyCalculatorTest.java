package com.safvan.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;

import com.safvan.service.Calculator;

class SystemPropertyCalculatorTest {
	private Calculator cobj = new Calculator();

	@EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
	@Test
	void additionTest() {
		assertEquals(2, cobj.addition(1, 1));
	}

	@DisabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
	@Test
	void multiplicationTest() {
		assertEquals(4, cobj.multiplication(2, 2));
	}
}
