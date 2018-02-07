package com.isaac.pethospital.treatment.services;

import com.isaac.pethospital.treatment.entities.DepartmentEntity;
import com.isaac.pethospital.treatment.entities.DoctorEntity;
import com.isaac.pethospital.treatment.entities.TreatmentCaseEntity;

import java.util.List;

public interface DepartmentSerivce {
    List<DepartmentEntity> getDepartments();
    List<DoctorEntity> getDoctorsInDepartmentByUuid(String uuid);
    DepartmentEntity createDepartment(DepartmentEntity departmentEntity);
    TreatmentCaseEntity createTreatmentCase(TreatmentCaseEntity treatmentCase);

}
