package com.isaac.pethospital.employee.repositories;

import com.isaac.pethospital.employee.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Long> {
}
