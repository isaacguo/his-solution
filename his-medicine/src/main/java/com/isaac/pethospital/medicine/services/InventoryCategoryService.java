package com.isaac.pethospital.medicine.services;

import com.isaac.pethospital.common.services.CrudService;
import com.isaac.pethospital.medicine.entities.InventoryCategoryEntity;

import java.util.List;

public interface InventoryCategoryService<T, R> extends CrudService<T, R> {
    List<InventoryCategoryEntity> findRoots();
}
