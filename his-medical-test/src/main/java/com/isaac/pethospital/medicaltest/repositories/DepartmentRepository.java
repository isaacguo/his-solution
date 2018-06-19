package com.isaac.pethospital.medicaltest.repositories;


import com.isaac.pethospital.medicaltest.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
    DepartmentEntity findByDepId(Long depId);
}
