package com.isaac.pethospital.employee.services;

import com.isaac.pethospital.employee.dto.*;
import com.isaac.pethospital.employee.entities.DepartmentEntity;
import com.isaac.pethospital.employee.repositories.DepartmentRepository;

import java.util.List;

public interface DepartmentService {

    DepartmentRepository getDepartmentRepository();

    List<DepartmentEntity> findAll();

    DepartmentEntity findById(Long id);

    List<DepartmentIdAndName> findIndexAndNameOnly();

    MyDepartmentIdAndNameAndChildren findRootDepartment();

    boolean createDepartment(DepartmentOperationRequest request);

    boolean deleteDepartment(Long id);

    boolean renameDepartment(DepartmentOperationRequest request);

    EmployeeListItem findManager(Long departmentId);
}
