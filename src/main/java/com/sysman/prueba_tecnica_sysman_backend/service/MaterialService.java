package com.sysman.prueba_tecnica_sysman_backend.service;

import com.sysman.prueba_tecnica_sysman_backend.dto.MaterialRequestDTO;
import com.sysman.prueba_tecnica_sysman_backend.dto.MaterialResponseDTO;

import java.time.LocalDate;
import java.util.List;

public interface MaterialService {

    List<MaterialResponseDTO> getAllMaterials();

    List<MaterialResponseDTO> getMaterialsByType(String type);

    List<MaterialResponseDTO> getMaterialsByPurchaseDate(LocalDate date);

    List<MaterialResponseDTO> getMaterialsByTypeAndPurchaseDate(String type, LocalDate date);

    List<MaterialResponseDTO> getMaterialsByCityCode(String cityCode);

    MaterialResponseDTO createMaterial(MaterialRequestDTO requestDTO);

    MaterialResponseDTO updateMaterial(Long id, MaterialRequestDTO requestDTO);

    void deleteMaterial(Long id);
}
