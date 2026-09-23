package com.raghu.bookapi.controller;


import com.raghu.bookapi.dto.AuthResponse;
import com.raghu.bookapi.dto.LoginRequest;
import com.raghu.bookapi.dto.RegisterRequest;
import com.raghu.bookapi.model.User;
import com.raghu.bookapi.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request){

        authService.register(request);
            return ResponseEntity.status(201).body("User registered successfully");


    }


    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){
        AuthResponse authResponse=authService.login(request);
        return ResponseEntity.status(200).body(authResponse);

    }


}
