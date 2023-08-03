package com.safvan.service;

import com.safvan.entities.Employee;

public class EmployeeService {
	public double calculateYearlySalary(Employee employee) {
		double yearlySalary = 0;
		yearlySalary = employee.getMonthlySalary() * 12;
		return yearlySalary;
	}

	public double calculateHike(Employee employee) {
		double hike = 0;
		if (employee.getMonthlySalary() < 10000) {
			hike = 2000;
		} else {
			hike = 1000;
		}
		return hike;
	}

	public Double calculateEmployeePeformanceIndexScore(Employee employee) {
		System.out.println("Under Developement");
		return null;
	}
}
