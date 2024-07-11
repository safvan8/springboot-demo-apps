package com.ospyn.validation;

import java.util.Objects;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * AgeValidator class implements ConstraintValidator to provide custom
 * validation logic for the @Age annotation, ensuring that an Integer value
 * falls within a specified range.
 */
public class AgeValidator implements ConstraintValidator<Age, Integer> {

	private int lower;
	private int upper;

	/**
	 * Initializes the AgeValidator with the lower and upper bounds specified in
	 * the @Age annotation.
	 *
	 * @param age the Age annotation instance that contains the lower and upper
	 *            bound values.
	 */
	@Override
	public void initialize(Age age) {
		// Initializing the lower and upper bounds from the Age annotation
		this.lower = age.lower();
		this.upper = age.upper();
	}

	/**
	 * Validates whether the given age is within the specified lower and upper
	 * bounds.
	 *
	 * @param age     the age value to be validated.
	 * @param context the context in which the constraint is evaluated.
	 * @return true if the age is within the bounds or if the age is null; false
	 *         otherwise.
	 */
	@Override
	public boolean isValid(Integer age, ConstraintValidatorContext context) {
		// Return false if the age is null (indicating invalid value)
		if (Objects.isNull(age)) {
			return false;
		}

		// Check if the age is within the specified bounds
		if (age < lower || age > upper) {
			return false;
		}

		// Return true if the age is valid
		return true;
	}
}
