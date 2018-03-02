package com.isaac.pethospital.treatment.repositories;

import com.isaac.pethospital.treatment.entities.EmployeeTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeTypeRepository extends JpaRepository<EmployeeTypeEntity,Long> {
    EmployeeTypeEntity findByName(String name);

}
