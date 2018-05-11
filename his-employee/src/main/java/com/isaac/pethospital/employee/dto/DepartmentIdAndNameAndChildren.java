package com.isaac.pethospital.employee.dto;

import java.util.List;

public interface DepartmentIdAndNameAndChildren {

    Long getId();
    String getName();
    List<DepartmentIdAndNameAndChildren> getChildren();
}

