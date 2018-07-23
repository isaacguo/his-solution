package com.isaac.pethospital.finance.services;

import com.isaac.pethospital.finance.dtos.ChargeCategoryOperationRequest;
import com.isaac.pethospital.finance.entities.PriceCategoryEntity;

import java.util.List;

public interface PriceCategoryService {

    PriceCategoryEntity create(ChargeCategoryOperationRequest request);
    boolean delete(Long id);
    PriceCategoryEntity update(ChargeCategoryOperationRequest request);
    List<PriceCategoryEntity> findRoot();
    boolean renameChargeCategory(ChargeCategoryOperationRequest request);

}
