package com.example.testingexistingproject.Authentication;

import com.example.testingexistingproject.login.LoginForm;
import com.example.testingexistingproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;

    @Autowired
    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String register(LoginForm user) {
        // Check if the username already exists
        if (userRepository.existsByUsername(user.getUsername())) {
            return "redirect:/registration?usernameExists=true";
        }

        // Check if the password already exists
        if (userRepository.existsByPassword(user.getPassword())) {
            return "redirect:/registration?passwordExists=true";
        }

        // Redirect to the registration form
        return "redirect:/registration";
    }
}