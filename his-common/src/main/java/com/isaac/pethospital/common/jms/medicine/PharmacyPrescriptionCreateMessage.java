package com.isaac.pethospital.common.jms.medicine;

public class PharmacyPrescriptionCreateMessage {

    String pharmacyPrescriptionUuid;
    String treatmentCaseUuid;
    String petOwnerUuid;
    String petUuid;

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
}