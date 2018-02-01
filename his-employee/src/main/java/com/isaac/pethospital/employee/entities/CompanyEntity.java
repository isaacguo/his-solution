package com.isaac.pethospital.employee.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Entity
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyLocation() {
        return companyLocation;
    }

    public void setCompanyLocation(String companyLocation) {
        this.companyLocation = companyLocation;
    }

    public List<DepartmentEntity> getDepartmentEntities() {
        return departmentEntities;
    }

    public void setDepartmentEntities(List<DepartmentEntity> departmentEntities) {
        this.departmentEntities = departmentEntities;
    }
}
