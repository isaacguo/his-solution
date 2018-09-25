package com.isaac.pethospital.treatment.services;

import com.isaac.pethospital.common.services.AbstractCrudService;
import com.isaac.pethospital.treatment.dtos.ChargeableCategoryOperationRequest;
import com.isaac.pethospital.treatment.entities.ChargeableCategoryEntity;
import com.isaac.pethospital.treatment.repositories.ChargeableCategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class ChargeableCategoryServiceImpl extends AbstractCrudService<ChargeableCategoryEntity, ChargeableCategoryOperationRequest> implements ChargeableCategoryService<ChargeableCategoryEntity, ChargeableCategoryOperationRequest> {
    private final ChargeableCategoryRepository chargeableCategoryRepository;

    public ChargeableCategoryServiceImpl(ChargeableCategoryRepository chargeableCategoryRepository) {
        super(chargeableCategoryRepository);
        this.chargeableCategoryRepository = chargeableCategoryRepository;
    }

    @Override
    public ChargeableCategoryEntity create(ChargeableCategoryOperationRequest request) {
        return null;
    }

    @Override
    public ChargeableCategoryEntity update(ChargeableCategoryOperationRequest request) {
        return null;
    }
}
