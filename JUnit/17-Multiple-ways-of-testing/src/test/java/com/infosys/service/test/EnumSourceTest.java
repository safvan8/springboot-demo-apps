package com.infosys.service.test;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import com.infosys.service.RomanNumeral;

class EnumSourceTest {
	@EnumSource(value = RomanNumeral.class, names = { "I", "IV" })
	@ParameterizedTest
	void checkRomanNumeralTest(RomanNumeral numeral) {
		assertTrue(RomanNumeral.contains(numeral.name()));
	}

}
