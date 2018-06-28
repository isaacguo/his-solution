package com.isaac.pethospital.employee.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.isaac.pethospital.common.converter.HanyuPinyinConverter;
import org.apache.commons.lang.StringUtils;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Entity
public class DepartmentEntity {

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    @JsonManagedReference("parent-children")
    List<DepartmentEntity> children = new LinkedList<>();
    @ManyToOne
    @JsonBackReference("parent-children")
    DepartmentEntity parent;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne()
    @JsonBackReference("CompanyEntity-DepartmentEntity")
    private CompanyEntity company;
    @OneToMany(mappedBy = "department", cascade = CascadeType.PERSIST)
    @JsonManagedReference("DepartmentEntity-EmployeeEntity")
    private List<EmployeeEntity> employees = new LinkedList<>();
    @OneToOne(mappedBy = "departmentInCharge")
    @JsonManagedReference("DepartmentEntity-EmployeeEntity-Manager")
    private EmployeeEntity manager;

    public List<DepartmentEntity> getChildren() {
        return children;
    }

    public void addChildByName(String name) {
        if (StringUtils.isEmpty(name))
            throw new RuntimeException("Department name is null");
        DepartmentEntity de=new DepartmentEntity();
        de.setName(name);
        this.addChild(de);
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

    public EmployeeEntity getManager() {
        return manager;
    }

    public void setManager(EmployeeEntity manager) {
        if(manager==null)
            throw new RuntimeException("Manager is null");
        manager.setDepartmentInCharge(this);
        this.manager = manager;
    }
    public void removeManager(EmployeeEntity manager)
    {
        if(manager==null)
            throw new RuntimeException("Manager is null");
        manager.setDepartmentInCharge(null);
        this.manager =null;
    }

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

    public EmployeeEntity addEmployeeByName(HanyuPinyinConverter converter, String loginAccount, String password, String name, String title, EmployeeEntity manager) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setFullName(name);
        employeeEntity.setPassword(password);
        employeeEntity.setLoginAccount(loginAccount);
        employeeEntity.setJobTitle(title);
        employeeEntity.setDirectReportTo(manager);
        employeeEntity.setUuid(UUID.randomUUID().toString());
        employeeEntity.setFullNameHanYuPinYin(converter.toHanyuPinyin(name));
        return this.addEmployee(employeeEntity);
    }

}
