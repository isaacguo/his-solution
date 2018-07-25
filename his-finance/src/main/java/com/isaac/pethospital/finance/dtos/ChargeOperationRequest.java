package com.isaac.pethospital.finance.dtos;

import com.isaac.pethospital.finance.entities.ChargeEntity;
import com.isaac.pethospital.finance.entities.ChargeItemEntity;
import com.isaac.pethospital.common.enums.ChargeStatusEnum;
import com.isaac.pethospital.finance.services.PriceService;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class ChargeOperationRequest {

    private String ownerUuid;
    private String petUuid;
    private List<ChargeItemEntity> items = new LinkedList();
    private String treatmentCaseUuid;

    public String getTreatmentCaseUuid() {
        return treatmentCaseUuid;
    }

    public void setTreatmentCaseUuid(String treatmentCaseUuid) {
        this.treatmentCaseUuid = treatmentCaseUuid;
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

    public List<ChargeItemEntity> getItems() {
        return items;
    }

    public void setItems(List<ChargeItemEntity> items) {
        this.items = items;
    }

    public ChargeEntity toCharge(PriceService priceService) {
        ChargeEntity chargeEntity = new ChargeEntity();
        chargeEntity.setCreatedDate(LocalDateTime.now());
        chargeEntity.setPetOwnerUuid(this.ownerUuid);
        chargeEntity.setTreatmentCaseUuid(this.treatmentCaseUuid);
        chargeEntity.setPetUuid(this.petUuid);
        chargeEntity.setStatus(ChargeStatusEnum.UNPAID);
        this.items.forEach(r -> {
            ChargeItemEntity chargeItemEntity = new ChargeItemEntity();
            chargeItemEntity.setAmount(r.getAmount());
            chargeItemEntity.setDiscount(r.getDiscount());
            chargeItemEntity.setPrice(priceService.findByUuid(r.getPrice().getPriceItemUuid()));
            this.items.add(chargeItemEntity);
        });
        return chargeEntity;
    }
}
