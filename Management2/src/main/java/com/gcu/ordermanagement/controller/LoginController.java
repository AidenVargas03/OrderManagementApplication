package com.gcu.ordermanagement.controller;

import com.gcu.ordermanagement.model.User;
import com.gcu.ordermanagement.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    // This method handles GET requests and displays the login form
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    // This method handles POST requests and processes the login
    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user, Model model) {
        User authenticatedUser = loginService.authenticate(user.getUsername(), user.getPassword());
        if (authenticatedUser != null) {
            return "redirect:/products"; // Redirect to the products page on successful login
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }
}

