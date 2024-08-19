package com.gcu.ordermanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.ordermanagement.data.repository.UserRepository;
import com.gcu.ordermanagement.model.User;

@Service
public class RegistrationService {

    @Autowired
    private UserRepository userRepository;

    public void register(User user) {
        // Password encryption can be added here
        userRepository.save(user);
    }
}
