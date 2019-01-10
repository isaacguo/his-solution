package com.isaac.pethospital.finance.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.isaac.pethospital.common.enums.ChargeStatusEnum;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Entity
public class ChargeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String requestUuidFromService;
    private String chargeUuid;
    private String name;
    private String petOwnerUuid;
    private String petUuid;
    private String doctorUuid;
    private String treatmentCaseUuid;
    private LocalDateTime createdDate;
    private LocalDateTime chargedDate;
    private BigDecimal totalAmount;
    private ChargeStatusEnum status;
    private String uuid;
    @OneToMany(mappedBy = "charge", cascade = CascadeType.ALL)
    @JsonManagedReference("charge-chargeItem")
    private List<ChargeItemEntity> chargeItems = new LinkedList();
    public ChargeEntity() {
        this.uuid = UUID.randomUUID().toString();
    }

    public String getRequestUuidFromService() {
        return requestUuidFromService;
    }

    public void setRequestUuidFromService(String requestUuidFromService) {
        this.requestUuidFromService = requestUuidFromService;
    }

    public String getDoctorUuid() {
        return doctorUuid;
    }

    public void setDoctorUuid(String doctorUuid) {
        this.doctorUuid = doctorUuid;
    }

    public String getChargeUuid() {
        return chargeUuid;
    }

    public void setChargeUuid(String chargeUuid) {
        this.chargeUuid = chargeUuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getChargedDate() {
        return chargedDate;
    }

    public void setChargedDate(LocalDateTime chargedDate) {
        this.chargedDate = chargedDate;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
