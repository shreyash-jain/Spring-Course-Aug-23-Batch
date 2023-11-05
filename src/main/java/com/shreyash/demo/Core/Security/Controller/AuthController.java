package com.shreyash.demo.Core.Security.Controller;


import com.shreyash.demo.Core.Security.DTO.AuthenticationResponse;
import com.shreyash.demo.Core.Security.DTO.LoginRequest;
import com.shreyash.demo.Core.Security.DTO.RegisterRequest;
import com.shreyash.demo.Core.Security.Service.IAuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    IAuthService authService;

    @PostMapping("register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest registerRequest){

        return ResponseEntity.ok(authService.register(registerRequest));
    }

    @PostMapping("login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody LoginRequest registerRequest){
        return ResponseEntity.ok(null);
    }

    @PostMapping("refresh-token")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody String refreshToken){
        return ResponseEntity.ok(null);
    }
}
