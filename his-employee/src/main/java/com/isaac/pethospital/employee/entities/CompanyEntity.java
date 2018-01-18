package com.isaac.pethospital.employee.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedList;
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

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    @JsonManagedReference("CompanyEntity-DepartmentEntity")
    List<DepartmentEntity> departmentEntities = new LinkedList<>();


    public void addDepartment(DepartmentEntity departmentEntity) {
        if (departmentEntity != null) {
            departmentEntity.setCompany(this);
        }
        this.departmentEntities.add(departmentEntity);
    }
}
