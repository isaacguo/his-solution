package com.isaac.pethospital.authentication.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
public class UserEntity {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany()
    @JsonManagedReference("User-Role")
    Set<RoleEntity> roles=new LinkedHashSet<>();

    public void addRole(RoleEntity role)
    {
        if(role==null) throw new RuntimeException("Role is null");
        role.addUser(this);
        this.roles.add(role);
    }

    private String userName;
    private String userId;

}
