package com.safvan.service.test;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import com.safvan.service.RomanNumeral;

class EnumSourceTest {
	@EnumSource(value = RomanNumeral.class, names = { "I", "IV" })
	@ParameterizedTest
	void checkRomanNumeralTest(RomanNumeral numeral) {
		assertTrue(RomanNumeral.contains(numeral.name()));
	}

}
