package com.infosys.service.test;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.infosys.service.RomanNumeral;

class ParamAndValueSourceTest {
	@ValueSource(strings = { "V", "X" })
	@ParameterizedTest
	void valueSourceTest(String argument) {
		assertTrue(RomanNumeral.contains(argument));
	}

}
