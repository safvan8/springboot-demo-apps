package com.safvan.utility;

import org.springframework.stereotype.Component;

@Component
public class BusinessLogic {

	public boolean isPalindrome(String str) {
		// Initializing an empty string to store the reverse
		// of the original str
		String rev = "";

		// Initializing a new boolean variable for the
		// answer
		boolean ans = false;

		for (int i = str.length() - 1; i >= 0; i--) {
			rev = rev + str.charAt(i);
		}

		// Checking if both the strings are equal
		if (str.equals(rev)) {
			ans = true;
		}
		return ans;
	}

	public String isEvenOrOdd(String numberInput) {

		int input = Integer.parseInt(numberInput);

		if (input % 2 == 0)
			return "even";

		return "odd";
	}
}
