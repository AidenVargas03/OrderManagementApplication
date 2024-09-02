package com.gcu.ordermanagement.service;

import com.gcu.ordermanagement.data.entity.UserEntity;
import com.gcu.ordermanagement.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private UserRepository userRepository;

    public boolean registerUser(String username, String password, String email) {
        if (userRepository.findByUsername(username) != null) {
            return false;
        }

        UserEntity user = new UserEntity();
        user.setUsername(username);
        String encoded = new BCryptPasswordEncoder().encode(password);
        user.setPassword(encoded); 
        user.setEmail(email);

        userRepository.save(user);
        return true;
    }
}
