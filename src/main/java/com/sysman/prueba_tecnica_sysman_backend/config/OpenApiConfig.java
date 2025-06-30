package com.sysman.prueba_tecnica_sysman_backend.config;

import com.sysman.prueba_tecnica_sysman_backend.constants.OpenApiMessages;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title(OpenApiMessages.TITLE)
                        .description(OpenApiMessages.DESCRIPTION)
                        .version(OpenApiMessages.VERSION)
                        .contact(new Contact()
                                .name(OpenApiMessages.CONTACT_NAME)
                                .email(OpenApiMessages.CONTACT_EMAIL)
                                .url(OpenApiMessages.CONTACT_URL)
                        )
                )
                .addSecurityItem(new SecurityRequirement()
                        .addList(OpenApiMessages.SECURITY_SCHEME_NAME)
                )
                .components(new Components()
                        .addSecuritySchemes(OpenApiMessages.SECURITY_SCHEME_NAME, new SecurityScheme()
                                .name(OpenApiMessages.SECURITY_SCHEME_NAME)
                                .type(SecurityScheme.Type.HTTP)
                                .scheme(OpenApiMessages.SCHEME)
                                .bearerFormat(OpenApiMessages.BEARER_FORMAT)
                        )
                );
    }
}
