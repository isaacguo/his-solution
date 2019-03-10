package com.isaac.pethospital.treatment.dtos;

import com.isaac.pethospital.treatment.entities.DepartmentEntity;
import com.isaac.pethospital.treatment.entities.EmployeeEntity;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class EmployeeOperationRequest {

    private Long departmentId;
    private Long id;
    private String uuid;
    private String selfIntroduction;
    private boolean canBeRegistered;
    private Long employeeTypeId;
    private Long empId;
    private String loginAccount;
    private String name;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public boolean isCanBeRegistered() {
        return canBeRegistered;
    }

    public void setCanBeRegistered(boolean canBeRegistered) {
        this.canBeRegistered = canBeRegistered;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
        employeeEntity.setEmpId(empId);
        employeeEntity.setLoginAccount(loginAccount);
        employeeEntity.setName(name);
        employeeEntity.setUuid(UUID.randomUUID().toString());
        employeeEntity.setSelfIntroduction(selfIntroduction);
        return employeeEntity;





    }
}
