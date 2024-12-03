package com.vibetrack.identity.controller;

import com.nimbusds.jose.JOSEException;
import com.vibetrack.identity.dto.request.AuthRequest;
import com.vibetrack.identity.dto.request.TokenRequest;
import com.vibetrack.identity.dto.request.UserCreationRequest;
import com.vibetrack.identity.dto.response.ApiResponse;
import com.vibetrack.identity.dto.response.AuthResponse;
import com.vibetrack.identity.dto.response.IntrospectResponse;
import com.vibetrack.identity.service.AuthService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthController {
    AuthService authService;

    @PostMapping("/register")
    ApiResponse<AuthResponse> register(@RequestBody UserCreationRequest request) {
        var result = authService.register(request);
        return ApiResponse.<AuthResponse>builder().result(result).build();
    }

    @PostMapping("/login")
    ApiResponse<AuthResponse> authenticate(@RequestBody @Valid AuthRequest request) {
        var result = authService.login(request);
        return ApiResponse.<AuthResponse>builder().result(result).build();
    }

    // Verify the token
    @PostMapping("/introspect")
    ApiResponse<IntrospectResponse> introspect(@RequestBody TokenRequest request)
            throws ParseException, JOSEException {
        var result = authService.introspect(request);
        return ApiResponse.<IntrospectResponse>builder().result(result).build();
    }

    @PostMapping("/refresh")
    ApiResponse<AuthResponse> refresh(@RequestBody TokenRequest request)
            throws ParseException, JOSEException {
        var result = authService.refreshToken(request);
        return ApiResponse.<AuthResponse>builder().result(result).build();
    }

    @PostMapping("/logout")
    ApiResponse<Void> logout(@RequestBody TokenRequest request) throws ParseException, JOSEException {
        authService.logout(request);
        return ApiResponse.<Void>builder().build();
    }
}
