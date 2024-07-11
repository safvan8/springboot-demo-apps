package com.ospyn.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ospyn.dto.UserDTO;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {

	@GetMapping
	public String showRegistrationPage(Map<String, Object> model) {
		model.put("userDTO", new UserDTO());
		return "register";
	}

	@PostMapping("/new_user")
	 public String registerUser(
	            @ModelAttribute("userDTO") @Valid UserDTO userDTO,
	            BindingResult bindingResult,
	            Map<String, Object> model) {
	        if (bindingResult.hasErrors()) {
	            List<ObjectError> allErrors = bindingResult.getAllErrors();
	            for (ObjectError objectError : allErrors) {
	                System.out.println(objectError);
	            }
	            model.put("userDTO", userDTO);
	            return "register"; // return to the form page if there are validation errors
	        }
	        // Add logic to handle user registration (e.g., saving the user to the database)
	        return "registrationSuccess"; // redirect to a success page
	    }
}
