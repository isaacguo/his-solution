package com.isaac.pethospital.employee.services;

import com.isaac.pethospital.employee.dto.DepartmentIdAndName;
import com.isaac.pethospital.employee.entities.DepartmentEntity;
import com.isaac.pethospital.employee.repositories.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<DepartmentEntity> findAll() {
        return this.departmentRepository.findAll();
    }

    @Override
    public List<DepartmentIdAndName> findIndexAndNameOnly() {
        return this.departmentRepository.findAllProjectedForDepartmentIdAndName();
    }
}
