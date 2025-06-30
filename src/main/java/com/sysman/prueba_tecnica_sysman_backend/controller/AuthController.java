package com.sysman.prueba_tecnica_sysman_backend.controller;

import com.sysman.prueba_tecnica_sysman_backend.dto.AuthenticationRequest;
import com.sysman.prueba_tecnica_sysman_backend.dto.AuthenticationResponse;
import com.sysman.prueba_tecnica_sysman_backend.dto.RegisterRequest;
import com.sysman.prueba_tecnica_sysman_backend.security.ApplicationUserDetails;
import com.sysman.prueba_tecnica_sysman_backend.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@Valid @RequestBody RegisterRequest request) {
        authenticationService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(@Valid @RequestBody AuthenticationRequest request) {
        AuthenticationResponse response = authenticationService.authenticate(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/me")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<ApplicationUserDetails> getCurrentUser(Authentication authentication) {
        ApplicationUserDetails userDetails = (ApplicationUserDetails) authentication.getPrincipal();
        return ResponseEntity.ok(userDetails);
    }
}
