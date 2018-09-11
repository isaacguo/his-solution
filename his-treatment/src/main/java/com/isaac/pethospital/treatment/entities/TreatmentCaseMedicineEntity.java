package com.isaac.pethospital.treatment.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class TreatmentCaseMedicineEntity {


    String inventoryItemId; //货品编码
    String name; //名称
    String unit; //单位
    String specification; //规格
    BigDecimal amount; //数量

    public String getMedicineUuid() {
        return medicineUuid;
    }

    public void setMedicineUuid(String medicineUuid) {
        this.medicineUuid = medicineUuid;
    }

    String medicineUuid;
    String uuid;
    @ManyToOne

    @JsonBackReference("TreatmentCase-TreatmentCaseMedicine")
    TreatmentCaseEntity treatmentCase;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public TreatmentCaseEntity getTreatmentCase() {
        return treatmentCase;
    }

    public void setTreatmentCase(TreatmentCaseEntity treatmentCase) {
        this.treatmentCase = treatmentCase;
    }

    public String getInventoryItemId() {
        return inventoryItemId;
    }

    public void setInventoryItemId(String inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
