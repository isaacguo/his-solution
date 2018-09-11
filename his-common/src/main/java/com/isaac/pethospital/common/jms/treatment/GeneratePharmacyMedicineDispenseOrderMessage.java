package com.isaac.pethospital.common.jms.treatment;

import java.util.List;

public class GeneratePharmacyMedicineDispenseOrderMessage {

    String treatmentCaseUuid;
    String petOwnerUuid;
    String petUuid;
    List<MedicineItemMessage> medicineList;

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

    public List<MedicineItemMessage> getMedicineList() {
        return medicineList;
    }

    public void setMedicineList(List<MedicineItemMessage> medicineList) {
        this.medicineList = medicineList;
    }

}
