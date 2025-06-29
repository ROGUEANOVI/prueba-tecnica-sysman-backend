package com.sysman.prueba_tecnica_sysman_backend.mapper;

import com.sysman.prueba_tecnica_sysman_backend.constants.MapperConstants;
import com.sysman.prueba_tecnica_sysman_backend.dto.DepartmentDTO;
import com.sysman.prueba_tecnica_sysman_backend.entity.Department;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = MapperConstants.SPRING)
public interface DepartmentMapper {

    DepartmentDTO toDto(Department department);
}
