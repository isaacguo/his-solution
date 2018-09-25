package com.isaac.pethospital.treatment.services;

import com.isaac.pethospital.common.services.AbstractCrudService;
import com.isaac.pethospital.treatment.dtos.ChargeableItemOperationRequest;
import com.isaac.pethospital.treatment.entities.ChargeableItemEntity;
import com.isaac.pethospital.treatment.repositories.ChargeableItemRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ChargeableItemServiceImpl extends AbstractCrudService<ChargeableItemEntity, ChargeableItemOperationRequest> implements ChargeableItemService<ChargeableItemEntity, ChargeableItemOperationRequest> {
    ChargeableItemRepository chargeableItemRepository;

    public ChargeableItemServiceImpl(ChargeableItemRepository chargeableItemRepository) {
        super(chargeableItemRepository);
        this.chargeableItemRepository = chargeableItemRepository;
    }

    @Override
    public ChargeableItemEntity create(ChargeableItemOperationRequest request) {
        return null;
    }

    @Override
    public ChargeableItemEntity update(ChargeableItemOperationRequest request) {
        return null;
    }
}
