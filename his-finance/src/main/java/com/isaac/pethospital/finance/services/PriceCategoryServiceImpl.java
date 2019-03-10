package com.isaac.pethospital.finance.services;

import com.isaac.pethospital.finance.dtos.ChargeCategoryOperationRequest;
import com.isaac.pethospital.finance.entities.PriceCategoryEntity;
import com.isaac.pethospital.finance.repositories.PriceCategoryRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceCategoryServiceImpl implements PriceCategoryService {

    private final PriceCategoryRepository priceCategoryRepository;

    public PriceCategoryServiceImpl(PriceCategoryRepository priceCategoryRepository) {
        this.priceCategoryRepository = priceCategoryRepository;
    }

    @Override
    public PriceCategoryEntity create(ChargeCategoryOperationRequest request) {


        Long parentId = request.getParentId();
        String name = request.getName();

        if (StringUtils.isEmpty(name))
            throw new RuntimeException("Charge Category name is null");
        PriceCategoryEntity de = this.priceCategoryRepository.findByName(name);
        if (de != null)
            throw new RuntimeException("Charge Category with name:" + name + " has existed");
        if (parentId == null) {

            PriceCategoryEntity priceCategoryEntity =new PriceCategoryEntity();
            priceCategoryEntity.setName(name);
            priceCategoryEntity.setParent(null);

            return this.priceCategoryRepository.save(priceCategoryEntity);

        } else {
            PriceCategoryEntity parent = this.priceCategoryRepository.findOne(parentId);
            if (parent == null)
                throw new RuntimeException("Parent Charge Category is null");
            parent.addChildByName(name);
            return this.priceCategoryRepository.save(parent);
        }

    }

    @Override
    public boolean delete(Long id) {
        this.priceCategoryRepository.delete(id);
        return true;
    }

    @Override
    public PriceCategoryEntity update(ChargeCategoryOperationRequest request) {
        return null;
    }


    @Override
    public List<PriceCategoryEntity> findRoot() {

        return this.priceCategoryRepository.findByParentIsNull();
    }

    @Override
    public boolean renameChargeCategory(ChargeCategoryOperationRequest request) {
        if (StringUtils.isEmpty(request.getName())) {
            throw new RuntimeException("Name is empty");
        }
        Long id = request.getId();
        if (id == null)
            throw new RuntimeException("ChargeCategory Id is null");
        PriceCategoryEntity de = this.priceCategoryRepository.findOne(id);
        if (de == null)
            throw new RuntimeException("ChargeCategory is null");

        de.setName(request.getName());
        this.priceCategoryRepository.save(de);
        return true;
    }

}
