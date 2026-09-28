package com.example.bt10.controller;

import com.example.bt10.entity.User;
import com.example.bt10.model.LoginResponse;
import com.example.bt10.model.LoginUserModel;
import com.example.bt10.model.RegisterUserModel;
import com.example.bt10.service.AuthenticationService;
import com.example.bt10.service.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final JwtService jwtService;

    public AuthenticationController(AuthenticationService authenticationService, JwtService jwtService) {
        this.authenticationService = authenticationService;
        this.jwtService = jwtService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody RegisterUserModel registerUserModel) {
        User user = authenticationService.signup(registerUserModel);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginUserModel loginUserModel) {
        User user = authenticationService.authenticate(loginUserModel);
        String token = jwtService.generateToken(user);

        LoginResponse response = new LoginResponse(token, 86400000L);
        return ResponseEntity.ok(response);
    }
}
