package com.isaac.pethospital.treatment.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class InpatientManagementEntity {

    @Temporal(TemporalType.TIMESTAMP)
    Date inDate;
    @Temporal(TemporalType.TIMESTAMP)
    Date outDate;
    String managementStatus;
    String petUuid;
    String petName;
    String requestDoctor;
    String requestDoctorUuid;
    String reasonToInpatient;
    String petStatus;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public Date getOutDate() {
        return outDate;
    }

    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }

    public String getManagementStatus() {
        return managementStatus;
    }

    public void setManagementStatus(String managementStatus) {
        this.managementStatus = managementStatus;
    }

    public String getPetUuid() {
        return petUuid;
    }

    public void setPetUuid(String petUuid) {
        this.petUuid = petUuid;
    }

    public String getRequestDoctor() {
        return requestDoctor;
    }

    public void setRequestDoctor(String requestDoctor) {
        this.requestDoctor = requestDoctor;
    }

    public String getRequestDoctorUuid() {
        return requestDoctorUuid;
    }

    public void setRequestDoctorUuid(String requestDoctorUuid) {
        this.requestDoctorUuid = requestDoctorUuid;
    }

    public String getReasonToInpatient() {
        return reasonToInpatient;
    }

    public void setReasonToInpatient(String reasonToInpatient) {
        this.reasonToInpatient = reasonToInpatient;
    }

    public String getPetStatus() {
        return petStatus;
    }

    public void setPetStatus(String petStatus) {
        this.petStatus = petStatus;
    }


}
