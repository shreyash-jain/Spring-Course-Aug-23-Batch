package com.shreyash.demo.Core.Security.Service;

import com.shreyash.demo.Core.Security.DTO.AuthenticationResponse;
import com.shreyash.demo.Core.Security.DTO.LoginRequest;
import com.shreyash.demo.Core.Security.DTO.RegisterRequest;

public interface IAuthService {
    AuthenticationResponse register(RegisterRequest registerRequest);
    AuthenticationResponse login(LoginRequest registerRequest);

}
