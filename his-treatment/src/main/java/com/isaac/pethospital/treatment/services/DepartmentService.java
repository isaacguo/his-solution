package com.isaac.pethospital.treatment.services;

import com.isaac.pethospital.treatment.entities.DepartmentEntity;

import java.util.List;

public interface DepartmentService {
    List<DepartmentEntity> getDepartments();
    DepartmentEntity createDepartment(DepartmentEntity departmentEntity);

}
