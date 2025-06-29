package com.sysman.prueba_tecnica_sysman_backend.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MaterialResponseDTO {

    private Long id;

    private String name;

    private String description;

    private String type;

    private BigDecimal price;

    private LocalDate purchaseDate;

    private LocalDate saleDate;

    private String status;

    private CityDTO city;
}
