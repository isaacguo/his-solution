package com.isaac.pethospital.treatment.services;

import com.isaac.pethospital.common.services.CrudService;
import com.isaac.pethospital.treatment.entities.ChargeableItemEntity;

import java.util.List;

public interface ChargeableItemService<T, R> extends CrudService<T, R> {
    List<ChargeableItemEntity> findByNameContains(String keyword);
}
