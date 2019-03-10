package com.isaac.pethospital.employee.dto;

import java.util.LinkedList;
import java.util.List;

public class MyDepartmentIdAndNameAndChildren implements DepartmentIdAndNameAndChildren {

    Long id;
    String name;
    List<DepartmentIdAndNameAndChildren> children = new LinkedList<>();

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addChildren(DepartmentIdAndNameAndChildren children) {
        this.children.add(children);
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<DepartmentIdAndNameAndChildren> getChildren() {
        return children;
    }
}
