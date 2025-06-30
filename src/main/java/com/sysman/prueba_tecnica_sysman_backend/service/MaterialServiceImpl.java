package com.sysman.prueba_tecnica_sysman_backend.service;

import com.sysman.prueba_tecnica_sysman_backend.constants.ExceptionMessages;
import com.sysman.prueba_tecnica_sysman_backend.constants.LogMessages;
import com.sysman.prueba_tecnica_sysman_backend.dto.MaterialRequestDTO;
import com.sysman.prueba_tecnica_sysman_backend.dto.MaterialResponseDTO;
import com.sysman.prueba_tecnica_sysman_backend.entity.Material;
import com.sysman.prueba_tecnica_sysman_backend.exception.CityNotFoundException;
import com.sysman.prueba_tecnica_sysman_backend.exception.DuplicateMaterialException;
import com.sysman.prueba_tecnica_sysman_backend.exception.InvalidMaterialDatesException;
import com.sysman.prueba_tecnica_sysman_backend.exception.MaterialNotFoundException;
import com.sysman.prueba_tecnica_sysman_backend.mapper.MaterialMapper;
import com.sysman.prueba_tecnica_sysman_backend.repository.CityRepository;
import com.sysman.prueba_tecnica_sysman_backend.repository.MaterialRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class MaterialServiceImpl implements MaterialService {

    private final MaterialRepository materialRepository;

    private final MaterialMapper materialMapper;

    private final CityRepository cityRepository;


    @Override
    public List<MaterialResponseDTO> searchMaterials(String type, String cityCode, LocalDate purchaseDate) {

        List<Material> materials = materialRepository.findAll().stream()
                .filter(material -> type == null || material.getType().equalsIgnoreCase(type))
                .filter(material -> cityCode == null || material.getCity().getCode().equalsIgnoreCase(cityCode))
                .filter(material -> purchaseDate == null || purchaseDate.equals(material.getPurchaseDate()))
                .toList();

        log.info(LogMessages.SEARCHING_MATERIALS, type, cityCode, purchaseDate);
        return materials.stream()
                .map(materialMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public MaterialResponseDTO getMaterialById(Long id) {

        Material material = materialRepository.findById(id)
                .orElseThrow(() -> new MaterialNotFoundException(ExceptionMessages.MATERIAL_NOT_FOUND, id));

        log.info(LogMessages.GETTING_MATERIAL, id);
        return materialMapper.toDto(material);
    }


    @Override
    public MaterialResponseDTO createMaterial(MaterialRequestDTO requestDTO) {

        validateUniqueMaterial(requestDTO);
        validateCity(requestDTO.getCityCode());
        validateDates(requestDTO.getPurchaseDate(), requestDTO.getSaleDate());

        Material material = materialMapper.toEntity(requestDTO);
        Material saved = materialRepository.save(material);

        log.info(LogMessages.CREATING_MATERIAL, saved.getId());
        return materialMapper.toDto(saved);
    }

    @Override
    public MaterialResponseDTO updateMaterial(Long id, MaterialRequestDTO requestDTO) {

        Material existing = materialRepository.findById(id)
                .orElseThrow(() -> new MaterialNotFoundException(ExceptionMessages.MATERIAL_NOT_FOUND, id));

        validateCity(requestDTO.getCityCode());
        validateDates(requestDTO.getPurchaseDate(), requestDTO.getSaleDate());

        Material updated = materialMapper.toEntity(requestDTO);
        updated.setId(existing.getId());

        Material saved = materialRepository.save(updated);

        log.info(LogMessages.UPDATING_MATERIAL, saved.getId());
        return materialMapper.toDto(saved);
    }

    @Override
    public void deleteMaterial(Long id) {

        Material material = materialRepository.findById(id)
                .orElseThrow(() -> new MaterialNotFoundException(ExceptionMessages.MATERIAL_NOT_FOUND, id));

        materialRepository.delete(material);
        log.info(LogMessages.DELETING_MATERIAL, id);
    }

    private void validateDates(LocalDate purchaseDate, LocalDate saleDate) {
        if (purchaseDate != null && saleDate != null && purchaseDate.isAfter(saleDate)) {
            throw new InvalidMaterialDatesException(ExceptionMessages.INVALID_DATES);
        }
    }

    private void validateCity(String cityCode) {
        cityRepository.findByCode(cityCode)
                .orElseThrow(() -> new CityNotFoundException(ExceptionMessages.CITY_NOT_FOUND, cityCode));
    }

    private void validateUniqueMaterial(MaterialRequestDTO dto) {
        boolean exists = materialRepository.existsByNameAndTypeAndCity_Code(
                dto.getName(),
                dto.getType(),
                dto.getCityCode()
        );

        if (exists) {
            throw new DuplicateMaterialException(ExceptionMessages.DUPLICATE_MATERIAL, dto.getName(), dto.getType(), dto.getCityCode());
        }
    }
}
