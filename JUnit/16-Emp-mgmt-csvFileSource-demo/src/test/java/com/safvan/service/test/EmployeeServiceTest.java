package com.safvan.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import com.safvan.entities.Employee;
import com.safvan.service.EmployeeService;

@DisplayName("Testing Employee service methods")
public class EmployeeServiceTest {

	private EmployeeService employeeService = new EmployeeService();

	@DisplayName("Test for calculating yearly salary")
	@ParameterizedTest
	@CsvFileSource(resources = "/testValues.csv",numLinesToSkip = 1)
	public void calculateYearlySalaryTest(Double oneMonthSalary, Double expectedAnnualSalary) {

		Employee employee = new Employee();
		employee.setMonthlySalary(oneMonthSalary);

		double actualAnnualSalary = employeeService.calculateYearlySalary(employee);

		assertEquals(expectedAnnualSalary, actualAnnualSalary);
	}

	@DisplayName("Employee Calculate hike method test")
	@Test
	public void calculateHikeTest() {

		Employee employeeWithLessSalary = new Employee();
		employeeWithLessSalary.setMonthlySalary(1000.0);

		Employee employeeWithHighSalary = new Employee();
		employeeWithHighSalary.setMonthlySalary(12000.0);

		double employeeWithLessSalaryHike = employeeService.calculateHike(employeeWithLessSalary);
		double employeeWithHighSalaryHike = employeeService.calculateHike(employeeWithHighSalary);

		assertEquals(employeeWithLessSalaryHike, 2000);

		assertEquals(employeeWithHighSalaryHike, 1000);

	}

	@Disabled("method under developement")
	@Test
	public void calculateEmployeePeformanceIndexScoreTest() {

	}

	@Test
	public void executeTest() {
		// Check if the JRE version is 17
		boolean isJava8OrHigher = System.getProperty("java.version").startsWith("17");

		// Assuming the condition is true
		assumeTrue(isJava8OrHigher);

		// Your test code goes here
		// This code will only be executed if the JRE version is 1.8 or higher
		// For example:
		int result = 2 + 3;
		assertEquals(5, result);
	}

}
