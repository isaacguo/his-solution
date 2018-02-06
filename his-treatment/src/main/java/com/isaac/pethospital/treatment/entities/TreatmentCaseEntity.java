package com.isaac.pethospital.treatment.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.isaac.pethospital.treatment.common.enums.TreatmentCaseStatusEnum;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class TreatmentCaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private UUID uuid;

    @Enumerated(EnumType.STRING)
    private TreatmentCaseStatusEnum treatmentCaseStatus;

    LocalDateTime treatmentDate;
    LocalDateTime createdDate;

    @ManyToOne
    @JsonBackReference("DepartmentEntity-TreatmentCaseEntity")
    DepartmentEntity department;

    @ManyToOne
    @JsonBackReference("DoctorEntity-TreatmentCaseEntity")
    DoctorEntity doctor;

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

    public DoctorEntity getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorEntity doctor) {
        this.doctor = doctor;
    }
}
