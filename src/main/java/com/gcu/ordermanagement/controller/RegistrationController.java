package com.gcu.ordermanagement.controller;

import com.gcu.ordermanagement.model.User;
import com.gcu.ordermanagement.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user, Model model) {
        if (registrationService.registerUser(user.getUsername(), user.getPassword(), user.getEmail())) {
            return "redirect:/login"; // Redirect to login page after successful registration
        } else {
            model.addAttribute("error", "Username already exists");
            return "register";
}
    }
}
