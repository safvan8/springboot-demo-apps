package com.safvan.service.test;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class NullSourceTest {

	@NullSource
	@EmptySource // combine these two as @NullAndEmptySource
	@ValueSource(strings = { " ", "   ", "\t", "\n" })
	@ParameterizedTest
	void nullEmptyAndBlankStringsTest(String text) {
		assertTrue(text == null || text.trim().isEmpty());
	}
}
