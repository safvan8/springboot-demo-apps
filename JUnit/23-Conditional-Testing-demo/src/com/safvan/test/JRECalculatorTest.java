package com.safvan.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledForJreRange;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.JRE;

import com.safvan.service.Calculator;

class JRECalculatorTest {
	private Calculator cobj = new Calculator();
	
	@EnabledOnJre(JRE.JAVA_8)
	@Test
	void additionValidTest() {
		assertEquals(2, cobj.addition(1, 1));
	}
	
	@EnabledOnJre({ JRE.JAVA_9, JRE.JAVA_15 })
	@Test
	void multiplicationValidTest() {
		assertEquals(4, cobj.multiplication(2, 2));
	}
	
	@EnabledForJreRange(min = JRE.JAVA_9, max = JRE.JAVA_11)
	@Test
	void subtractionValidTest() {
		assertEquals(0, cobj.subtraction(3, 3));
	}
	
	@EnabledForJreRange(min = JRE.JAVA_10)
	@Test
	void divisionValidTest() {
		assertEquals(1, cobj.division(4, 4));
	}
		
	@DisabledOnJre(JRE.JAVA_9)
	@Test
	void additionInvalidTest() {
		assertEquals(2, cobj.addition(5, 1));
	}
	
	@DisabledForJreRange(min = JRE.JAVA_9, max = JRE.JAVA_14)
	@Test
	void multiplicationInvalidTest() {
		assertEquals(8, cobj.multiplication(2, 2));
	}
	
	@DisabledForJreRange(min = JRE.JAVA_12)
	@Test
	void subtractionInvalidTest() {
		assertEquals(10, cobj.subtraction(3, 3));
	}
	
	@DisabledForJreRange(max = JRE.JAVA_13)
	@Test
	void divisionInvalidTest() {
		assertEquals(5, cobj.division(4, 4));
	}
	
}
