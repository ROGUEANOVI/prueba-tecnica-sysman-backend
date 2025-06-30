package com.sysman.prueba_tecnica_sysman_backend.dto;

import com.sysman.prueba_tecnica_sysman_backend.constants.SecurityConstants;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationRequest {

    @Email(message = SecurityConstants.EMAIL_INVALID)
    @NotBlank(message = SecurityConstants.EMAIL_REQUIRED)
    private String email;

    @NotBlank(message = SecurityConstants.PASSWORD_REQUIRED)
    private String password;
}
