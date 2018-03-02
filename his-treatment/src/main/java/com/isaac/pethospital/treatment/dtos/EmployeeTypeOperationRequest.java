package com.isaac.pethospital.treatment.dtos;

import com.isaac.pethospital.treatment.entities.EmployeeTypeEntity;

import javax.validation.constraints.NotNull;

public class EmployeeTypeOperationRequest {

    @NotNull
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmployeeTypeEntity toEmployeeType() {
        EmployeeTypeEntity employeeTypeEntity = new EmployeeTypeEntity();
        employeeTypeEntity.setName(this.name);
        return employeeTypeEntity;
    }
}
