package com.sysman.prueba_tecnica_sysman_backend.repository;

import com.sysman.prueba_tecnica_sysman_backend.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MaterialRepository extends JpaRepository<Material, Long> {

    List<Material> findByTypeIgnoreCase(String type);

    List<Material> findByPurchaseDate(LocalDate date);

    List<Material> findByCity_CodeIgnoreCase(String cityCode);

    List<Material> findByTypeIgnoreCaseAndPurchaseDate(String type, LocalDate purchaseDate);
}
