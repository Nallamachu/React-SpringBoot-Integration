package com.softifyo.hospital.controller;

import com.softifyo.hospital.dto.LoginRequest;
import com.softifyo.hospital.dto.RegisterRequest;
import com.softifyo.hospital.entities.User;
import com.softifyo.hospital.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/v1")
    public String greetMessage() {
        return "Hello...! Welcome to Softifyo Hospital Management Application.";
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        User user = userService.register(request.getUsername(), request.getPassword(), request.getRoles());
        return ResponseEntity.ok("User registered");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        // Basic Auth handles login, or implement JWT token generation here
        return ResponseEntity.ok("Login successful");
    }
}