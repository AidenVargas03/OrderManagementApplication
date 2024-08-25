package com.gcu.ordermanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LandingPage {
	
	@GetMapping("/")
	public String display(Model model) {
		model.addAttribute("title","Login");
			
		return "login";
	}
	

}
