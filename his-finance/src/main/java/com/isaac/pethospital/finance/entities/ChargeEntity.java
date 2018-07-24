package com.isaac.pethospital.finance.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.isaac.pethospital.finance.enums.ChargeStatusEnum;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Entity
public class ChargeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String chargeUuid;
    private String ownerUuid;
    private String petUuid;
    private String treatmentCaseUuid;
    private LocalDateTime createdDate;
    private BigDecimal totalAmount;
    private ChargeStatusEnum status;
    @OneToMany(mappedBy = "charge")
    @JsonManagedReference("charge-chargeItem")
    private List<ChargeItemEntity> chargeItems = new LinkedList();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChargeUuid() {
        return chargeUuid;
    }

    public void setChargeUuid(String chargeUuid) {
        this.chargeUuid = chargeUuid;
    }

    public String getTreatmentCaseUuid() {
        return treatmentCaseUuid;
    }

    public void setTreatmentCaseUuid(String treatmentCaseUuid) {
        this.treatmentCaseUuid = treatmentCaseUuid;
    }

    public List<ChargeItemEntity> getChargeItems() {
        return chargeItems;
    }

    public void addChargeItem(ChargeItemEntity chargeItem) {
        if (chargeItem == null)
            throw new RuntimeException("Charge Item is null");
        chargeItem.setCharge(this);
        this.chargeItems.add(chargeItem);
    }

    public void removeChargeItems(ChargeItemEntity chargeItem) {
        if (chargeItem == null)
            throw new RuntimeException("Charge Item is null");
        chargeItem.setCharge(null);
        this.chargeItems.remove(chargeItem);
    }



    public String getOwnerUuid() {
        return ownerUuid;
    }

    public void setOwnerUuid(String ownerUuid) {
        this.ownerUuid = ownerUuid;
    }

    public String getPetUuid() {
        return petUuid;
    }

    public void setPetUuid(String petUuid) {
        this.petUuid = petUuid;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public ChargeStatusEnum getStatus() {
        return status;
    }

    public void setStatus(ChargeStatusEnum status) {
        this.status = status;
    }
}
