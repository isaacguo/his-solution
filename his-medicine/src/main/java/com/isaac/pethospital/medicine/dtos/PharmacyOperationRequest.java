package com.isaac.pethospital.medicine.dtos;

import com.isaac.pethospital.medicine.entities.PharmacyMedicineDispenseEntity;
import com.isaac.pethospital.medicine.entities.PharmacyMedicineDispenseItemEntity;

public class PharmacyOperationRequest extends PharmacyMedicineDispenseEntity {

    public PharmacyMedicineDispenseEntity toEntity()
    {
        PharmacyMedicineDispenseEntity entity=new PharmacyMedicineDispenseEntity();
        entity.setId(this.getId());
        entity.setSheetNumber(this.getSheetNumber());
        entity.setStatus(this.getStatus());

        entity.getItems().forEach(r->{
            PharmacyMedicineDispenseItemEntity item=new PharmacyMedicineDispenseItemEntity();
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
