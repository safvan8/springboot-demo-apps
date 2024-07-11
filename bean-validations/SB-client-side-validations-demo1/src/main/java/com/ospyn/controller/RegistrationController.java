package com.ospyn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {

	@GetMapping
	public String showRegistrationPage() {
		return "register";
	}

	@PostMapping
	public String registerUser() {
		// TODO Auto-generated method stub
		return "registeration_success";
	}
}
