package com.learning.learning.auth;

import com.learning.learning.DTO.request.AuthenticationRequest;
import com.learning.learning.DTO.request.RegisterRequest;
import com.learning.learning.DTO.response.AuthenticationResponse;
import com.learning.learning.DTO.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private  final AuthenticationService  service;

    @PostMapping("/signup")
    public ApiResponse<AuthenticationResponse> register(
            @RequestBody @Valid RegisterRequest request
    ) {
        ApiResponse<AuthenticationResponse> response = new ApiResponse<>();
        response.setData(service.register(request));
     return response;
    }

    @PostMapping("/login")
    public ApiResponse<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        ApiResponse<AuthenticationResponse> response = new ApiResponse<>();
        response.setData(service.authenticate(request));
        return response;
    }
}

