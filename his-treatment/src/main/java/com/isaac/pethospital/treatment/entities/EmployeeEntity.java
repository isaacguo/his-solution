package com.isaac.pethospital.treatment.entities;

import javax.persistence.*;

@Entity
public class EmployeeEntity {
    
    @ManyToOne
    //@JsonBackReference("DepartmentEntity-EmployeeEntity")
    DepartmentEntity department;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long empId;
    private String selfIntroduction;

    private boolean canBeRegistered;
    @ManyToOne
    private EmployeeTypeEntity employeeType;
    private String name;
    private String loginAccount;

    private String uuid;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public boolean isCanBeRegistered() {
        return canBeRegistered;
    }

    public void setCanBeRegistered(boolean canBeRegistered) {
        this.canBeRegistered = canBeRegistered;
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    public EmployeeTypeEntity getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeTypeEntity employeeType) {
        this.employeeType = employeeType;
    }

    public String getSelfIntroduction() {
        return selfIntroduction;
    }

    public void setSelfIntroduction(String selfIntroduction) {
        this.selfIntroduction = selfIntroduction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DepartmentEntity getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentEntity department) {
        this.department = department;
    }
}
