package com.infosys.test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import com.infosys.service.Calculator;

class CalculatorTest {
	private Calculator cobj;

	@BeforeEach
	public void setUp() {
		cobj = new Calculator();
		System.out.println("CalculatorTest.setUp()");
	}

	@Nested
	class CalculatorAdditionTest {
		@Test
		void additionValidTest() {
			assertEquals(4, cobj.addition(2, 2));
			System.out.println("CalculatorTest.CalculatorAdditionTest.additionValidTest()");
		}

		@Test
		void additionInvalidTest() {
			assertNotEquals(5, cobj.addition(2, 2));
			System.out.println("CalculatorTest.CalculatorAdditionTest.additionInvalidTest()");
		}
	}

	@Nested
	class CalculatorSubstractionTest {
		@Test
		void substractionValidTest() {
			assertEquals(4, cobj.subtraction(6, 2));
			System.out.println("CalculatorTest.CalculatorSubstractionTest.substractionValidTest()");
		}

		@Test
		void substractionInvalidTest() {
			assertNotEquals(8, cobj.subtraction(6, 2));
			System.out.println("CalculatorTest.CalculatorSubstractionTest.substractionInvalidTest()");
		}
	}

	@AfterEach
	public void tearDown() {
		cobj = new Calculator();
		System.out.println("CalculatorTest.tearDown()");
	}

}
