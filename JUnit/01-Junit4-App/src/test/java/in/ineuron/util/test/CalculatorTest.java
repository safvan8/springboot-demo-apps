package in.ineuron.util.test;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import in.ineuron.util.Calculator;

public class CalculatorTest {

	private static Calculator calculator;

	@BeforeClass
	public static void init() {
		// create object before testing
		calculator = new Calculator();
	}

	@AfterClass
	public static void destroy() {
		// making object null, after executing all tests
		calculator = null;
	}

	@Test
	public void addTest() {
		Integer actualResult = calculator.add(10, 20);
		Integer expectedResult = 30;
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void multiplyTest() {
		Integer actualResult = calculator.multiply(10, 20);
		Integer expectedResult = 200;
		assertEquals(expectedResult, actualResult);
	}
}
