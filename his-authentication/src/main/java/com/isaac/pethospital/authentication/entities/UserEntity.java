package com.isaac.pethospital.authentication.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToMany()
    @JsonManagedReference("User-Role")
    List<RoleEntity> roles;

    private String userName;
    private String userId;

}
