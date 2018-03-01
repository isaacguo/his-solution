package com.isaac.pethospital.treatment.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Entity
public class EmployeeEntity {

    /*
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    @JsonManagedReference("EmployeeEntity-RegistrationEntity")
    List<RegistrationEntity> registrationList = new LinkedList<>();
    */

    @ManyToOne
    @JsonBackReference("DepartmentEntity-EmployeeEntity")
    DepartmentEntity department;
    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
    @JsonManagedReference("EmployeeEntity-TreatmentCaseEntity")
    List<TreatmentCaseEntity> treatmentCaseEntityList = new LinkedList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private UUID uuid;
    private String selfIntroduction;
    private int rating;
    private String jobTitle;
    private String name;

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getSelfIntroduction() {
        return selfIntroduction;
    }

    public void setSelfIntroduction(String selfIntroduction) {
        this.selfIntroduction = selfIntroduction;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DepartmentEntity getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentEntity department) {
        this.department = department;
    }

    public List<TreatmentCaseEntity> getTreatmentCaseEntityList() {
        return treatmentCaseEntityList;
    }

    public void addTreatmentCase(TreatmentCaseEntity treatmentCase) {
        if (treatmentCase == null)
            throw new RuntimeException("treatment case is null");
        treatmentCase.setDoctor(this);
        this.treatmentCaseEntityList.add(treatmentCase);
    }
}
