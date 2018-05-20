package com.isaac.pethospital.treatment.services;

import com.isaac.pethospital.treatment.dtos.EmployeeOperationRequest;
import com.isaac.pethospital.treatment.entities.DepartmentEntity;
import com.isaac.pethospital.treatment.entities.EmployeeEntity;

import java.util.List;

public interface EmployeeService {

    EmployeeEntity createEmployee(EmployeeOperationRequest employeeOperationRequest);

    void deleteEmployee(EmployeeOperationRequest employeeOperationRequest);

    EmployeeEntity updateEmployee(EmployeeOperationRequest employeeOperationRequest);

    List<EmployeeEntity> findByName(EmployeeOperationRequest employeeOperationRequest);

    List<EmployeeEntity> findByDepartment(EmployeeOperationRequest employeeOperationRequest);

    List<EmployeeEntity> findByEmployeeType(EmployeeOperationRequest employeeOperationRequest);

    EmployeeEntity findByLoginAccount(String loginAccount);

    boolean setCanBeRegisteredValue(EmployeeOperationRequest request);

    EmployeeEntity findByEmpId(Long empId);

    List<EmployeeEntity> findByDepartmentAndCanBeRegisteredIsTrue(EmployeeOperationRequest employeeOperationRequest);
}
