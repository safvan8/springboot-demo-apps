package com.infosys.service.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import com.infosys.service.Calculator;

class MethodSourceExternalMethodTest {
	private Calculator cobj = new Calculator();

	@MethodSource("com.infosys.test.InputParams#multipleProvider")
	@ParameterizedTest
	void checkMultipleTest(List<Integer> input) {
		for (Integer multiple : input) {
			assertEquals(0, cobj.modulus(multiple, 5));
		}
	}
}

class InputParams {
	private InputParams() {

	}

	static Stream<List<Integer>> multipleProvider() {
		return Stream.of(Arrays.asList(5, 10, 15, 20));
	}
}