package com.isaac.pethospital.medicine.services;

import com.isaac.pethospital.common.services.CrudService;
import com.isaac.pethospital.medicine.entities.InventoryItemEntity;

import java.util.List;

public interface InventoryItemService<T, R> extends CrudService<T, R> {
    List<InventoryItemEntity> findByNameContains(String keyword);
}
