package com.isaac.pethospital.finance.services;

import com.isaac.pethospital.finance.dtos.ChargeOperationRequest;
import com.isaac.pethospital.finance.entities.ChargeEntity;
import com.isaac.pethospital.finance.repositories.ChargeRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChargeServiceImpl extends AbstractCrudService<ChargeEntity, ChargeOperationRequest> implements ChargeService<ChargeEntity, ChargeOperationRequest> {


    public ChargeServiceImpl(ChargeRepository chargeRepository) {
        super(chargeRepository);
    }

    @Override
    public ChargeEntity create(ChargeOperationRequest request) {
        return null;
    }

    @Override
    public ChargeEntity update(ChargeOperationRequest request) {
        return null;
    }

}
