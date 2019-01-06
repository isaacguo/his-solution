package com.isaac.pethospital.medicine.dtos;

import com.isaac.pethospital.medicine.entities.PharmacyPrescriptionEntity;
import com.isaac.pethospital.medicine.entities.PharmacyPrescriptionItemEntity;

import java.time.LocalDateTime;
import java.util.UUID;

public class PharmacyOperationRequest extends PharmacyPrescriptionEntity {

    public PharmacyPrescriptionEntity toEntity()
    {
        PharmacyPrescriptionEntity entity=new PharmacyPrescriptionEntity();
        entity.setId(this.getId());
        entity.setUuid(UUID.randomUUID().toString());
        entity.setSheetNumber(this.getSheetNumber());
        entity.setStatus(this.getStatus());
        entity.setPetOwnerUuid(this.getPetOwnerUuid());
        entity.setPetUuid(this.getPetUuid());
        entity.setCreatedDate(LocalDateTime.now());

        entity.getItems().forEach(r->{
            PharmacyPrescriptionItemEntity item=new PharmacyPrescriptionItemEntity();
            item.setAmount(r.getAmount());
            item.setInventoryItemId(r.getInventoryItemId());
            item.setName(r.getName());
            item.setSpecification(r.getSpecification());
            item.setUnit(r.getUnit());

            entity.addItem(item);
        });

        return entity;
    }
}
