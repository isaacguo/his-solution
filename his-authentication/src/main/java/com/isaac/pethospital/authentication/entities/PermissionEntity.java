package com.isaac.pethospital.authentication.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class PermissionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany
    @JsonBackReference("Role-Permission")
    List<RoleEntity> roles;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<RoleEntity> getRoles() {
        return roles;
    }

    public void addRole(RoleEntity role)
    {
        if(role==null) throw new RuntimeException("Role is null");
        role.setPermissions(this);
        this.roles.add(role);

    }
    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }
}
