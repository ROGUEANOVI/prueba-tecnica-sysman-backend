package com.sysman.prueba_tecnica_sysman_backend.mapper;

import com.sysman.prueba_tecnica_sysman_backend.constants.MapperConstants;
import com.sysman.prueba_tecnica_sysman_backend.dto.CityResponseDTO;
import com.sysman.prueba_tecnica_sysman_backend.dto.DepartmentResponseDTO;
import com.sysman.prueba_tecnica_sysman_backend.entity.City;
import com.sysman.prueba_tecnica_sysman_backend.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = MapperConstants.SPRING)
public interface LocationMapper {

    @Mapping(source = "department.code", target = "departmentCode")
    CityResponseDTO toCityDto(City city);

    DepartmentResponseDTO toDepartmentDto(Department department);
}
