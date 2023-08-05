package com.safvan.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

import com.safvan.service.Calculator;

class EnvPropertyCalculatorTest {
	private Calculator cobj = new Calculator();

	@EnabledIfEnvironmentVariable(named = "ENV", matches = "staging-server")
	@Test
	void additionTest() {
		assertEquals(2, cobj.addition(1, 1));
	}

	@DisabledIfEnvironmentVariable(named = "ENV", matches = ".*development.*")
	@Test
	void multiplicationTest() {
		assertEquals(4, cobj.multiplication(2, 2));
	}

}
