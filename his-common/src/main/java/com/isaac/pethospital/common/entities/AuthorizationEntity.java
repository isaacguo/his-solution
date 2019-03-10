package com.isaac.pethospital.common.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class AuthorizationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    Long uid;
    String username;
    String userAccount;

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    @OneToMany(mappedBy = "authorization", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("AuthorizationEntity-AuthorizationAssignmentEntity")
    List<AuthorizationAssignmentEntity> authorizationAssignmentList = new LinkedList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<AuthorizationAssignmentEntity> getAuthorizationAssignmentList() {
        return authorizationAssignmentList;
    }

    public void addAuthorizationAssignment(AuthorizationAssignmentEntity authorizationAssignment) {
        if (authorizationAssignment == null)
            throw new RuntimeException("Authorization AssignmentEntity is null.");
        authorizationAssignment.setAuthorization(this);
        this.authorizationAssignmentList.add(authorizationAssignment);
    }

    public void removeAuthorizationAssignment(AuthorizationAssignmentEntity authorizationAssignment) {
        if (authorizationAssignment == null)
            throw new RuntimeException("Authorization AssignmentEntity is null.");
        authorizationAssignment.setAuthorization(null);
        this.authorizationAssignmentList.remove(authorizationAssignment);
    }
}
