package com.ospyn.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = AgeValidator.class)
public @interface Age {
	String message() default "Age should be between {lower} - {upper}";

	int lower() default 18;

	int upper() default 60;

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
