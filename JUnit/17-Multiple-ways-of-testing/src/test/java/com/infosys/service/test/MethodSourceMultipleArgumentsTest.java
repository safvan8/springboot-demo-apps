package com.infosys.service.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.infosys.service.Calculator;

class MethodSourceMultipleArgumentsTest {
	private Calculator cobj = new Calculator();

	static Stream<Arguments> listProvider() {
		return Stream.of(Arguments.of(Arrays.asList(1, 2), 1, Arrays.asList(2, 3)),
				Arguments.of(Arrays.asList(1, 2), 2, Arrays.asList(3, 4)));
	}

	@MethodSource("listProvider")
	@ParameterizedTest
	void multiArgMethodSourceTest(List<Integer> list, Integer increment, List<Integer> finalList) {
		for (int i = 0; i < list.size(); i++) {
			list.set(i, cobj.addition(list.get(i), increment));
		}
		assertEquals(list, finalList);
	}

}
