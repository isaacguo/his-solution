package com.isaac.pethospital.medicine.services;

import com.isaac.pethospital.common.jms.treatment.GeneratePharmacyPrescriptionOrderMessage;
import com.isaac.pethospital.common.services.CrudService;
import com.isaac.pethospital.medicine.entities.InventoryItemEntity;
import com.isaac.pethospital.medicine.entities.PharmacyPrescriptionEntity;

import java.util.List;

public interface PharmacyPrescriptionService<T, R> extends CrudService<T, R> {
    void onGeneratePharmacyPrescriptionOrderMessage(GeneratePharmacyPrescriptionOrderMessage message);

    List<InventoryItemEntity> findMedicineByNameContains(String name);

    List<PharmacyPrescriptionEntity> findByPetUuidToday(String uuid);

    List<PharmacyPrescriptionEntity> findByPetUuidHistory(String uuid);
}
