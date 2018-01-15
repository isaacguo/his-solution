package com.isaac.pethospital.employee.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private UUID uuid;

    private String companyName;
    private String companyLocation;

    @OneToMany
    List<DepartmentEntity> departmentEntities;

}
