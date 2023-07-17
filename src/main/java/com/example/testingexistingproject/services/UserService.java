package com.example.testingexistingproject.services;



import com.example.testingexistingproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public SecurityProperties.User register(SecurityProperties.User user) {
        // Add additional registration logic if needed
        return userRepository.save(user);
    }
}
