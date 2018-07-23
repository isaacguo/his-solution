package com.isaac.pethospital.finance.services;

import com.isaac.pethospital.common.dtos.ChargeItemOperationMesassge;
import com.isaac.pethospital.finance.dtos.PriceOperationRequest;
import com.isaac.pethospital.finance.entities.PriceEntity;

import java.util.List;

public interface PriceService {
    void onChargeItemEventReceived(ChargeItemOperationMesassge mesassge);

    List<PriceEntity> findAll();

    PriceEntity findOne(Long id);

    List<PriceEntity> findByUuids(PriceOperationRequest request);

    PriceEntity update(PriceOperationRequest request);

    PriceEntity findByUuid(String uuid);
}
