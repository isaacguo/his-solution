package com.isaac.pethospital.employee.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class DepartmentEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @ManyToOne()
    @JsonBackReference("CompanyEntity-DepartmentEntity")
    private CompanyEntity company;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    List<DepartmentEntity> children=new LinkedList<>();

    public List<DepartmentEntity> getChildren() {
        return children;
    }

    public void addChild(DepartmentEntity child) {
        if(child==null)
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
    DepartmentEntity parent;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    @JsonManagedReference("DepartmentEntity-EmployeeEntity")
    private List<EmployeeEntity> employees = new LinkedList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public void setEmployees(List<EmployeeEntity> employees) {
        this.employees = employees;
    }
}
