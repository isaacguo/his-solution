package com.isaac.pethospital.medicine.services;

import com.isaac.pethospital.common.services.AbstractCrudService;
import com.isaac.pethospital.medicine.dtos.ImportSheetOperationRequest;
import com.isaac.pethospital.medicine.dtos.InventoryItemOperationRequest;
import com.isaac.pethospital.medicine.entities.ImportSheetEntity;
import com.isaac.pethospital.medicine.entities.InventoryCategoryEntity;
import com.isaac.pethospital.medicine.entities.InventoryItemEntity;
import com.isaac.pethospital.medicine.repository.ImportSheetRepository;
import com.isaac.pethospital.medicine.repository.InventoryCategoryRepository;
import com.isaac.pethospital.medicine.repository.InventoryItemRepository;
import org.springframework.stereotype.Service;


@Service
public class InventoryItemServiceImpl extends AbstractCrudService<InventoryItemEntity, InventoryItemOperationRequest> implements ImportSheetService<InventoryItemEntity, InventoryItemOperationRequest> {

    private final InventoryItemRepository inventoryItemRepository;
    InventoryCategoryRepository inventoryCategoryRepository;

    public InventoryItemServiceImpl(InventoryCategoryRepository inventoryCategoryRepository, InventoryItemRepository jpaRepository) {
        super(jpaRepository);
        this.inventoryItemRepository = jpaRepository;
        this.inventoryCategoryRepository = inventoryCategoryRepository;
    }

    @Override
    public InventoryItemEntity create(InventoryItemOperationRequest request) {
        InventoryItemEntity iie = request.toEntity();
        InventoryCategoryEntity ice = inventoryCategoryRepository.findOne(request.getCategoryId());
        ice.addInventorItem(iie);
        return this.jpaRepository.save(iie);
        //inventoryCategoryRepository.save(ice);
    }

    @Override
    public InventoryItemEntity update(InventoryItemOperationRequest request) {
        return null;
    }
}
