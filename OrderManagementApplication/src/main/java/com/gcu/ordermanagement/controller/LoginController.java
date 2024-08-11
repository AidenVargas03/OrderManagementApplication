package com.gcu.ordermanagement.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.gcu.ordermanagement.model.User;
import com.gcu.ordermanagement.service.LoginService;

@Controller
public class LoginController {

		@Autowired
		private LoginService loginService;
		
		@GetMapping("/login")
		public String showLoginForm(Model model) {
			model.addAttribute("user", new User());
			return "login";
		}
		
		@PostMapping("/login")
		public String loginUser(@ModelAttribute User user, BindingResult result, Model model) {
			boolean isAuthenticated = loginService.authenticate(user.getUsername(), user.getPassword());
			if (isAuthenticated) {
				return "redirect:/products/";
			} else {
				model.addAttribute("error", "Invalid credentials");
				return "login";
			}
		}
}
