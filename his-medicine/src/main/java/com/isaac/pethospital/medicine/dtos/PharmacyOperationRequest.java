package com.isaac.pethospital.medicine.dtos;

import com.isaac.pethospital.medicine.entities.PharmacyPrescriptionEntity;
import com.isaac.pethospital.medicine.entities.PharmacyPrescriptionItemEntity;
import com.isaac.pethospital.medicine.enums.PrescriptionStatusEnum;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class PharmacyOperationRequest extends PharmacyPrescriptionEntity {

    public void update(PharmacyPrescriptionEntity prescription) {

        List<PharmacyPrescriptionItemEntity> toRemove = new LinkedList<>();
        prescription.getItems().forEach(r -> toRemove.add(r));


        for (PharmacyPrescriptionItemEntity item : toRemove) {
            prescription.removeItem(item);
        }

        this.getItems().forEach(r -> {
            PharmacyPrescriptionItemEntity item = new PharmacyPrescriptionItemEntity();
            item.setUuid(UUID.randomUUID().toString());
            item.setAmount(r.getAmount());
            item.setInventoryItemUuid(r.getInventoryItemUuid());
            item.setName(r.getName());
            item.setSpecification(r.getSpecification());
            item.setUnit(r.getUnit());

            prescription.addItem(item);
        });
    }


    public PharmacyPrescriptionEntity toEntity() {
        PharmacyPrescriptionEntity entity = new PharmacyPrescriptionEntity();
        entity.setId(this.getId());
        entity.setUuid(UUID.randomUUID().toString());
        entity.setSheetNumber(this.getSheetNumber());
        entity.setStatus(PrescriptionStatusEnum.UNSUBMITTED);
        entity.setPetOwnerUuid(this.getPetOwnerUuid());
        entity.setPetUuid(this.getPetUuid());
        entity.setCreatedDate(LocalDateTime.now());

        return entity;
    }
}
