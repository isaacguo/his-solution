package com.isaac.pethospital.treatment.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class DepartmentEntity {

    /*
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    @JsonManagedReference("DepartmentEntity-TreatmentCaseEntity")
    List<TreatmentCaseEntity> treatmentCaseList = new LinkedList<>();
    */
    /*
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    @JsonManagedReference("DepartmentEntity-EmployeeEntity")
    List<EmployeeEntity> doctorList = new LinkedList<>();
    */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uuid;
    private String name;
    private String description;
    private boolean exposeToPublic;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isExposeToPublic() {
        return exposeToPublic;
    }

    public void setExposeToPublic(boolean exposeToPublic) {
        this.exposeToPublic = exposeToPublic;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*
    public List<TreatmentCaseEntity> getTreatmentCaseList() {
        return treatmentCaseList;
    }

    public void addTreatmentCase(TreatmentCaseEntity treatmentCase) {
        if (treatmentCase == null)
            throw new RuntimeException("treatment case is null");
        treatmentCase.setDepartment(this);
        this.treatmentCaseList.add(treatmentCase);
    }

    public List<EmployeeEntity> getDoctorList() {
        return doctorList;
    }

    public void addDoctor(EmployeeEntity doctor) {
        if (doctor == null)
            throw new RuntimeException("doctor is null");

        doctor.setDepartment(this);
        this.doctorList.add(doctor);
    }
    */
}
