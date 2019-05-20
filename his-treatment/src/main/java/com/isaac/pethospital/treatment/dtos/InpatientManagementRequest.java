package com.isaac.pethospital.treatment.dtos;

public class InpatientManagementRequest {

    String petUuid;
    String requestDoctor;
    String requestDoctorUuid;
    String reasonToInpatient;
    String petStatus;

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
