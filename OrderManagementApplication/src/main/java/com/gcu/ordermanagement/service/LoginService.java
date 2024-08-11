package com.gcu.ordermanagement.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public boolean authenticate(String username, String password) {
        // Hardcoded login for testing
        return "admin".equals(username) && "password".equals(password);
    }
}

