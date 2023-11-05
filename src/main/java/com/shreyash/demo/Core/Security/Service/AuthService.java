package com.shreyash.demo.Core.Security.Service;

import com.shreyash.demo.Core.Security.DTO.AuthenticationResponse;
import com.shreyash.demo.Core.Security.DTO.LoginRequest;
import com.shreyash.demo.Core.Security.DTO.RegisterRequest;
import com.shreyash.demo.Core.Security.Model.User;
import com.shreyash.demo.Core.Security.Repository.UserRepository;
import com.shreyash.demo.Core.Utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService implements IAuthService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    private static final long AUTH_EXPIRATION_TIME = 464_000_000;
    private static final long REFRESH_EXPIRATION_TIME = 964_000_000;

    @Override
    public AuthenticationResponse register(RegisterRequest registerRequest) {

        // validate the request body
        // check if user already exists in db
        Optional<User> userOptional =  userRepository.findByEmail(registerRequest.getEmail());
        if(userOptional.isPresent()) throw new RuntimeException("User Already there");

        var user = User.builder()
                .firstname(registerRequest.getFirstname())
                .lastname(registerRequest.getLastname())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(registerRequest.getRole())
                .build();

        userRepository.save(user);

        var jwtToken = JwtUtil.generateToken(user.getUsername(), AUTH_EXPIRATION_TIME);
        var refreshToken = JwtUtil.generateToken(user.getUsername(), REFRESH_EXPIRATION_TIME);

        return AuthenticationResponse.builder().accessToken(jwtToken).refreshToken(refreshToken).build();
    }

    @Override
    public AuthenticationResponse login(LoginRequest registerRequest) {
        return null;
    }
}
