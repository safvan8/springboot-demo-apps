package in.ineuron;

import in.ineuron.util.Calculator;

public class Main {
	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		Integer addResult = calculator.add(1, 2);
		System.out.println(addResult);
	}
}
