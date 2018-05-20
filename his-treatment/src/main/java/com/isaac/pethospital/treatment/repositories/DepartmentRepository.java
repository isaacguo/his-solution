package com.isaac.pethospital.treatment.repositories;

import com.isaac.pethospital.treatment.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
    DepartmentEntity findByDepId(Long depId);

   List<DepartmentEntity> findByOpenToFrontDeskIsTrue();

}
