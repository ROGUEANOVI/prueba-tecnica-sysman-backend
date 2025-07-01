package com.sysman.prueba_tecnica_sysman_backend.controller;

import com.sysman.prueba_tecnica_sysman_backend.constants.LocationConstants;
import com.sysman.prueba_tecnica_sysman_backend.dto.CityResponseDTO;
import com.sysman.prueba_tecnica_sysman_backend.dto.DepartmentResponseDTO;
import com.sysman.prueba_tecnica_sysman_backend.service.LocationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(LocationConstants.PATH)
@RequiredArgsConstructor
@Tag(name = LocationConstants.TAG, description = LocationConstants.TAG_DESCRIPTION)
@PreAuthorize("isAuthenticated()")
public class LocationController {

    private final LocationService locationService;

    @Operation(
            summary = LocationConstants.DEPARTMENTS_SUMMARY,
            description = LocationConstants.DEPARTMENTS_DESC
    )
    @ApiResponse(responseCode = "200", description = LocationConstants.DEPARTMENTS_RESPONSE_DESCRIPTION)
    @GetMapping("/departments")
    public ResponseEntity<List<DepartmentResponseDTO>> getAllDepartments() {
        return ResponseEntity.ok(locationService.getAllDepartments());
    }

    @Operation(
            summary = LocationConstants.CITIES_SUMMARY,
            description = LocationConstants.CITIES_DESC
    )
    @ApiResponse(responseCode = "200", description = LocationConstants.CITIES_RESPONSE_DESCRIPTION)
    @GetMapping("/cities")
    public ResponseEntity<List<CityResponseDTO>> getAllCities(
            @Parameter(description = LocationConstants.PARAM_DEPARTMENT_CODE)
            @RequestParam(required = false) String departmentCode
    ) {
        return ResponseEntity.ok(locationService.getAllCitiesByDepartment(departmentCode));
    }
}
