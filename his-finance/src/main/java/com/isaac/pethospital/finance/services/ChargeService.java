package com.isaac.pethospital.finance.services;

import com.isaac.pethospital.common.dtos.ChargeItemOperationMesassge;
import com.isaac.pethospital.finance.dtos.ChargeOperationRequest;
import com.isaac.pethospital.finance.entities.ChargeEntity;

import java.util.List;

public interface ChargeService {
    void onChargeItemEventReceived(ChargeItemOperationMesassge mesassge);

    List<ChargeEntity> findAll();

    ChargeEntity findOne(Long id);

    List<ChargeEntity> findByUuids(ChargeOperationRequest request);

    ChargeEntity update(ChargeOperationRequest request);

    ChargeEntity findByUuid(String uuid);
}
