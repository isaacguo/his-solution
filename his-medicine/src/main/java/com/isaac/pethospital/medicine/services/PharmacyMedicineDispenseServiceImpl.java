package com.isaac.pethospital.medicine.services;

import com.isaac.pethospital.common.jms.JmsProperties;
import com.isaac.pethospital.common.jms.JmsSender;
import com.isaac.pethospital.common.jms.medicine.PharmacyMedicineDispenseCreateMessage;
import com.isaac.pethospital.common.jms.treatment.GeneratePharmacyMedicineDispenseOrderMessage;
import com.isaac.pethospital.common.services.AbstractCrudService;
import com.isaac.pethospital.medicine.dtos.PharmacyOperationRequest;
import com.isaac.pethospital.medicine.entities.InventoryItemEntity;
import com.isaac.pethospital.medicine.entities.PharmacyMedicineDispenseEntity;
import com.isaac.pethospital.medicine.entities.PharmacyMedicineDispenseItemEntity;
import com.isaac.pethospital.medicine.enums.DispenseStatusEnum;
import com.isaac.pethospital.medicine.repository.InventoryItemRepository;
import com.isaac.pethospital.medicine.repository.PharmacyMedicineDispenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PharmacyMedicineDispenseServiceImpl extends AbstractCrudService<PharmacyMedicineDispenseEntity, PharmacyOperationRequest> implements PharmacyMedicineDispenseService<PharmacyMedicineDispenseEntity, PharmacyOperationRequest>{


    private final PharmacyMedicineDispenseRepository pharmacyMedicineDispenseRepository;
    private final InventoryItemRepository inventoryItemRepository;

    private final JmsSender jmsSender;
    private final JmsProperties jmsProperties;

    public PharmacyMedicineDispenseServiceImpl(PharmacyMedicineDispenseRepository jpaRepository, InventoryItemRepository inventoryItemRepository, JmsSender jmsSender, JmsProperties jmsProperties) {
        super(jpaRepository);
        this.pharmacyMedicineDispenseRepository=jpaRepository;
        this.inventoryItemRepository=inventoryItemRepository;
        this.jmsSender = jmsSender;
        this.jmsProperties = jmsProperties;
    }

    @Override
    public PharmacyMedicineDispenseEntity create(PharmacyOperationRequest request) {

        Long pid = request.getId();
        if (pid == null || pid==0L)
        {
            PharmacyMedicineDispenseEntity entity = request.toEntity();
            entity.setStatus(DispenseStatusEnum.UNPAID);
            PharmacyMedicineDispenseEntity ret=pharmacyMedicineDispenseRepository.save(request.toEntity());
            return ret;
        }
        else
        {
            throw new RuntimeException("id is not null");
        }
    }

    @Override
    public PharmacyMedicineDispenseEntity update(PharmacyOperationRequest request) {
        return null;
    }

    @Override
    public void onGeneratePharmacyMedicineDispenseOrderMessage(GeneratePharmacyMedicineDispenseOrderMessage message) {

        PharmacyMedicineDispenseEntity pharmacyMedicineDispenseEntity=new PharmacyMedicineDispenseEntity();
        pharmacyMedicineDispenseEntity.setTreatmentCaseUuid(message.getTreatmentCaseUuid());
        pharmacyMedicineDispenseEntity.setStatus(DispenseStatusEnum.UNPAID);
        pharmacyMedicineDispenseEntity.setPetUuid(message.getPetUuid());
        pharmacyMedicineDispenseEntity.setPetOwnerUuid(message.getPetOwnerUuid());
        pharmacyMedicineDispenseEntity.setUuid(UUID.randomUUID().toString());

        message.getMedicineList().forEach(r->{
            PharmacyMedicineDispenseItemEntity pmdie=new PharmacyMedicineDispenseItemEntity();
            pmdie.setUnit(r.getUnit());
            pmdie.setSpecification(r.getSpecification());
            pmdie.setName(r.getName());
            pmdie.setUnit(r.getUnit());
            pmdie.setInventoryItemId(r.getInventoryItemId());
            pharmacyMedicineDispenseEntity.addItem(pmdie);
        });


        PharmacyMedicineDispenseCreateMessage medicineDispenseCreateMessage=new PharmacyMedicineDispenseCreateMessage();
        medicineDispenseCreateMessage.setPharmacyMedicineDispenseUuid(pharmacyMedicineDispenseEntity.getUuid());
        medicineDispenseCreateMessage.setTreatmentCaseUuid(pharmacyMedicineDispenseEntity.getTreatmentCaseUuid());
        medicineDispenseCreateMessage.setPetUuid(pharmacyMedicineDispenseEntity.getPetUuid());
        medicineDispenseCreateMessage.setPetOwnerUuid(pharmacyMedicineDispenseEntity.getPetOwnerUuid());
        this.jmsSender.sendEvent(this.jmsProperties.getPharmacyMedicineDispenseCreateTopic(), medicineDispenseCreateMessage);


        this.pharmacyMedicineDispenseRepository.save(pharmacyMedicineDispenseEntity);


    }

    @Override
    public List<InventoryItemEntity> findMedicineByNameContains(String name) {
        return this.inventoryItemRepository.findDistinctByNameHanYuPinYinContains(name);
    }
}
