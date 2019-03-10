package com.isaac.pethospital.common.jms.medicine;

import java.util.LinkedList;
import java.util.List;

public class PharmacyPrescriptionCreateMessage {

    String pharmacyPrescriptionUuid;
    String treatmentCaseUuid;
    String petOwnerUuid;
    String petUuid;
    String petName;
    String petOwnerName;
    String doctorName;
    String doctorUuid;

    private List<PharmacyPrescriptionItemCreateMessage> pharmacyPrescriptionItems = new LinkedList<>();

    public List<PharmacyPrescriptionItemCreateMessage> getPharmacyPrescriptionItems() {
        return pharmacyPrescriptionItems;
    }


    public void addPharmacyPrescriptionItem(PharmacyPrescriptionItemCreateMessage pharmacyPrescriptionItem) {
        this.pharmacyPrescriptionItems.add(pharmacyPrescriptionItem);
    }

    public void setPharmacyPrescriptionItems(List<PharmacyPrescriptionItemCreateMessage> pharmacyPrescriptionItems) {
        this.pharmacyPrescriptionItems = pharmacyPrescriptionItems;
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
