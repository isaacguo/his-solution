package com.isaac.pethospital.treatment.services;

import com.isaac.pethospital.common.converter.HanyuPinyinConverter;
import com.isaac.pethospital.common.services.AbstractCrudService;
import com.isaac.pethospital.treatment.dtos.ChargeableItemOperationRequest;
import com.isaac.pethospital.treatment.entities.ChargeableCategoryEntity;
import com.isaac.pethospital.treatment.entities.ChargeableItemEntity;
import com.isaac.pethospital.treatment.repositories.ChargeableCategoryRepository;
import com.isaac.pethospital.treatment.repositories.ChargeableItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChargeableItemServiceImpl extends AbstractCrudService<ChargeableItemEntity, ChargeableItemOperationRequest> implements ChargeableItemService<ChargeableItemEntity, ChargeableItemOperationRequest> {
    private final ChargeableItemRepository chargeableItemRepository;
    ChargeableCategoryRepository chargeableCategoryRepository;

    HanyuPinyinConverter converter;

    public ChargeableItemServiceImpl(ChargeableCategoryRepository chargeableCategoryRepository,
                                    ChargeableItemRepository jpaRepository,
                                    HanyuPinyinConverter converter) {
        super(jpaRepository);
        this.chargeableItemRepository = jpaRepository;
        this.chargeableCategoryRepository = chargeableCategoryRepository;
        this.converter=converter;
    }

    @Override
    public ChargeableItemEntity create(ChargeableItemOperationRequest request) {
        ChargeableItemEntity iie = request.toEntity(this.converter);
        ChargeableCategoryEntity ice = chargeableCategoryRepository.findOne(request.getCategoryId());
        ice.addChargeableItem(iie);
        return this.jpaRepository.save(iie);
        //chargeableCategoryRepository.save(ice);
    }

    @Override
    public ChargeableItemEntity update(ChargeableItemOperationRequest request) {
        return null;
    }

    @Override
    public List<ChargeableItemEntity> findByNameContains(String keyword) {
        return this.chargeableItemRepository.findDistinctByNameHanYuPinYinContains(keyword);
    }
}
