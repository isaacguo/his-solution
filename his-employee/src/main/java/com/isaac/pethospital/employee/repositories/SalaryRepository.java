package com.isaac.pethospital.employee.repositories;

import com.isaac.pethospital.employee.entities.SalaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepository extends JpaRepository<SalaryEntity, Long> {
}
