package com.example.projetoCityDenuncia.controller;

import com.example.projetoCityDenuncia.dto.LoginRequest;
import com.example.projetoCityDenuncia.dto.RegisterRequest;
import com.example.projetoCityDenuncia.dto.TokenResponse;
import com.example.projetoCityDenuncia.infra.security.TokenService;
import com.example.projetoCityDenuncia.model.User;
import com.example.projetoCityDenuncia.model.UserRole;
import com.example.projetoCityDenuncia.repository.UserRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegisterRequest user) {
        if (this.userRepository.findByEmail(user.getEmail()).isPresent())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        String encryptedPassword = passwordEncoder.encode(user.getPassword());
        User newUser = new User(user.getName(), user.getEmail(), encryptedPassword, UserRole.USER);

        userRepository.save(newUser);

        return ResponseEntity.ok(newUser);
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody LoginRequest user) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        String token = tokenService.generateToken((User) auth.getPrincipal());
        String refreshToken = tokenService.generateRefreshToken(token);

        TokenResponse response = new TokenResponse(token, refreshToken);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/refresh")
    public ResponseEntity<TokenResponse> refresh(@RequestBody TokenResponse tokenResponse) {
        String token = tokenService.generateAccessTokenFromRefreshToken(tokenResponse.getRefreshToken());
        String refreshToken = tokenService.generateRefreshToken(token);

        TokenResponse response = new TokenResponse(token, refreshToken);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}