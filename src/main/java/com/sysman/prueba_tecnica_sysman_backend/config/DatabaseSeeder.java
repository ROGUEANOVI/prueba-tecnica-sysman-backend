package com.sysman.prueba_tecnica_sysman_backend.config;

import com.sysman.prueba_tecnica_sysman_backend.entity.*;
import com.sysman.prueba_tecnica_sysman_backend.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class DatabaseSeeder {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final DepartmentRepository departmentRepository;
    private final CityRepository cityRepository;
    private final MaterialRepository materialRepository;
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

            // Departments and Cities (DANE Codes)
            if (departmentRepository.count() == 0 && cityRepository.count() == 0) {
                Department cundinamarca = Department.builder().code("25").name("Cundinamarca").build();
                Department antioquia = Department.builder().code("05").name("Antioquia").build();
                Department valle = Department.builder().code("76").name("Valle del Cauca").build();

                departmentRepository.saveAll(List.of(cundinamarca, antioquia, valle));

                City bogota = City.builder().code("25001").name("Bogotá").department(cundinamarca).build();
                City medellin = City.builder().code("05001").name("Medellín").department(antioquia).build();
                City cali = City.builder().code("76001").name("Cali").department(valle).build();

                cityRepository.saveAll(List.of(bogota, medellin, cali));
            }

            // Materials
            if (materialRepository.count() == 0) {
                City bogota = (City) cityRepository.findByCode("25001").orElseThrow();
                City medellin = (City) cityRepository.findByCode("05001").orElseThrow();
                City cali = (City) cityRepository.findByCode("76001").orElseThrow();

                Material m1 = Material.builder()
                        .name("Cemento Portland")
                        .description("Saco de cemento de alta resistencia")
                        .type("Construcción")
                        .status("Disponible")
                        .price(BigDecimal.valueOf(32000.0))
                        .purchaseDate(LocalDate.of(2024, 12, 10))
                        .saleDate(LocalDate.of(2025, 1, 10))
                        .city(bogota)
                        .build();

                Material m2 = Material.builder()
                        .name("Arena gruesa")
                        .description("Arena de río para mezcla")
                        .type("Construcción")
                        .status("Disponible")
                        .price(BigDecimal.valueOf(18000.0))
                        .purchaseDate(LocalDate.of(2024, 11, 5))
                        .saleDate(LocalDate.of(2025, 1, 20))
                        .city(medellin)
                        .build();

                Material m3 = Material.builder()
                        .name("Tubos PVC 4 pulgadas")
                        .description("Tubos para instalación sanitaria")
                        .type("Plomería")
                        .status("Agotado")
                        .price(BigDecimal.valueOf(25000.0))
                        .purchaseDate(LocalDate.of(2024, 10, 1))
                        .saleDate(LocalDate.of(2024, 12, 15))
                        .city(cali)
                        .build();

                materialRepository.saveAll(List.of(m1, m2, m3));
            }

        };
    }
}
