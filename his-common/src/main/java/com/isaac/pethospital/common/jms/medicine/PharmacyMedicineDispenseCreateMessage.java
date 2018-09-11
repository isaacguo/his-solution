package com.isaac.pethospital.common.jms.medicine;

public class PharmacyMedicineDispenseCreateMessage {

    String pharmacyMedicineDispenseUuid;
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

    public String getPharmacyMedicineDispenseUuid() {
        return pharmacyMedicineDispenseUuid;
    }

    public void setPharmacyMedicineDispenseUuid(String pharmacyMedicineDispenseUuid) {
        this.pharmacyMedicineDispenseUuid = pharmacyMedicineDispenseUuid;
    }

    public String getTreatmentCaseUuid() {
        return treatmentCaseUuid;
        }

    public void setTreatmentCaseUuid(String treatmentCaseUuid) {
        this.treatmentCaseUuid = treatmentCaseUuid;
    }
}
