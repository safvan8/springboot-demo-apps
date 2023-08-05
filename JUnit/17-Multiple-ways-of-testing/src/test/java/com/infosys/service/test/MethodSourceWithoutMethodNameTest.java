package com.safvan.service.test;

import static org.junit.Assert.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.safvan.service.Calculator;

class MethodSourceWithoutMethodNameTest {
	private Calculator cobj = new Calculator();
	
	// both method name should be same , if we are not specifying the method name
	
	static Stream<Arguments> test() {
		return Stream.of(Arguments.of(50, 60));
	}

	@MethodSource
	@ParameterizedTest
	void test(Integer a, Integer b) {
		assertEquals(110, cobj.addition(a, b));
	}

}
