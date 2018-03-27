package com.isaac.pethospital.treatment.dtos;

import com.isaac.pethospital.treatment.entities.DepartmentEntity;
import com.isaac.pethospital.treatment.entities.EmployeeEntity;

import javax.validation.constraints.NotNull;

public class EmployeeOperationRequest {

    private Long departmentId;
    private long id;
    private String selfIntroduction;
    private Long employeeTypeId;
    private String name;

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSelfIntroduction() {
        return selfIntroduction;
    }

    public void setSelfIntroduction(String selfIntroduction) {
        this.selfIntroduction = selfIntroduction;
    }

    public Long getEmployeeTypeId() {
        return employeeTypeId;
    }

    public void setEmployeeTypeId(Long employeeTypeId) {
        this.employeeTypeId = employeeTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmployeeEntity toEmployee() {

        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setName(name);
        employeeEntity.setSelfIntroduction(selfIntroduction);
        return employeeEntity;
    }
}
