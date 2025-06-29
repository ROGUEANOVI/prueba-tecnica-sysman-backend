package com.sysman.prueba_tecnica_sysman_backend.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CityDTO {

    private String code;

    private String name;

    private DepartmentDTO department;
}
