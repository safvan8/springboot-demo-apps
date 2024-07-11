package com.ospyn.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import com.ospyn.validation.Age;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDTO {

	@NotBlank(message = "First Name is required")
	private String firstName;

	@NotBlank(message = "Last Name is required")
	private String lastName;

	@Age(lower = 20, upper = 40)
	private Integer age;

	@Email(message = "Email should be valid")
	@NotBlank(message = "Email is required")
	private String email;

	@Size(min = 8, message = "Password must be at least 8 characters")
	private String password;

	@NotBlank(message = "Confirm Password is required")
	private String confirmPassword;

	@NotBlank(message = "Address is required")
	private String address;

	@Pattern(regexp = "\\+91\\d{10}", message = "Phone number should be valid and start with +91")
	private String phoneNumber;

	private MultipartFile image;

	@NotNull(message = "Date of Birth is required")
	@Past(message = "Date of Birth must be in the past")
	private Date dateOfBirth;

	@NotBlank(message = "Gender is required")
	private String gender;

	@NotBlank(message = "Country is required")
	private String country;

	@AssertTrue(message = "You must accept the terms of use")
	private Boolean termsAccepted;

	// Getters and Setters
}
