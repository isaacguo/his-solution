package com.isaac.pethospital.treatment.services;

import com.isaac.pethospital.treatment.entities.DepartmentEntity;
import com.isaac.pethospital.treatment.entities.EmployeeEntity;
import com.isaac.pethospital.treatment.entities.TreatmentCaseEntity;

import java.util.List;

public interface DepartmentSerivce {
    List<DepartmentEntity> getDepartments();
    List<EmployeeEntity> getDoctorsInDepartmentByUuid(String uuid);
    DepartmentEntity createDepartment(DepartmentEntity departmentEntity);
    TreatmentCaseEntity createTreatmentCase(TreatmentCaseEntity treatmentCase);

}
