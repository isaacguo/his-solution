package com.isaac.pethospital.employee.services;

import com.isaac.pethospital.employee.entities.EmployeeEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
     long getTotalCounts();

    EmployeeEntity getEmployeeById(long id);
    EmployeeEntity createEmployee(EmployeeEntity employeeEntity);

    EmployeeEntity getMyInfo();

    EmployeeEntity getEmployeeByUuid(String uuid);
    List<String> getOrganizationNames();
    List<String> getSupportedRelationships();
}
