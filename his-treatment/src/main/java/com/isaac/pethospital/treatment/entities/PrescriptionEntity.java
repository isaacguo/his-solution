package com.isaac.pethospital.treatment.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class PrescriptionEntity {

    Long medicineNumber; //规格
    String medicineName;
    String medicineSpecification;
    Long medicinePrice;
    Long medicineCount;
    String medicineUnit;
    String medicineGroup;
    String medicineUsage;
    String medicineComment;
    @ManyToOne
    @JsonBackReference("TreatmentCaseEntity-PrescriptionEntity")
    TreatmentCaseEntity treatmentCase;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getMedicineNumber() {
        return medicineNumber;
    }

    public void setMedicineNumber(Long medicineNumber) {
        this.medicineNumber = medicineNumber;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getMedicineSpecification() {
        return medicineSpecification;
    }

    public void setMedicineSpecification(String medicineSpecification) {
        this.medicineSpecification = medicineSpecification;
    }

    public Long getMedicinePrice() {
        return medicinePrice;
    }

    public void setMedicinePrice(Long medicinePrice) {
        this.medicinePrice = medicinePrice;
    }

    public Long getMedicineCount() {
        return medicineCount;
    }

    public void setMedicineCount(Long medicineCount) {
        this.medicineCount = medicineCount;
    }

    public String getMedicineUnit() {
        return medicineUnit;
    }

    public void setMedicineUnit(String medicineUnit) {
        this.medicineUnit = medicineUnit;
    }

    public String getMedicineGroup() {
        return medicineGroup;
    }

    public void setMedicineGroup(String medicineGroup) {
        this.medicineGroup = medicineGroup;
    }

    public String getMedicineUsage() {
        return medicineUsage;
    }

    public void setMedicineUsage(String medicineUsage) {
        this.medicineUsage = medicineUsage;
    }

    public String getMedicineComment() {
        return medicineComment;
    }

    public void setMedicineComment(String medicineComment) {
        this.medicineComment = medicineComment;
    }

    public TreatmentCaseEntity getTreatmentCase() {
        return treatmentCase;
    }

    public void setTreatmentCase(TreatmentCaseEntity treatmentCase) {
        this.treatmentCase = treatmentCase;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
