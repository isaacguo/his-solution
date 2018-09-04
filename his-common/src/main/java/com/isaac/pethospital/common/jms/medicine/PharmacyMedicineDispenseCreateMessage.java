package com.isaac.pethospital.common.jms.medicine;

public class PharmacyMedicineDispenseCreateMessage {

    String pharmacyMedicineDispenseUuid;
    String treatmentCaseUuid;

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
