package com.sysman.prueba_tecnica_sysman_backend.repository;

import com.sysman.prueba_tecnica_sysman_backend.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, String> {

}
