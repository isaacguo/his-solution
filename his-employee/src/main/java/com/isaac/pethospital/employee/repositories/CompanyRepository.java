package com.isaac.pethospital.employee.repositories;

import com.isaac.pethospital.employee.entities.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Long> {
}
