package com.isaac.pethospital.treatment.repositories;

import com.isaac.pethospital.treatment.entities.DepartmentEntity;
import com.isaac.pethospital.treatment.entities.EmployeeEntity;
import com.isaac.pethospital.treatment.entities.EmployeeTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    List<EmployeeEntity> findByName(String name);

    List<EmployeeEntity> findByDepartment(DepartmentEntity departmentEntity);

    List<EmployeeEntity> findByEmployeeType(EmployeeTypeEntity employeeTypeEntity);

    EmployeeEntity findByLoginAccount(String loginAccount);

    EmployeeEntity findByEmpId(Long empId);


}
