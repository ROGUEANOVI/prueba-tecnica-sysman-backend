package com.sysman.prueba_tecnica_sysman_backend.config;

import com.sysman.prueba_tecnica_sysman_backend.entity.Role;
import com.sysman.prueba_tecnica_sysman_backend.entity.User;
import com.sysman.prueba_tecnica_sysman_backend.repository.RoleRepository;
import com.sysman.prueba_tecnica_sysman_backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class DatabaseSeeder {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Bean
    public CommandLineRunner seedDatabase() {

        return args -> {
            if (roleRepository.count() == 0) {
                Role userRole = Role.builder().name("ROLE_USER").build();
                Role adminRole = Role.builder().name("ROLE_ADMIN").build();
                roleRepository.saveAll(List.of(userRole, adminRole));
            }

            if (userRepository.count() == 0) {
                Role userRole = roleRepository.findByName("ROLE_USER").orElseThrow();
                Role adminRole = roleRepository.findByName("ROLE_ADMIN").orElseThrow();

                User user1 = User.builder()
                        .email("juan@example.com")
                        .password(passwordEncoder.encode("Xyz123AB"))
                        .role(userRole)
                        .build();

                User user2 = User.builder()
                        .email("ana@example.com")
                        .password(passwordEncoder.encode("aBcD9876"))
                        .role(userRole)
                        .build();

                User user3 = User.builder()
                        .email("admin@example.com")
                        .password(passwordEncoder.encode("Pa55wordX"))
                        .role(adminRole)
                        .build();

                userRepository.saveAll(List.of(user1, user2, user3));
            }
        };
    }
}
