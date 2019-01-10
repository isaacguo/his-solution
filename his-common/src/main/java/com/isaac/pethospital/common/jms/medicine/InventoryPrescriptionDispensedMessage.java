package com.isaac.pethospital.common.jms.medicine;

public class InventoryPrescriptionDispensedMessage {

    String pharmacyPrescriptionUuid;
    String treatmentCaseUuid;
    String petOwnerUuid;
    String petUuid;
    String petName;
    String petOwnerName;
    String doctorName;
    String doctorUuid;

    public String getPharmacyPrescriptionUuid() {
        return pharmacyPrescriptionUuid;
    }

    public void setPharmacyPrescriptionUuid(String pharmacyPrescriptionUuid) {
        this.pharmacyPrescriptionUuid = pharmacyPrescriptionUuid;
    }

    public String getTreatmentCaseUuid() {
        return treatmentCaseUuid;
    }

    public void setTreatmentCaseUuid(String treatmentCaseUuid) {
        this.treatmentCaseUuid = treatmentCaseUuid;
    }

    public String getPetOwnerUuid() {
        return petOwnerUuid;
    }

    public void setPetOwnerUuid(String petOwnerUuid) {
        this.petOwnerUuid = petOwnerUuid;
    }

    public String getPetUuid() {
        return petUuid;
    }

    public void setPetUuid(String petUuid) {
        this.petUuid = petUuid;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetOwnerName() {
        return petOwnerName;
    }

    public void setPetOwnerName(String petOwnerName) {
        this.petOwnerName = petOwnerName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorUuid() {
        return doctorUuid;
    }

    public void setDoctorUuid(String doctorUuid) {
        this.doctorUuid = doctorUuid;
    }
}
