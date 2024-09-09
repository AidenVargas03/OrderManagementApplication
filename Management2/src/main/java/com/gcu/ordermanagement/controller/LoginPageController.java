package com.gcu.ordermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.gcu.ordermanagement.data.entity.UserEntity;
import com.gcu.ordermanagement.model.User;
import com.gcu.ordermanagement.service.LoginService;

@Controller
public class LoginPageController {

	 @Autowired
	    private LoginService loginService; 

	@GetMapping("/login")
	public String showLoginForm(Model model) {
	    model.addAttribute("user", new User()); 
	    return "login";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute("user") User user, Model model) {
	    UserEntity authenticatedUser = loginService.authenticate(user.getUsername(), user.getPassword());
	    if (authenticatedUser != null) {
	        return "redirect:/products"; // Redirect to products page on successful login
	    } else {
	        model.addAttribute("error", "Invalid username or password");
	        return "login"; // Stay on login page if authentication fails
	    }
	}
}