package com.isaac.pethospital.employee.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Entity
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne()
    @JsonBackReference("CompanyEntity-DepartmentEntity")
    private CompanyEntity company;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
            @JsonManagedReference("parent-children")
    List<DepartmentEntity> children = new LinkedList<>();

    public List<DepartmentEntity> getChildren() {
        return children;
    }

    public void addChild(DepartmentEntity child) {
        if (child == null)
            throw new RuntimeException("Department is null");
        child.setParent(this);
        this.children.add(child);
    }

    public DepartmentEntity getParent() {
        return parent;
    }

    public void setParent(DepartmentEntity parent) {
        this.parent = parent;
    }

    @ManyToOne
    @JsonBackReference("parent-children")
    DepartmentEntity parent;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    @JsonManagedReference("DepartmentEntity-EmployeeEntity")
    private List<EmployeeEntity> employees = new LinkedList<>();



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }

    public List<EmployeeEntity> getEmployees() {
        return employees;
    }

    public EmployeeEntity addEmployee(EmployeeEntity employee) {
        if (employee == null)
            throw new RuntimeException("Employee is null.");
        employee.setDepartment(this);
        this.employees.add(employee);
        return employee;
    }

    public void removeEmployee(EmployeeEntity employee) {
        if (employee == null)
            throw new RuntimeException("Employee is null.");
        employee.setDepartment(null);
        this.employees.remove(employee);
    }

    public EmployeeEntity addEmployeeByName(String loginAccount,String name, String title, EmployeeEntity manager) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setFullName(name);
        employeeEntity.setLoginAccount(loginAccount);
        employeeEntity.setJobTitle(title);
        employeeEntity.setDirectReportTo(manager);
        employeeEntity.setUuid(UUID.randomUUID().toString());
        return this.addEmployee(employeeEntity);
    }
}
