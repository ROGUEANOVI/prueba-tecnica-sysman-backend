package com.sysman.prueba_tecnica_sysman_backend.controller;

import com.sysman.prueba_tecnica_sysman_backend.constants.MaterialConstants;
import com.sysman.prueba_tecnica_sysman_backend.dto.MaterialRequestDTO;
import com.sysman.prueba_tecnica_sysman_backend.dto.MaterialResponseDTO;
import com.sysman.prueba_tecnica_sysman_backend.service.MaterialService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(MaterialConstants.BASE_PATH)
@RequiredArgsConstructor
@Tag(name = MaterialConstants.TAG, description = MaterialConstants.TAG_DESCRIPTION)
public class MaterialController {

    private final MaterialService materialService;

    @Operation(summary = MaterialConstants.SUMMARY_SEARCH)
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description =MaterialConstants.DESC_FOUND),
        @ApiResponse(responseCode = "401", description =MaterialConstants.UNAUTHORIZED_RESPONSE)
    })
    @PreAuthorize("isAuthenticated()")
    @GetMapping
    public ResponseEntity<List<MaterialResponseDTO>> searchMaterials(
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String cityCode,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate purchaseDate
    ) {
        return ResponseEntity.ok(materialService.searchMaterials(type, cityCode, purchaseDate));
    }

    @Operation(summary = MaterialConstants.SUMMARY_GET_BY_ID)
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = MaterialConstants.DESC_FOUND_ONE),
        @ApiResponse(responseCode = "401", description =MaterialConstants.UNAUTHORIZED_RESPONSE)
    })
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/{id}")
    public ResponseEntity<MaterialResponseDTO> getMaterialById(@PathVariable Long id) {
        return ResponseEntity.ok(materialService.getMaterialById(id));
    }

    @Operation(summary = MaterialConstants.SUMMARY_CREATE)
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = MaterialConstants.DESC_CREATED),
        @ApiResponse(responseCode = "400", description =MaterialConstants.BAD_REQUEST_RESPONSE),
        @ApiResponse(responseCode = "401", description =MaterialConstants.UNAUTHORIZED_RESPONSE),
        @ApiResponse(responseCode = "403", description =MaterialConstants.FORBIDDEN_RESPONSE)
    })
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<MaterialResponseDTO> createMaterial(
            @Valid @RequestBody MaterialRequestDTO request
    ) {
        MaterialResponseDTO response = materialService.createMaterial(request);
        return ResponseEntity.status(201).body(response);
    }

    @Operation(summary = MaterialConstants.SUMMARY_UPDATE)
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = MaterialConstants.DESC_UPDATED),
        @ApiResponse(responseCode = "400", description =MaterialConstants.BAD_REQUEST_RESPONSE),
        @ApiResponse(responseCode = "401", description =MaterialConstants.UNAUTHORIZED_RESPONSE),
        @ApiResponse(responseCode = "403", description =MaterialConstants.FORBIDDEN_RESPONSE)
    })
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<MaterialResponseDTO> updateMaterial(
            @PathVariable Long id,
            @Valid @RequestBody MaterialRequestDTO request
    ) {
        return ResponseEntity.ok(materialService.updateMaterial(id, request));
    }

    @Operation(summary = MaterialConstants.SUMMARY_DELETE)
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = MaterialConstants.DESC_DELETED),
        @ApiResponse(responseCode = "400", description =MaterialConstants.BAD_REQUEST_RESPONSE),
        @ApiResponse(responseCode = "401", description =MaterialConstants.UNAUTHORIZED_RESPONSE),
        @ApiResponse(responseCode = "403", description =MaterialConstants.FORBIDDEN_RESPONSE)
    })
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMaterial(@PathVariable Long id) {
        materialService.deleteMaterial(id);
        return ResponseEntity.noContent().build();
    }
}
