package com.isaac.pethospital.authentication.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Entity
public class PermissionEntity {

    @ManyToMany
    @JsonBackReference("Role-Permission")
    Set<RoleEntity> roles=new LinkedHashSet<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public void addRole(RoleEntity role)
    {
        if(role==null) throw new RuntimeException("Role is null");
        this.roles.add(role);
    }

}
