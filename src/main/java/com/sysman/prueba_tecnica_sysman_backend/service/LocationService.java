package com.sysman.prueba_tecnica_sysman_backend.service;

import com.sysman.prueba_tecnica_sysman_backend.dto.CityResponseDTO;
import com.sysman.prueba_tecnica_sysman_backend.dto.DepartmentResponseDTO;

import java.util.List;

public interface LocationService {
    List<DepartmentResponseDTO> getAllDepartments();
    List<CityResponseDTO> getAllCitiesByDepartment(String departmentCode);
}
