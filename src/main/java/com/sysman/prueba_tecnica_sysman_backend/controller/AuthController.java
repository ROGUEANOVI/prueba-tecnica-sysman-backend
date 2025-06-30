package com.sysman.prueba_tecnica_sysman_backend.controller;

import com.sysman.prueba_tecnica_sysman_backend.constants.AuthConstants;
import com.sysman.prueba_tecnica_sysman_backend.dto.AuthenticationRequest;
import com.sysman.prueba_tecnica_sysman_backend.dto.AuthenticationResponse;
import com.sysman.prueba_tecnica_sysman_backend.dto.RegisterRequest;
import com.sysman.prueba_tecnica_sysman_backend.security.ApplicationUserDetails;
import com.sysman.prueba_tecnica_sysman_backend.service.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(AuthConstants.BASE_PATH)
@RequiredArgsConstructor
@Tag(name = AuthConstants.TAG, description = AuthConstants.TAG_DESCRIPTION)
public class AuthController {

    private final AuthenticationService authenticationService;

    @Operation(
            summary = AuthConstants.REGISTER_SUMMARY,
            description = AuthConstants.REGISTER_DESCRIPTION
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = AuthConstants.REGISTER_SUCCESS),
            @ApiResponse(responseCode = "400", description = AuthConstants.BAD_REQUEST, content = @Content)
    })
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@Valid @RequestBody RegisterRequest request) {
        authenticationService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(
            summary = AuthConstants.LOGIN_SUMMARY,
            description = AuthConstants.LOGIN_DESCRIPTION
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = AuthConstants.LOGIN_SUCCESS,
                    content = @Content(schema = @Schema(implementation = AuthenticationResponse.class))),
            @ApiResponse(responseCode = "401", description = AuthConstants.UNAUTHORIZED_RESPONSE, content = @Content)
    })
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(@Valid @RequestBody AuthenticationRequest request) {
        AuthenticationResponse response = authenticationService.authenticate(request);
        return ResponseEntity.ok(response);
    }

    @Operation(
            summary = AuthConstants.ME_SUMMARY,
            description = AuthConstants.ME_DESCRIPTION,
            security = @SecurityRequirement(name = AuthConstants.BEARER_AUTH)
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = AuthConstants.ME_SUCCESS,
                    content = @Content(schema = @Schema(implementation = ApplicationUserDetails.class))),
            @ApiResponse(responseCode = "403", description = AuthConstants.FORBIDDEN, content = @Content)
    })
    @GetMapping("/me")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<ApplicationUserDetails> getCurrentUser(Authentication authentication) {
        ApplicationUserDetails userDetails = (ApplicationUserDetails) authentication.getPrincipal();
        return ResponseEntity.ok(userDetails);
    }
}

