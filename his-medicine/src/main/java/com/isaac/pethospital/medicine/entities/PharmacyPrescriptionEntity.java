package com.isaac.pethospital.medicine.entities;

import com.isaac.pethospital.common.entities.AbstractCollectionEntity;
import com.isaac.pethospital.medicine.enums.PrescriptionStatusEnum;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class PharmacyPrescriptionEntity extends AbstractCollectionEntity<PharmacyPrescriptionItemEntity> {

    String petOwnerUuid;
    String petUuid;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sheetNumber;
    private PrescriptionStatusEnum status;
    private String treatmentCaseUuid;
    private LocalDateTime createdDate;
    String uuid;

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

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

    public PrescriptionStatusEnum getStatus() {
        return status;
    }

    public void setStatus(PrescriptionStatusEnum status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
