package com.isaac.pethospital.employee.services;

import com.isaac.pethospital.employee.entities.EmployeeEntity;
import org.springframework.stereotype.Service;

public interface EmployeeService {
     long getTotalCounts();

    EmployeeEntity getEmployeeById(long id);
    EmployeeEntity createEmployee(EmployeeEntity employeeEntity);

    EmployeeEntity getMyInfo();
}
