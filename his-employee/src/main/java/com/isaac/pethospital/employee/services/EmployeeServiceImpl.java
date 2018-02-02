package com.isaac.pethospital.employee.services;

import com.isaac.pethospital.employee.entities.EmployeeEntity;
import com.isaac.pethospital.employee.repositories.EmployeeRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private String getUserAccount() {
        return (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public long getTotalCounts() {
        return this.employeeRepository.count();
    }

    @Override
    public EmployeeEntity getEmployeeById(long id) {
        return this.employeeRepository.findOne(id);
    }

    @Override
    public EmployeeEntity createEmployee(EmployeeEntity employeeEntity) {
        String uuid = UUID.randomUUID().toString();
        employeeEntity.setUuid(uuid);
        return this.employeeRepository.save(employeeEntity);
    }

    @Override
    public EmployeeEntity getMyInfo() {
        String userAccount = this.getUserAccount();
        return this.employeeRepository.findByLoginAccount(userAccount);
    }
}
