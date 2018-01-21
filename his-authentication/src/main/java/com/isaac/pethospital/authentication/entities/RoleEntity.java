package com.isaac.pethospital.authentication.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    String role;

    @ManyToMany(mappedBy = "roles")
    @JsonManagedReference("Role-Permission")
    List<PermissionEntity> permissions;

    @ManyToMany(mappedBy = "roles")
    @JsonBackReference("User-Role")
    List<UserEntity> users;

}
