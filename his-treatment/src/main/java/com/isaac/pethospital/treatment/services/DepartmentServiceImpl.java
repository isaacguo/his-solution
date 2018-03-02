package com.isaac.pethospital.treatment.services;

import com.isaac.pethospital.treatment.entities.DepartmentEntity;
import com.isaac.pethospital.treatment.repositories.DepartmentRepository;
import com.isaac.pethospital.treatment.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<DepartmentEntity> getDepartments() {
        return this.departmentRepository.findAll();
    }


    @Override
    public DepartmentEntity createDepartment(DepartmentEntity departmentEntity) {
        String uuid = UUID.randomUUID().toString();
        departmentEntity.setUuid(uuid);
        return this.departmentRepository.save(departmentEntity);
    }


}
