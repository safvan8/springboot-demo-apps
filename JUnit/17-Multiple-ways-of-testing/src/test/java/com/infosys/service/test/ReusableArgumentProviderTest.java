package com.safvan.service.test;

import static org.junit.Assert.assertTrue;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import com.safvan.service.RomanNumeral;

class ReusableArgumentProviderTest {
	@ArgumentsSource(MyArgumentsProvider.class)
	@ParameterizedTest
	void argumentsSourceTest(String argument) {
		assertTrue(RomanNumeral.contains(argument));
	}

}

class MyArgumentsProvider implements ArgumentsProvider {
	@Override
	public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
		return Stream.of("I", "X").map(Arguments::of);
	}

}
