package com.isaac.pethospital.medicine.services;

import com.isaac.pethospital.common.jms.treatment.GeneratePharmacyMedicineDispenseOrderMessage;
import com.isaac.pethospital.common.services.AbstractCrudService;
import com.isaac.pethospital.medicine.dtos.PharmacyOperationRequest;
import com.isaac.pethospital.medicine.entities.InventoryItemEntity;
import com.isaac.pethospital.medicine.entities.PharmacyMedicineDispenseEntity;
import com.isaac.pethospital.medicine.enums.DispenseStatusEnum;
import com.isaac.pethospital.medicine.repository.InventoryItemRepository;
import com.isaac.pethospital.medicine.repository.PharmacyMedicineDispenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PharmacyMedicineDispenseServiceImpl extends AbstractCrudService<PharmacyMedicineDispenseEntity, PharmacyOperationRequest> implements PharmacyMedicineDispenseService<PharmacyMedicineDispenseEntity, PharmacyOperationRequest>{


    private final PharmacyMedicineDispenseRepository pharmacyMedicineDispenseRepository;
    private final InventoryItemRepository inventoryItemRepository;

    public PharmacyMedicineDispenseServiceImpl(PharmacyMedicineDispenseRepository jpaRepository, InventoryItemRepository inventoryItemRepository) {
        super(jpaRepository);
        this.pharmacyMedicineDispenseRepository=jpaRepository;
        this.inventoryItemRepository=inventoryItemRepository;
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


    }

    @Override
    public List<InventoryItemEntity> findMedicineByNameContains(String name) {
        return this.inventoryItemRepository.findDistinctByNameHanYuPinYinContains(name);
    }
}
