package com.isaac.pethospital.treatment.services;

import com.isaac.pethospital.treatment.dtos.DepartmentOperationRequest;
import com.isaac.pethospital.treatment.entities.DepartmentEntity;
import com.isaac.pethospital.treatment.entities.EmployeeEntity;

import java.util.List;

public interface DepartmentService {
    List<DepartmentEntity> getOpenToFrontDeskDepartments();
    DepartmentEntity createDepartment(DepartmentEntity departmentEntity);

    DepartmentEntity getDepartmentByDepId(Long depId);

    boolean setDepartmentOpenToFrontDeskValue(DepartmentOperationRequest department);

    List<EmployeeEntity> getEmployeesByDepartmentId(Long depId);
}
