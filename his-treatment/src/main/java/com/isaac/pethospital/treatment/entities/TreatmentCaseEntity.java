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

}
