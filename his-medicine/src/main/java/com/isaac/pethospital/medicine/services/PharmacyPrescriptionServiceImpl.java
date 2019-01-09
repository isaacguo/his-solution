package com.isaac.pethospital.medicine.services;

import com.isaac.pethospital.common.jms.JmsProperties;
import com.isaac.pethospital.common.jms.JmsSender;
import com.isaac.pethospital.common.jms.finance.ChargeOrderStatusChangedMessage;
import com.isaac.pethospital.common.jms.medicine.PharmacyPrescriptionCreateMessage;
import com.isaac.pethospital.common.jms.medicine.PharmacyPrescriptionItemCreateMessage;
import com.isaac.pethospital.common.services.AbstractCrudService;
import com.isaac.pethospital.medicine.dtos.PharmacyOperationRequest;
import com.isaac.pethospital.medicine.entities.InventoryItemEntity;
import com.isaac.pethospital.medicine.entities.PharmacyPrescriptionEntity;
import com.isaac.pethospital.medicine.enums.PrescriptionStatusEnum;
import com.isaac.pethospital.medicine.repository.InventoryItemRepository;
import com.isaac.pethospital.medicine.repository.PharmacyPrescriptionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PharmacyPrescriptionServiceImpl extends AbstractCrudService<PharmacyPrescriptionEntity, PharmacyOperationRequest> implements PharmacyPrescriptionService<PharmacyPrescriptionEntity, PharmacyOperationRequest> {


    private final PharmacyPrescriptionRepository pharmacyPrescriptionRepository;
    private final InventoryItemRepository inventoryItemRepository;

    private final JmsSender jmsSender;
    private final JmsProperties jmsProperties;

    public PharmacyPrescriptionServiceImpl(PharmacyPrescriptionRepository jpaRepository, InventoryItemRepository inventoryItemRepository, JmsSender jmsSender, JmsProperties jmsProperties) {
        super(jpaRepository);
        this.pharmacyPrescriptionRepository = jpaRepository;
        this.inventoryItemRepository = inventoryItemRepository;
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


        //crom.setTreatmentCaseUuid(treatmentCaseUuid);
        prescription.getItems().forEach(r -> {

            PharmacyPrescriptionItemCreateMessage pharmacyPrescriptionItemCreateMessage=new PharmacyPrescriptionItemCreateMessage();
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
        PharmacyPrescriptionEntity prescription=this.update(request);
        prescription.setStatus(PrescriptionStatusEnum.UNPAID);
        this.pharmacyPrescriptionRepository.save(prescription);

        this.generatePharmacyPrescriptionOrderMessage(prescription);
        return prescription;
    }

    @Override
    public Page<PharmacyPrescriptionEntity> findAllPrescriptionsByStatusOnPage(PrescriptionStatusEnum status, Pageable pageable) {
        return this.pharmacyPrescriptionRepository.findPharmacyPrescriptionEntitiesByStatus(status, pageable);
    }

    @Override
    public void onFinanceChargeStatusChanged(ChargeOrderStatusChangedMessage message) {


    }
}
