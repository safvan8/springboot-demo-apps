package com.ospyn.validation;

import java.util.Objects;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<Age, Integer> {

	private int lower;
	private int upper;

	@Override
	public void initialize(Age age) {
		// write any pre-constrcution logic here
		this.lower = age.lower();
		this.upper = age.upper();
	}

	@Override
	public boolean isValid(Integer age, ConstraintValidatorContext context) {
		if (Objects.isNull(age))
			return false;

		if (age < lower || age > upper)
			return false;

		return true;
	}

}
