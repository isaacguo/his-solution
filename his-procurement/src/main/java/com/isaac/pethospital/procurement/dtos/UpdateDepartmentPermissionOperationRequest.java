package com.isaac.pethospital.procurement.dtos;

import com.isaac.pethospital.procurement.entities.DepartmentPermissionEntity;

import java.util.LinkedList;
import java.util.List;

public class UpdateDepartmentPermissionOperationRequest {

    Long id;
    List<DepartmentPermissionEntity> departments = new LinkedList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<DepartmentPermissionEntity> getDepartments() {
        return departments;
    }

    public void setDepartments(List<DepartmentPermissionEntity> departments) {
        this.departments = departments;
    }
}
