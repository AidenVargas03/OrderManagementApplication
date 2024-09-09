package com.gcu.ordermanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

	@GetMapping("/")
	public String Home(Model model) {
		model.addAttribute("title","My Home");
		return "home";
	}

}
