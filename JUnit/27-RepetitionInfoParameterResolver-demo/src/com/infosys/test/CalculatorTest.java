package com.infosys.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

import com.infosys.service.Calculator;

class CalculatorTest {
	private static final Logger logger = Logger.getLogger(CalculatorTest.class.getName());

	private Calculator cobj = new Calculator();

	@BeforeEach
	void beforeEach(TestInfo testInfo, RepetitionInfo repetitionInfo) {
		int currentRepetition = repetitionInfo.getCurrentRepetition();
		int totalRepetitions = repetitionInfo.getTotalRepetitions();
		logger.info("Current Repetition: " + currentRepetition);
		logger.info("Total Repetition: " + totalRepetitions);
	}

	@RepeatedTest(5)
	void additionTest(RepetitionInfo repetitionInfo) {
		assertEquals(5, repetitionInfo.getTotalRepetitions());
		assertEquals(2, cobj.addition(1, 1));
	}

}
