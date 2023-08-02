package com.safvan;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.safvan.utility.BusinessLogic;

@SpringBootTest
class ApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private BusinessLogic businessLogic;

	@ParameterizedTest
	@ValueSource(strings = { "radar", "malayalam", "nitin" })
	public void isPalindromeTest(String str) {

		boolean result = businessLogic.isPalindrome(str);
		assertTrue(result);
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/testValues.csv", numLinesToSkip = 1)
	void evenOrOddTest(String input, String expectedResult) {
		String actualResult = businessLogic.isEvenOrOdd(input);

		assertEquals(expectedResult, actualResult);
	}
}
