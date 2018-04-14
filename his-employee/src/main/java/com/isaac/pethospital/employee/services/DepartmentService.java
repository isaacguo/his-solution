package com.isaac.pethospital.employee.services;

import com.isaac.pethospital.employee.dto.DepartmentIdAndName;
import com.isaac.pethospital.employee.entities.DepartmentEntity;

import java.util.List;

public interface DepartmentService {
    List<DepartmentEntity> findAll();

    List<DepartmentIdAndName> findIndexAndNameOnly();

}
