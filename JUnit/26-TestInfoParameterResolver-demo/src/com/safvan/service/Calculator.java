package com.safvan.service;

public class Calculator {
	public int addition(int a, int b) {
		System.out.println("Calculator.addition()");
		return a + b;

	}

	public int multiplication(int a, int b) {
		System.out.println("Calculator.multiplication()");
		return a * b;
	}

	public int subtraction(int a, int b) {
		System.out.println("Calculator.subtraction()");
		return a - b;
	}

	public int division(int a, int b) {
		System.out.println("Calculator.division()");
		return a / b;
	}

}
