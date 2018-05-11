package com.isaac.pethospital.common.dtos;

import com.isaac.pethospital.common.entities.AuthorizationAssignmentEntity;

import java.util.LinkedList;
import java.util.List;

public class AuthorizationDomainAssignmentResponse {


    String name;
    List<AuthorizationAssignmentEntity> assignments = new LinkedList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AuthorizationAssignmentEntity> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<AuthorizationAssignmentEntity> assignments) {
        this.assignments = assignments;
    }
}
