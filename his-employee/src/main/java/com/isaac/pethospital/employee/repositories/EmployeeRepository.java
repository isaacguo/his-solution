package com.isaac.pethospital.employee.repositories;

import com.isaac.pethospital.employee.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}
