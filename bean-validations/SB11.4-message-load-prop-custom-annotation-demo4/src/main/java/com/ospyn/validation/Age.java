package com.ospyn.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

/**
 * The @Age annotation is used to validate that an Integer field falls within a
 * specified age range. This annotation is documented and retained at runtime,
 * and it targets field-level declarations.
 */
@Documented
@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = AgeValidator.class)
public @interface Age {

	/**
	 * Defines the default error message if the age validation fails. The message
	 * can be overridden by specifying a custom message.
	 *
	 * @return the error message
	 */
	String message() default "{safvan.app.message.age.invalidError}";

	
	int lower() default 18;

	int upper() default 60;

	/**
	 * Allows the specification of validation groups, to which this constraint
	 * belongs. This must default to an empty array.
	 *
	 * @return the groups the constraint belongs to
	 */
	Class<?>[] groups() default {};

	/**
	 * Can be used by clients of the Bean Validation API to assign custom payload
	 * objects to a constraint. This attribute is not used by the API itself.
	 *
	 * @return the payload
	 */
	Class<? extends Payload>[] payload()default{};
}
