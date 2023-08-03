package com.safvan.client;

import java.util.logging.Logger;

import com.safvan.entities.Employee;
import com.safvan.service.EmployeeService;

public class EmployeeClient {
	private static final Logger logger = Logger.getLogger(EmployeeClient.class.getName());

	public static void main(String[] args) {
		EmployeeService employeeService = new EmployeeService();
		Employee employee = new Employee(1, "Abhishek", 10000);
		
		logger.info("Employee details are : " + employee);
		
		double annualIncome = employeeService.calculateYearlySalary(employee);
		logger.info("Your annual income is " + annualIncome);
		
		double hike = employeeService.calculateHike(employee);
		logger.info("Your will get hike of " + hike);
	}
}
