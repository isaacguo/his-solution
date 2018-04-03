package com.isaac.pethospital.employee.repositories;

import com.isaac.pethospital.employee.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Long> {
    @Query("select distinct p.name from DepartmentEntity p")
    List<String> findDistinctDepartmentNames();
}
