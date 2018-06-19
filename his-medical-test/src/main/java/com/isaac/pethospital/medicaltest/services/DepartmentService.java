package com.isaac.pethospital.medicaltest.services;

import com.isaac.pethospital.medicaltest.entities.DepartmentEntity;

public interface DepartmentService {
    boolean setDepartmentEnable(DepartmentEntity department);

    DepartmentEntity getDepartmentByDepId(Long depId);
}
