package com.isaac.pethospital.treatment.services;


import com.isaac.pethospital.common.services.CrudService;
import com.isaac.pethospital.treatment.entities.ChargeableCategoryEntity;

import java.util.List;

public interface ChargeableCategoryService<T, R> extends CrudService<T, R> {
    List<ChargeableCategoryEntity> findRoots();
}
