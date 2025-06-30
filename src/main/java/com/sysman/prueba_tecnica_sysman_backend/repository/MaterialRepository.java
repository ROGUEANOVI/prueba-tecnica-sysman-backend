package com.sysman.prueba_tecnica_sysman_backend.repository;

import com.sysman.prueba_tecnica_sysman_backend.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MaterialRepository extends JpaRepository<Material, Long> {

    boolean existsByNameAndTypeAndCity_Code(String name, String type, String cityCode);
}
