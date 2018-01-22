package com.isaac.pethospital.employee.services;

import com.isaac.pethospital.employee.repositories.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public long getTotalCounts() {
        return this.employeeRepository.count();
    }
}
