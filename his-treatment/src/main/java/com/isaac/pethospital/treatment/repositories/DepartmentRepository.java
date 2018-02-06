package com.isaac.pethospital.treatment.repositories;

import com.isaac.pethospital.treatment.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
}
