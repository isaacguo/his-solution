package com.isaac.pethospital.treatment.services;

import com.isaac.pethospital.treatment.dtos.EmployeeTypeOperationRequest;
import com.isaac.pethospital.treatment.entities.DepartmentEntity;
import com.isaac.pethospital.treatment.entities.EmployeeEntity;
import com.isaac.pethospital.treatment.entities.EmployeeTypeEntity;

import java.util.List;

public interface EmployeeTypeService {

    EmployeeTypeEntity createEmployeeType(EmployeeTypeOperationRequest employeeTypeOperationRequest);

    void deleteEmployeeType(EmployeeTypeOperationRequest employeeTypeOperationRequest);

    EmployeeTypeEntity updateEmployeeType(EmployeeTypeOperationRequest employeeTypeOperationRequest);

    EmployeeTypeEntity findByName(EmployeeTypeOperationRequest employeeTypeOperationRequest);

}
