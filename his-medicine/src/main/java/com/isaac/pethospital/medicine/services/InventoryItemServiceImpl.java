package com.isaac.pethospital.medicine.services;

import com.isaac.pethospital.common.converter.HanyuPinyinConverter;
import com.isaac.pethospital.common.services.AbstractCrudService;
import com.isaac.pethospital.medicine.dtos.InventoryItemOperationRequest;
import com.isaac.pethospital.medicine.entities.InventoryCategoryEntity;
import com.isaac.pethospital.medicine.entities.InventoryItemEntity;
import com.isaac.pethospital.medicine.repository.InventoryCategoryRepository;
import com.isaac.pethospital.medicine.repository.InventoryItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class InventoryItemServiceImpl extends AbstractCrudService<InventoryItemEntity, InventoryItemOperationRequest> implements InventoryItemService<InventoryItemEntity, InventoryItemOperationRequest> {

    private final InventoryItemRepository inventoryItemRepository;
    InventoryCategoryRepository inventoryCategoryRepository;

    HanyuPinyinConverter converter;

    public InventoryItemServiceImpl(InventoryCategoryRepository inventoryCategoryRepository,
                                    InventoryItemRepository jpaRepository,

                                    HanyuPinyinConverter converter) {
        super(jpaRepository);
        this.inventoryItemRepository = jpaRepository;
        this.inventoryCategoryRepository = inventoryCategoryRepository;
        this.converter=converter;
    }

    @Override
    public InventoryItemEntity create(InventoryItemOperationRequest request) {
        InventoryItemEntity iie = request.toEntity(this.converter);
        InventoryCategoryEntity ice = inventoryCategoryRepository.findOne(request.getCategoryId());
        ice.addInventorItem(iie);
        return this.jpaRepository.save(iie);
        //inventoryCategoryRepository.save(ice);
    }

    @Override
    public InventoryItemEntity update(InventoryItemOperationRequest request) {
        return null;
    }

    @Override
    public List<InventoryItemEntity> findByNameContains(String keyword) {
        return this.inventoryItemRepository.findDistinctByNameHanYuPinYinContains(keyword);
    }
}
