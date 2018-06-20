package com.isaac.pethospital.medicaltest.services;

import com.isaac.pethospital.medicaltest.dtos.DepartmentOperationRequest;
import com.isaac.pethospital.medicaltest.dtos.DepartmentReportTemplateOperationRequest;
import com.isaac.pethospital.medicaltest.entities.DepartmentEntity;

public interface DepartmentService {
    boolean setDepartmentEnable(DepartmentOperationRequest request);

    DepartmentEntity getDepartmentByDepId(Long depId);

    boolean operateSupportedTestReportTemplate(DepartmentReportTemplateOperationRequest request, boolean addOperation);
}
