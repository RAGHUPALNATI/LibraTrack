package com.raghu.bookapi.service;

import com.raghu.bookapi.dto.AuthResponse;
import com.raghu.bookapi.dto.LoginRequest;
import com.raghu.bookapi.dto.RegisterRequest;
import com.raghu.bookapi.model.Role;
import com.raghu.bookapi.model.User;
import com.raghu.bookapi.repository.UserRepository;
import com.raghu.bookapi.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public String register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists: " + request.getEmail());
        }
        String hashedPassword = passwordEncoder.encode(request.getPassword());
        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(hashedPassword)
                .role(Role.valueOf(request.getRole()))
                .build();
        userRepository.save(user);
        return "User registered successfully";
    }

    public AuthResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtUtil.generateToken(
                user.getEmail(),
                user.getRole().name()
        );

        return new AuthResponse(token, user.getEmail(), user.getRole().name());
    }
}