package com.gcu.ordermanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.ordermanagement.data.entity.UserEntity;
import com.gcu.ordermanagement.data.repository.UserRepository;


@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity authenticate(String username, String password) {
        UserEntity user = userRepository.findByUsername(username);
        if (user == null) {
            return null; 
        }
    
        if (user.getPassword().equals(password)) {
            return user; 
        } else {
            return null; 
        }
    }
}
