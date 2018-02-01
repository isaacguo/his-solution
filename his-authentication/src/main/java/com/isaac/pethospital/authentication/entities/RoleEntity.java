package com.isaac.pethospital.authentication.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
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


    public void addPermission(PermissionEntity permission)
    {
        if(permission==users) throw new RuntimeException("permission is null");
        permission.addRole(this);
        this.permissions.add(permission);
    }

    public Set<PermissionEntity> getPermissions() {
        return permissions;
    }

    public Set<UserEntity> getUsers() {
        return users;
    }


    public void addUser(UserEntity user)
    {
        this.users.add(user);

    }

    @ManyToMany(mappedBy = "roles")
    @JsonBackReference("User-Role")
    Set<UserEntity> users=new LinkedHashSet<>();

}
