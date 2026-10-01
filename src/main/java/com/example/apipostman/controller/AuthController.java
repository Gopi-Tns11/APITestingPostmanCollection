package com.example.apipostman.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(
            @RequestBody Map<String, String> loginRequest) {

        String username = loginRequest.get("username");
        String password = loginRequest.get("password");

        Map<String, String> response = new HashMap<>();

        if ("admin".equals(username) && "admin123".equals(password)) {

            response.put("token", "POSTMAN-TEST-TOKEN-12345");
            response.put("message", "Login successful");

            return ResponseEntity.ok(response);
        }

        response.put("message", "Invalid username or password");

        return ResponseEntity.status(401).body(response);
    }
}