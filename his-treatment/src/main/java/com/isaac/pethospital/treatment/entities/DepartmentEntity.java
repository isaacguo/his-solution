package com.isaac.pethospital.treatment.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DepartmentEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getDepId() {
        return depId;
    }

    public void setDepId(Long depId) {
        this.depId = depId;
    }

    private Long depId;
    private String name;
    private String description;
    private boolean exposeToPublic;
    private boolean openToFrontDesk;

    public boolean isOpenToFrontDesk() {
        return openToFrontDesk;
    }

    public void setOpenToFrontDesk(boolean openToFrontDesk) {
        this.openToFrontDesk = openToFrontDesk;
    }

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
