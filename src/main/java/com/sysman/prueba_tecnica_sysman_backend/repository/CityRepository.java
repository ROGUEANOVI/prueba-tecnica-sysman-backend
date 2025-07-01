package com.sysman.prueba_tecnica_sysman_backend.repository;

import com.sysman.prueba_tecnica_sysman_backend.constants.NumericConstants;
import com.sysman.prueba_tecnica_sysman_backend.entity.City;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface CityRepository extends JpaRepository<City, String> {

    Optional<Object> findByCode(@Size(max = NumericConstants.CODE_MAX_LENGTH) @NotBlank String code);

    List<City> findByDepartment_Code(String departmentCode);
}
