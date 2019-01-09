package com.isaac.pethospital.medicine.services;

import com.isaac.pethospital.common.jms.finance.ChargeOrderStatusChangedMessage;
import com.isaac.pethospital.common.services.CrudService;
import com.isaac.pethospital.medicine.dtos.PharmacyOperationRequest;
import com.isaac.pethospital.medicine.entities.InventoryItemEntity;
import com.isaac.pethospital.medicine.entities.PharmacyPrescriptionEntity;
import com.isaac.pethospital.medicine.enums.PrescriptionStatusEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PharmacyPrescriptionService<T, R> extends CrudService<T, R> {

    void generatePharmacyPrescriptionOrderMessage(PharmacyPrescriptionEntity prescription);

    List<InventoryItemEntity> findMedicineByNameContains(String name);

    List<PharmacyPrescriptionEntity> findByPetUuidToday(String uuid);

    List<PharmacyPrescriptionEntity> findByPetUuidHistory(String uuid);

    PharmacyPrescriptionEntity submitPrescription(PharmacyOperationRequest request);

    Page<PharmacyPrescriptionEntity> findAllPrescriptionsByStatusOnPage(PrescriptionStatusEnum statusEnum, Pageable pageable);

    void onFinanceChargeStatusChanged(ChargeOrderStatusChangedMessage message);
}
