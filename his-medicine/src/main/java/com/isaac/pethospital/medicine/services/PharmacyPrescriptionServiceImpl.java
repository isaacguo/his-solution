package com.isaac.pethospital.medicine.services;

import com.isaac.pethospital.common.jms.JmsProperties;
import com.isaac.pethospital.common.jms.JmsSender;
import com.isaac.pethospital.common.jms.finance.ChargeOrderStatusChangedMessage;
import com.isaac.pethospital.common.jms.medicine.InventoryPrescriptionDispensedMessage;
import com.isaac.pethospital.common.jms.medicine.PharmacyPrescriptionCreateMessage;
import com.isaac.pethospital.common.jms.medicine.PharmacyPrescriptionItemCreateMessage;
import com.isaac.pethospital.common.services.AbstractCrudService;
import com.isaac.pethospital.medicine.dtos.ExportSheetOperationRequest;
import com.isaac.pethospital.medicine.dtos.PharmacyOperationRequest;
import com.isaac.pethospital.medicine.entities.ExportItemEntity;
import com.isaac.pethospital.medicine.entities.ExportSheetEntity;
import com.isaac.pethospital.medicine.entities.InventoryItemEntity;
import com.isaac.pethospital.medicine.entities.PharmacyPrescriptionEntity;
import com.isaac.pethospital.medicine.enums.PrescriptionStatusEnum;
import com.isaac.pethospital.medicine.repository.InventoryItemRepository;
import com.isaac.pethospital.medicine.repository.PharmacyPrescriptionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Service
public class PharmacyPrescriptionServiceImpl extends AbstractCrudService<PharmacyPrescriptionEntity, PharmacyOperationRequest> implements PharmacyPrescriptionService<PharmacyPrescriptionEntity, PharmacyOperationRequest> {


    private final PharmacyPrescriptionRepository pharmacyPrescriptionRepository;
    private final InventoryItemRepository inventoryItemRepository;
    private final ExportSheetService<ExportSheetEntity, ExportSheetOperationRequest> exportSheetService;

    private final JmsSender jmsSender;
    private final JmsProperties jmsProperties;

    public PharmacyPrescriptionServiceImpl(PharmacyPrescriptionRepository jpaRepository,
                                           InventoryItemRepository inventoryItemRepository,
                                           JmsSender jmsSender, JmsProperties jmsProperties,
                                           ExportSheetService exportSheetService


    ) {
        super(jpaRepository);
        this.pharmacyPrescriptionRepository = jpaRepository;
        this.inventoryItemRepository = inventoryItemRepository;
        this.exportSheetService = exportSheetService;
        this.jmsSender = jmsSender;
        this.jmsProperties = jmsProperties;
    }

    @Override
    public PharmacyPrescriptionEntity create(PharmacyOperationRequest request) {

        Long pid = request.getId();
        if (pid == null || pid == 0L) {
            PharmacyPrescriptionEntity entity = request.toEntity();
            entity.setStatus(PrescriptionStatusEnum.UNSUBMITTED);
            PharmacyPrescriptionEntity ret = pharmacyPrescriptionRepository.save(request.toEntity());
            return ret;
        } else {
            throw new RuntimeException("id is not null");
        }
    }

    @Override
    public PharmacyPrescriptionEntity update(PharmacyOperationRequest request) {
        PharmacyPrescriptionEntity prescription = this.pharmacyPrescriptionRepository.findByUuid(request.getUuid());
        if (prescription == null)
            throw new RuntimeException("Cannot find prescription with the given uuid");

        request.update(prescription);

        this.pharmacyPrescriptionRepository.save(prescription);

        return prescription;
    }

    @Override
    public void generatePharmacyPrescriptionOrderMessage(PharmacyPrescriptionEntity prescription) {
        PharmacyPrescriptionCreateMessage medicinePrescriptionCreateMessage = new PharmacyPrescriptionCreateMessage();
        medicinePrescriptionCreateMessage.setPharmacyPrescriptionUuid(prescription.getUuid());
        medicinePrescriptionCreateMessage.setTreatmentCaseUuid(prescription.getTreatmentCaseUuid());
        medicinePrescriptionCreateMessage.setPetUuid(prescription.getPetUuid());
        medicinePrescriptionCreateMessage.setPetOwnerUuid(prescription.getPetOwnerUuid());

        prescription.getItems().forEach(r -> {

            PharmacyPrescriptionItemCreateMessage pharmacyPrescriptionItemCreateMessage = new PharmacyPrescriptionItemCreateMessage();
            pharmacyPrescriptionItemCreateMessage.setAmount(r.getAmount());
            pharmacyPrescriptionItemCreateMessage.setInventoryItemUuid(r.getInventoryItemUuid());
            pharmacyPrescriptionItemCreateMessage.setName(r.getName());
            pharmacyPrescriptionItemCreateMessage.setSpecification(r.getSpecification());
            pharmacyPrescriptionItemCreateMessage.setUnit(r.getUnit());

            medicinePrescriptionCreateMessage.addPharmacyPrescriptionItem(pharmacyPrescriptionItemCreateMessage);

        });


        this.jmsSender.sendEvent(this.jmsProperties.getPharmacyPrescriptionCreateTopic(), medicinePrescriptionCreateMessage);

    }


    @Override
    public List<InventoryItemEntity> findMedicineByNameContains(String name) {
        return this.inventoryItemRepository.findDistinctByNameHanYuPinYinContains(name);
    }

    @Override
    public List<PharmacyPrescriptionEntity> findByPetUuidToday(String uuid) {
        return this.pharmacyPrescriptionRepository.findPharmacyPrescriptionEntitiesByPetUuidAndCreatedDateAfter(uuid, LocalDate.now().atStartOfDay());
    }

    @Override
    public List<PharmacyPrescriptionEntity> findByPetUuidHistory(String uuid) {
        return this.pharmacyPrescriptionRepository.findPharmacyPrescriptionEntitiesByPetUuidAndCreatedDateBefore(uuid, LocalDate.now().atStartOfDay());
    }

    @Override
    public PharmacyPrescriptionEntity submitPrescription(PharmacyOperationRequest request) {
        PharmacyPrescriptionEntity prescription = this.update(request);
        prescription.setStatus(PrescriptionStatusEnum.UNPAID);
        this.pharmacyPrescriptionRepository.save(prescription);

        this.generatePharmacyPrescriptionOrderMessage(prescription);
        return prescription;
    }

    @Override
    public Page<PharmacyPrescriptionEntity> findAllPrescriptionsByStatusOnPage(PrescriptionStatusEnum status, Pageable pageable) {
        List<PrescriptionStatusEnum> statusList=new LinkedList<>();
        statusList.add(PrescriptionStatusEnum.PAID);
        statusList.add(PrescriptionStatusEnum.WITHDREW);
        return this.pharmacyPrescriptionRepository.findPharmacyPrescriptionEntitiesByStatusIn(statusList, pageable);
    }

    @Override
    public void onFinanceChargeStatusChanged(ChargeOrderStatusChangedMessage message) {
        PharmacyPrescriptionEntity pharmacy = this.pharmacyPrescriptionRepository.findByUuid(message.getRequestUuidFromService());
        if (pharmacy == null)
            throw new RuntimeException("Cannot find pharmacy with uuid:" + message.getRequestUuidFromService());

        switch (message.getNewStatus()) {
            case PAID:
                pharmacy.setStatus(PrescriptionStatusEnum.PAID);
                break;
            case UNPAID:
                break;
            case REIMBURSED:
                break;
        }
        this.pharmacyPrescriptionRepository.save(pharmacy);
    }



    @Override
    public PharmacyPrescriptionEntity medicineDispensed(PharmacyOperationRequest request) {

        PharmacyPrescriptionEntity pharmacy = this.pharmacyPrescriptionRepository.findByUuid(request.getUuid());
        if (pharmacy == null)
            throw new RuntimeException("Cannot find pharmacy with uuid:" + request.getUuid());
        pharmacy.setStatus(PrescriptionStatusEnum.DISPENSED);
        this.pharmacyPrescriptionRepository.save(pharmacy);
        return pharmacy;
    }


    @Override
    public PharmacyPrescriptionEntity withdrawMedicine(PharmacyOperationRequest request) {
        ExportSheetOperationRequest request1 = new ExportSheetOperationRequest();
        List<ExportItemEntity> list = new LinkedList<>();
        request.getItems().forEach(r -> {
            ExportItemEntity eie = new ExportItemEntity();
            InventoryItemEntity item = this.inventoryItemRepository.findInventoryItemEntityByUuid(r.getInventoryItemUuid());
            eie.setName(item.getName());


            eie.setPricePerUnit(new BigDecimal(0));
            eie.setSpecification(item.getSpecification());
            eie.setUnit(r.getUnit());
            eie.setAmount(r.getAmount());
            eie.setTotalPrice(r.getAmount().multiply(eie.getPricePerUnit()));
            eie.setInventoryItemId(item.getId());

            list.add(eie);
        });
        request1.setExportItemList(list);
        this.exportSheetService.create(request1);

        PharmacyPrescriptionEntity pharmacy = this.pharmacyPrescriptionRepository.findByUuid(request.getUuid());
        if (pharmacy == null)
            throw new RuntimeException("Cannot find pharmacy with uuid:" + request.getUuid());

        pharmacy.setStatus(PrescriptionStatusEnum.WITHDREW);
        return this.pharmacyPrescriptionRepository.save(pharmacy);
    }
}
