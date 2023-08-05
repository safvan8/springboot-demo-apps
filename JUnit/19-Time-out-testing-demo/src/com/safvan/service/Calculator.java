package com.safvan.service;

public class Calculator {
	public int addition(int a, int b) {
		return a + b;
	}

	public int multiplication(int a, int b) {
		return a * b;
	}

	public int subtraction(int a, int b) {
		return a - b;
	}

	public int division(int a, int b) {
		return a / b;
	}

	public void delay(long time) throws InterruptedException {
		Thread.sleep(time * 1000);
	}

}
