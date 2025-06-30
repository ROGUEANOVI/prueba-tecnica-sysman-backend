package com.sysman.prueba_tecnica_sysman_backend.service;

import com.sysman.prueba_tecnica_sysman_backend.dto.MaterialRequestDTO;
import com.sysman.prueba_tecnica_sysman_backend.dto.MaterialResponseDTO;

import java.time.LocalDate;
import java.util.List;

public interface MaterialService {

    List<MaterialResponseDTO> searchMaterials(String type, String city, LocalDate purchaseDate);

    MaterialResponseDTO getMaterialById(Long id);

    MaterialResponseDTO createMaterial(MaterialRequestDTO requestDTO);

    void updateMaterial(Long id, MaterialRequestDTO requestDTO);

    void deleteMaterial(Long id);
}
