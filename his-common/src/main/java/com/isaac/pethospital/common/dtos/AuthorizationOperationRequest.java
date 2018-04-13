package com.isaac.pethospital.common.dtos;

import com.isaac.pethospital.common.entities.AuthorizationEntity;

import java.util.LinkedList;
import java.util.List;

public class AuthorizationOperationRequest {

    Long id;
    Long uid;
    String username;
    List<AuthorizationAssignmentOperationRequest> authorizationAssignmentList =new LinkedList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<AuthorizationAssignmentOperationRequest> getAuthorizationAssignmentList() {
        return authorizationAssignmentList;
    }

    public void setAuthorizationAssignmentList(List<AuthorizationAssignmentOperationRequest> authorizationAssignmentList) {
        this.authorizationAssignmentList = authorizationAssignmentList;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public AuthorizationEntity toAuthorizationEntity()
    {
        AuthorizationEntity authorizationEntity=new AuthorizationEntity();
        authorizationEntity.setUsername(this.username);
        authorizationEntity.setUid(this.uid);
        return authorizationEntity;
    }
}
