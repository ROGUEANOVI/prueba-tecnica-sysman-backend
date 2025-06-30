package com.sysman.prueba_tecnica_sysman_backend.dto;

import com.sysman.prueba_tecnica_sysman_backend.constants.OpenApiConstants;
import com.sysman.prueba_tecnica_sysman_backend.constants.SecurityConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {

    @Schema(example = OpenApiConstants.REGISTER_EMAIL_EXAMPLE)
    @Email(message = SecurityConstants.EMAIL_INVALID)
    @NotBlank(message = SecurityConstants.EMAIL_REQUIRED)
    private String email;

    @Schema(example = OpenApiConstants.REGISTER_PASSWORD_EXAMPLE)
    @NotBlank(message = SecurityConstants.PASSWORD_REQUIRED)
    @Pattern(regexp = SecurityConstants.PASSWORD_PATTERN, message = SecurityConstants.PASSWORD_PATTERN_MESSAGE)
    private String password;
}
