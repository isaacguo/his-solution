package com.isaac.pethospital.treatment.services;

import com.isaac.pethospital.treatment.dtos.EmployeeTypeOperationRequest;
import com.isaac.pethospital.treatment.entities.EmployeeTypeEntity;
import com.isaac.pethospital.treatment.repositories.EmployeeTypeRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class EmployeeTypeServiceImpl implements EmployeeTypeService {

    EmployeeTypeRepository employeeTypeRepository;

    public EmployeeTypeServiceImpl(EmployeeTypeRepository employeeTypeRepository) {
        this.employeeTypeRepository = employeeTypeRepository;
    }

    @Override
    public EmployeeTypeEntity createEmployeeType(EmployeeTypeOperationRequest employeeTypeOperationRequest) {
        if (this.employeeTypeRepository.findByName(employeeTypeOperationRequest.getName()) == null)
            return this.employeeTypeRepository.save(employeeTypeOperationRequest.toEmployeeType());
        else
            throw new RuntimeException("The EmployeeType with name:" + employeeTypeOperationRequest.getName() + " has already existed");
    }

    @Override
    public void deleteEmployeeType(EmployeeTypeOperationRequest employeeTypeOperationRequest) {
        if (this.employeeTypeRepository.exists(employeeTypeOperationRequest.getId()))
            this.employeeTypeRepository.delete(employeeTypeOperationRequest.getId());
    }

    @Override
    public EmployeeTypeEntity updateEmployeeType(EmployeeTypeOperationRequest employeeTypeOperationRequest) {
        if (!this.employeeTypeRepository.exists(employeeTypeOperationRequest.getId()))
            throw new RuntimeException("EmployeeType doesn't exist");

        EmployeeTypeEntity employeeTypeEntity = this.employeeTypeRepository.findOne(employeeTypeOperationRequest.getId());
        employeeTypeEntity.setName(employeeTypeOperationRequest.getName());
        return this.employeeTypeRepository.save(employeeTypeEntity);


    }

    @Override
    public EmployeeTypeEntity findByName(EmployeeTypeOperationRequest employeeTypeOperationRequest) {

        EmployeeTypeEntity employeeTypeEntity = this.employeeTypeRepository.findByName(employeeTypeOperationRequest.getName());

        if (employeeTypeEntity == null)
            throw new RuntimeException("The EmployeeType with name:" + employeeTypeOperationRequest.getName() + " doesn't existed");
        else
            return employeeTypeEntity;
    }
}
