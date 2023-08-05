package com.safvan.client;

import java.util.logging.Logger;

import com.safvan.service.Calculator;

public class Client {
	private static final Logger logger = Logger.getLogger(Client.class.toString());

	public static void main(String[] args) {
		Calculator cobj = new Calculator();
		int sum = cobj.addition(10, 10);
		logger.info("SUM : " + sum);
	}
	
	/*
	 
	  Right click on CalculatorTest.java class and 
	  Run As -> Run Configurations... , 
	  enter command 
	  
	  -ea -Djunit.jupiter.extensions.autodetection.enabled=true 

	  in VM arguments section under Arguments tab 	 
	 */
}
