package com.safvan.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import com.safvan.service.Calculator;

//@EnabledOnOs(OS.MAC)
//@DisabledOnOs(OS.MAC)
class OsCalculatorTest {
	private Calculator cobj = new Calculator();

	@EnabledOnOs({ OS.SOLARIS, OS.LINUX })
	@Test
	void additionTest() {
		assertEquals(2, cobj.addition(1, 1));
	}

	@EnabledOnOs(OS.WINDOWS)
	@Test
	void multiplicationTest() {
		assertEquals(4, cobj.multiplication(2, 2));
	}
	
	@DisabledOnOs({OS.MAC, OS.LINUX})
	@Test
	void subtractionTest() {
		assertEquals(0, cobj.subtraction(1, 1));
	}
	
	@DisabledOnOs(OS.WINDOWS)
	@Test
	void divisionTest() {
		assertEquals(1, cobj.division(2, 2));
	}

}
