package com.isaac.pethospital.finance.services;

import com.isaac.pethospital.finance.dtos.ChargeCategoryOperationRequest;
import com.isaac.pethospital.finance.entities.ChargeCategoryEntity;
import com.isaac.pethospital.finance.entities.ChargeEntity;

import java.util.List;

public interface ChargeCategoryService {

    ChargeCategoryEntity create(ChargeCategoryOperationRequest request);
    boolean delete(Long id);
    ChargeCategoryEntity update(ChargeCategoryOperationRequest request);
    List<ChargeCategoryEntity> findRoot();
    boolean renameChargeCategory(ChargeCategoryOperationRequest request);

}
