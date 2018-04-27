package com.isaac.pethospital.employee.services;

import com.isaac.pethospital.employee.dto.DepartmentIdAndName;
import com.isaac.pethospital.employee.dto.DepartmentIdAndNameAndChildren;
import com.isaac.pethospital.employee.dto.DepartmentOperationRequest;
import com.isaac.pethospital.employee.dto.MyDepartmentIdAndNameAndChildren;
import com.isaac.pethospital.employee.entities.DepartmentEntity;

import java.util.List;

public interface DepartmentService {
    List<DepartmentEntity> findAll();

    List<DepartmentIdAndName> findIndexAndNameOnly();
    MyDepartmentIdAndNameAndChildren findRootDepartment();

    boolean createDepartment(DepartmentOperationRequest request);

    boolean deleteDepartment(Long id);

    boolean renameDepartment(DepartmentOperationRequest request);
}
