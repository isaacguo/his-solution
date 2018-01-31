package com.isaac.pethospital.authentication.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Entity
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    String role;

    @ManyToMany(mappedBy = "roles")
    @JsonManagedReference("Role-Permission")
    Set<PermissionEntity> permissions=new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPermissions(PermissionEntity permission)
    {
        this.permissions.add(permission);
    }
    public Set<PermissionEntity> getPermissions() {
        return permissions;
    }

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }

    @ManyToMany(mappedBy = "roles")
    @JsonBackReference("User-Role")
    List<UserEntity> users;

}
