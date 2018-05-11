package com.isaac.pethospital.employee.repositories;

import com.isaac.pethospital.employee.dto.DepartmentIdAndName;
import com.isaac.pethospital.employee.dto.DepartmentIdAndNameAndChildren;
import com.isaac.pethospital.employee.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Long> {
    @Query("select distinct p.name from DepartmentEntity p")
    List<String> findDistinctDepartmentNames();

    @Query("select p.id as id, p.name as name from DepartmentEntity p")
    List<DepartmentIdAndName> findAllProjectedForDepartmentIdAndName();


    @Query("select p.id as id, p.name as name from DepartmentEntity p join p.parent parent where parent.id=:id ")
    List<DepartmentIdAndName> findChildDepartments(@Param("id") Long id);

    @Query("select p.id as id, p.name as name from DepartmentEntity p where p.parent is null ")
    DepartmentIdAndName findRootDepartment();

    DepartmentEntity findByName(String name);
}
