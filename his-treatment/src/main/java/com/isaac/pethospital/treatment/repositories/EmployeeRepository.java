package com.isaac.pethospital.treatment.repositories;

import com.isaac.pethospital.treatment.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {

}
