package com.infosys.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.infosys.service.Calculator;

class CsvSourceTest {
	private Calculator cobj = new Calculator();

	@CsvSource({ "2, 1, 2", "3, 2, 6" })
	@ParameterizedTest
	void multiplicationValidTest(int a, int b, int ans) {
		assertEquals(ans, cobj.multiplication(a, b));
	}
}
