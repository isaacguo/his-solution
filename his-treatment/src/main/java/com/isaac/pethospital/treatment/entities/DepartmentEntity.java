package com.isaac.pethospital.treatment.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Entity
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private UUID uuid;

    private String name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    @JsonManagedReference("DepartmentEntity-TreatmentCaseEntity")
    List<TreatmentCaseEntity> treatmentCaseList = new LinkedList<>();

    @OneToMany
    @JsonManagedReference("DepartmentEntity-DoctorEntity")
    List<DoctorEntity> doctorList = new LinkedList<>();
}
