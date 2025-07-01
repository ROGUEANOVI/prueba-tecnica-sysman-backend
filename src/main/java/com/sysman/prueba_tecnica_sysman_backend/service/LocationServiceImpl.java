package com.sysman.prueba_tecnica_sysman_backend.service;

import com.sysman.prueba_tecnica_sysman_backend.dto.CityResponseDTO;
import com.sysman.prueba_tecnica_sysman_backend.dto.DepartmentResponseDTO;
import com.sysman.prueba_tecnica_sysman_backend.mapper.LocationMapper;
import com.sysman.prueba_tecnica_sysman_backend.repository.CityRepository;
import com.sysman.prueba_tecnica_sysman_backend.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final DepartmentRepository departmentRepository;
    private final CityRepository cityRepository;
    private final LocationMapper mapper;

    @Override
    public List<DepartmentResponseDTO> getAllDepartments() {
        return departmentRepository.findAll()
                .stream()
                .map(mapper::toDepartmentDto)
                .toList();
    }

    @Override
    public List<CityResponseDTO> getAllCitiesByDepartment(String departmentCode) {
        if (departmentCode != null) {
            return cityRepository.findByDepartment_Code(departmentCode)
                    .stream()
                    .map(mapper::toCityDto)
                    .toList();
        }
        return cityRepository.findAll()
                .stream()
                .map(mapper::toCityDto)
                .toList();
    }
}
