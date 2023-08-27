package com.safvan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String showHomePage() {
		return "HomePage";
	}

	@GetMapping("/welcome")
	public String showWelcomePage() {
		return "WelcomePage";
	}

	@GetMapping("/admin")
	public String showAdminPage() {
		return "AdminPage";
	}

	@GetMapping("/emp")
	public String showEmployeePage() {
		return "EmployeePage";
	}

	@GetMapping("/std")
	public String showStudentPage() {
		return "StudentPage";
	}

	@GetMapping("/denied")
	public String showDeniedPage() {
		return "DeniedPage";
	}
}
