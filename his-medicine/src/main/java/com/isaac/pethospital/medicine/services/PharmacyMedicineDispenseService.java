package com.isaac.pethospital.medicine.services;

import com.isaac.pethospital.common.jms.treatment.GeneratePharmacyMedicineDispenseOrderMessage;
import com.isaac.pethospital.common.services.CrudService;
import com.isaac.pethospital.medicine.entities.InventoryItemEntity;

import java.util.List;

public interface PharmacyMedicineDispenseService<T, R> extends CrudService<T, R> {
    void onGeneratePharmacyMedicineDispenseOrderMessage(GeneratePharmacyMedicineDispenseOrderMessage message);

    List<InventoryItemEntity> findMedicineByNameContains(String name);
}
