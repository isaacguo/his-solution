package com.isaac.pethospital.medicine.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.isaac.pethospital.common.entities.AbstractCollectionEntity;
import com.isaac.pethospital.medicine.enums.DispenseStatusEnum;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class PharmacyMedicineDispenseEntity extends AbstractCollectionEntity<PharmacyMedicineDispenseItemEntity> {

    String petOwnerUuid;
    String petUuid;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sheetNumber;
    private DispenseStatusEnum status;
    private String treatmentCaseUuid;
    String uuid;


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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

    public String getTreatmentCaseUuid() {
        return treatmentCaseUuid;
    }

    public void setTreatmentCaseUuid(String treatmentCaseUuid) {
        this.treatmentCaseUuid = treatmentCaseUuid;
    }

    public String getSheetNumber() {
        return sheetNumber;
    }

    public void setSheetNumber(String sheetNumber) {
        this.sheetNumber = sheetNumber;
    }

    public DispenseStatusEnum getStatus() {
        return status;
    }

    public void setStatus(DispenseStatusEnum status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
