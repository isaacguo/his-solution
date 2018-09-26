package com.isaac.pethospital.treatment.services;

import com.isaac.pethospital.common.services.AbstractCrudService;
import com.isaac.pethospital.treatment.dtos.ChargeableCategoryOperationRequest;
import com.isaac.pethospital.treatment.entities.ChargeableCategoryEntity;
import com.isaac.pethospital.treatment.repositories.ChargeableCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChargeableCategoryServiceImpl extends AbstractCrudService<ChargeableCategoryEntity, ChargeableCategoryOperationRequest> implements ChargeableCategoryService<ChargeableCategoryEntity, ChargeableCategoryOperationRequest> {
    private final ChargeableCategoryRepository chargeableCategoryRepository;

    public ChargeableCategoryServiceImpl(ChargeableCategoryRepository chargeableCategoryRepository) {
        super(chargeableCategoryRepository);
        this.chargeableCategoryRepository = chargeableCategoryRepository;
    }

    @Override
    public ChargeableCategoryEntity create(ChargeableCategoryOperationRequest request) {

        Long pid = request.getParentId();
        if (pid == null)
        {
            ChargeableCategoryEntity category = new ChargeableCategoryEntity();
            category.setName(request.getName());

            return this.jpaRepository.save(category);
        }
        else
        {

            ChargeableCategoryEntity parent = this.jpaRepository.findOne(pid);
            if (parent == null)
                throw new RuntimeException("parent is null");

            ChargeableCategoryEntity category = new ChargeableCategoryEntity();
            category.setName(request.getName());

            parent.addChild(category);

            return this.jpaRepository.save(parent);
        }
    }

    @Override
    public ChargeableCategoryEntity update(ChargeableCategoryOperationRequest request) {
        Long id = request.getId();
        if (id == null)
            throw new RuntimeException("id is null");
        ChargeableCategoryEntity entity = this.jpaRepository.findOne(id);
        if (entity == null)
            throw new RuntimeException("entity is null");

        entity.setName(request.getName());
        return this.jpaRepository.save(entity);
    }

    @Override
    public List<ChargeableCategoryEntity> findRoots() {
        return this.chargeableCategoryRepository.findByParentIsNull();
    }
}
