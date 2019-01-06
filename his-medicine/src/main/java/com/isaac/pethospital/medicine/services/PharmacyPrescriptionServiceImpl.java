package com.isaac.pethospital.medicine.services;

import com.isaac.pethospital.common.jms.JmsProperties;
import com.isaac.pethospital.common.jms.JmsSender;
import com.isaac.pethospital.common.jms.medicine.PharmacyPrescriptionCreateMessage;
import com.isaac.pethospital.common.jms.treatment.GeneratePharmacyPrescriptionOrderMessage;
import com.isaac.pethospital.common.services.AbstractCrudService;
import com.isaac.pethospital.medicine.dtos.PharmacyOperationRequest;
import com.isaac.pethospital.medicine.entities.InventoryItemEntity;
import com.isaac.pethospital.medicine.entities.PharmacyPrescriptionEntity;
import com.isaac.pethospital.medicine.entities.PharmacyPrescriptionItemEntity;
import com.isaac.pethospital.medicine.enums.PrescriptionStatusEnum;
import com.isaac.pethospital.medicine.repository.InventoryItemRepository;
import com.isaac.pethospital.medicine.repository.PharmacyPrescriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PharmacyPrescriptionServiceImpl extends AbstractCrudService<PharmacyPrescriptionEntity, PharmacyOperationRequest> implements PharmacyPrescriptionService<PharmacyPrescriptionEntity, PharmacyOperationRequest> {


    private final PharmacyPrescriptionRepository pharmacyPrescriptionRepository;
    private final InventoryItemRepository inventoryItemRepository;

    private final JmsSender jmsSender;
    private final JmsProperties jmsProperties;

    public PharmacyPrescriptionServiceImpl(PharmacyPrescriptionRepository jpaRepository, InventoryItemRepository inventoryItemRepository, JmsSender jmsSender, JmsProperties jmsProperties) {
        super(jpaRepository);
        this.pharmacyPrescriptionRepository =jpaRepository;
        this.inventoryItemRepository=inventoryItemRepository;
        this.jmsSender = jmsSender;
        this.jmsProperties = jmsProperties;
    }

    @Override
    public PharmacyPrescriptionEntity create(PharmacyOperationRequest request) {

        Long pid = request.getId();
        if (pid == null || pid==0L)
        {
            PharmacyPrescriptionEntity entity = request.toEntity();
            entity.setStatus(PrescriptionStatusEnum.UNPAID);
            PharmacyPrescriptionEntity ret= pharmacyPrescriptionRepository.save(request.toEntity());
            return ret;
        }
        else
        {
            throw new RuntimeException("id is not null");
        }
    }

    @Override
    public PharmacyPrescriptionEntity update(PharmacyOperationRequest request) {
        return null;
    }

    @Override
    public void onGeneratePharmacyPrescriptionOrderMessage(GeneratePharmacyPrescriptionOrderMessage message) {

        PharmacyPrescriptionEntity pharmacyPrescriptionEntity =new PharmacyPrescriptionEntity();
        pharmacyPrescriptionEntity.setTreatmentCaseUuid(message.getTreatmentCaseUuid());
        pharmacyPrescriptionEntity.setStatus(PrescriptionStatusEnum.UNPAID);
        pharmacyPrescriptionEntity.setPetUuid(message.getPetUuid());
        pharmacyPrescriptionEntity.setPetOwnerUuid(message.getPetOwnerUuid());
        pharmacyPrescriptionEntity.setUuid(UUID.randomUUID().toString());

        message.getMedicineList().forEach(r->{
            PharmacyPrescriptionItemEntity pmdie=new PharmacyPrescriptionItemEntity();
            pmdie.setUnit(r.getUnit());
            pmdie.setSpecification(r.getSpecification());
            pmdie.setName(r.getName());
            pmdie.setUnit(r.getUnit());
            pmdie.setInventoryItemId(r.getInventoryItemId());
            pharmacyPrescriptionEntity.addItem(pmdie);
        });


        PharmacyPrescriptionCreateMessage medicinePrescriptionCreateMessage=new PharmacyPrescriptionCreateMessage();
        medicinePrescriptionCreateMessage.setPharmacyPrescriptionUuid(pharmacyPrescriptionEntity.getUuid());
        medicinePrescriptionCreateMessage.setTreatmentCaseUuid(pharmacyPrescriptionEntity.getTreatmentCaseUuid());
        medicinePrescriptionCreateMessage.setPetUuid(pharmacyPrescriptionEntity.getPetUuid());
        medicinePrescriptionCreateMessage.setPetOwnerUuid(pharmacyPrescriptionEntity.getPetOwnerUuid());
        this.jmsSender.sendEvent(this.jmsProperties.getPharmacyPrescriptionCreateTopic(), medicinePrescriptionCreateMessage);


        this.pharmacyPrescriptionRepository.save(pharmacyPrescriptionEntity);


    }

    @Override
    public List<InventoryItemEntity> findMedicineByNameContains(String name) {
        return this.inventoryItemRepository.findDistinctByNameHanYuPinYinContains(name);
    }

    @Override
    public List<PharmacyPrescriptionEntity> findByPetUuidToday(String uuid) {
        return null;
    }

    @Override
    public List<PharmacyPrescriptionEntity> findByPetUuidHistory(String uuid) {
        return null;
    }
}
