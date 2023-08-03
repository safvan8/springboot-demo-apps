package com.infosys.service;

import java.util.HashSet;
import java.util.Set;

public enum RomanNumeral {
	I(1), IV(4), V(5), IX(9), X(10), XL(40), L(50), XC(90), C(100), CD(400), D(500), CM(900), M(1000);

	int weight;

	RomanNumeral(int weight) {
		this.weight = weight;
	}

	private static final Set<String> values = new HashSet<>(RomanNumeral.values().length);

	static {
		for (RomanNumeral f : RomanNumeral.values())
			values.add(f.name());
	}

	public static boolean contains(String value) {
		return values.contains(value);
	}
}