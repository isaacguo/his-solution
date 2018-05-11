package com.isaac.pethospital.treatment.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.isaac.pethospital.treatment.common.enums.TreatmentCaseStatusEnum;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class TreatmentCaseEntity {

    boolean createResult;
    LocalDateTime treatmentDate;
    LocalDateTime createdDate;
    @ManyToOne
    @JsonBackReference("DepartmentEntity-TreatmentCaseEntity")
    DepartmentEntity department;
    @ManyToOne
    @JsonBackReference("EmployeeEntity-TreatmentCaseEntity")
    EmployeeEntity doctor;
    @ManyToOne
    @JsonBackReference("PetOwnerEntity-TreatmentCaseEntity")
    PetOwnerEntity petOwner;
    @ManyToOne
    @JsonBackReference("PetEntity-TreatmentCaseEntity")
    PetEntity pet;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uuid;
    @Enumerated(EnumType.STRING)
    private TreatmentCaseStatusEnum treatmentCaseStatus;

    public boolean isCreateResult() {
        return createResult;
    }

    public void setCreateResult(boolean createResult) {
        this.createResult = createResult;
    }

    public PetOwnerEntity getPetOwner() {
        return petOwner;
    }

    public void setPetOwner(PetOwnerEntity petOwner) {
        this.petOwner = petOwner;
    }

    public PetEntity getPet() {
        return pet;
    }

    public void setPet(PetEntity pet) {
        this.pet = pet;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public TreatmentCaseStatusEnum getTreatmentCaseStatus() {
        return treatmentCaseStatus;
    }

    public void setTreatmentCaseStatus(TreatmentCaseStatusEnum treatmentCaseStatus) {
        this.treatmentCaseStatus = treatmentCaseStatus;
    }

    public LocalDateTime getTreatmentDate() {
        return treatmentDate;
    }

    public void setTreatmentDate(LocalDateTime treatmentDate) {
        this.treatmentDate = treatmentDate;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public DepartmentEntity getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentEntity department) {
        this.department = department;
    }

    public EmployeeEntity getDoctor() {
        return doctor;
    }

    public void setDoctor(EmployeeEntity doctor) {
        this.doctor = doctor;
    }
}
