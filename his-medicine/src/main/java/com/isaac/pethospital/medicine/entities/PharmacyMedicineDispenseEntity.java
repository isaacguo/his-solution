package com.isaac.pethospital.medicine.entities;

import com.isaac.pethospital.common.entities.AbstractCollectionEntity;
import com.isaac.pethospital.common.enums.ChargeStatusEnum;
import com.isaac.pethospital.medicine.enums.DispenseStatusEnum;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PharmacyMedicineDispenseEntity extends AbstractCollectionEntity<PharmacyMedicineDispenseItemEntity> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sheetNumber;
    private DispenseStatusEnum status;
    private String treatmentCaseUuid;

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
