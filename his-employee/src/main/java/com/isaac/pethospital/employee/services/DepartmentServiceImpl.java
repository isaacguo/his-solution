package com.isaac.pethospital.employee.services;

import com.isaac.pethospital.employee.dto.DepartmentIdAndName;
import com.isaac.pethospital.employee.dto.DepartmentIdAndNameAndChildren;
import com.isaac.pethospital.employee.dto.MyDepartmentIdAndNameAndChildren;
import com.isaac.pethospital.employee.entities.DepartmentEntity;
import com.isaac.pethospital.employee.repositories.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
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

    @Override
    public MyDepartmentIdAndNameAndChildren findRootDepartment() {

        DepartmentIdAndName root = this.departmentRepository.findRootDepartment();

        MyDepartmentIdAndNameAndChildren dc= toMyDepartmentIdAndNameAndChildren(root);
        return dc;

    }

    private MyDepartmentIdAndNameAndChildren toMyDepartmentIdAndNameAndChildren(DepartmentIdAndName departmentIdAndName) {
        MyDepartmentIdAndNameAndChildren m = new MyDepartmentIdAndNameAndChildren();
        m.setName(departmentIdAndName.getName());
        m.setId(departmentIdAndName.getId());

        this.departmentRepository.findChildDepartments(departmentIdAndName.getId()).forEach(r -> {
            m.addChildren(toMyDepartmentIdAndNameAndChildren(r));
        });
        return m;
    }



}


