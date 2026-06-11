package com.sneha.fitnesstracker.controller;

import com.sneha.fitnesstracker.model.User;
import com.sneha.fitnesstracker.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {

        if (userRepository.findByUsername(
                user.getUsername()) != null) {

            throw new RuntimeException(
                    "Username already exists");
        }

        return userRepository.save(user);
    }

    @PostMapping("/login")
    public User login(@RequestBody User request) {

        User user =
                userRepository.findByUsername(
                        request.getUsername());

        if (user == null) {

            throw new RuntimeException(
                    "User not found");
        }

        if (!user.getPassword()
                .equals(request.getPassword())) {

            throw new RuntimeException(
                    "Wrong password");
        }

        return user;
    }
}