package com.example.bt10.service;

import com.example.bt10.entity.User;
import com.example.bt10.model.LoginUserModel;
import com.example.bt10.model.RegisterUserModel;
import com.example.bt10.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository userRepository,
                                PasswordEncoder passwordEncoder,
                                AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public User signup(RegisterUserModel registerUserModel) {
        User user = new User();
        user.setFullName(registerUserModel.getFullName());
        user.setEmail(registerUserModel.getEmail());
        user.setPassword(passwordEncoder.encode(registerUserModel.getPassword()));
        return userRepository.save(user);
    }

    public User authenticate(LoginUserModel loginUserModel) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUserModel.getEmail(),
                        loginUserModel.getPassword()
                )
        );

        return userRepository.findByEmail(loginUserModel.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));
    }
}
