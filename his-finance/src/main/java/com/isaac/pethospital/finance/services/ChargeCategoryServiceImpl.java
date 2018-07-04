package com.isaac.pethospital.finance.services;

import com.isaac.pethospital.finance.dtos.ChargeCategoryOperationRequest;
import com.isaac.pethospital.finance.entities.ChargeCategoryEntity;
import com.isaac.pethospital.finance.repositories.ChargeCategoryRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChargeCategoryServiceImpl implements ChargeCategoryService {

    private final ChargeCategoryRepository chargeCategoryRepository;

    public ChargeCategoryServiceImpl(ChargeCategoryRepository chargeCategoryRepository) {
        this.chargeCategoryRepository = chargeCategoryRepository;
    }

    @Override
    public ChargeCategoryEntity create(ChargeCategoryOperationRequest request) {


        Long parentId = request.getParentId();
        String name = request.getName();

        if (StringUtils.isEmpty(name))
            throw new RuntimeException("Charge Category name is null");
        ChargeCategoryEntity de = this.chargeCategoryRepository.findByName(name);
        if (de != null)
            throw new RuntimeException("Charge Category with name:" + name + " has existed");
        if (parentId == null) {

            ChargeCategoryEntity chargeCategoryEntity=new ChargeCategoryEntity();
            chargeCategoryEntity.setName(name);
            chargeCategoryEntity.setParent(null);

            return this.chargeCategoryRepository.save(chargeCategoryEntity);

        } else {
            ChargeCategoryEntity parent = this.chargeCategoryRepository.findOne(parentId);
            if (parent == null)
                throw new RuntimeException("Parent Charge Category is null");
            parent.addChildByName(name);
            return this.chargeCategoryRepository.save(parent);
        }

    }

    @Override
    public boolean delete(Long id) {
        this.chargeCategoryRepository.delete(id);
        return true;
    }

    @Override
    public ChargeCategoryEntity update(ChargeCategoryOperationRequest request) {
        return null;
    }


    @Override
    public List<ChargeCategoryEntity> findRoot() {

        return this.chargeCategoryRepository.findByParentIsNull();
    }

    @Override
    public boolean renameChargeCategory(ChargeCategoryOperationRequest request) {
        if (StringUtils.isEmpty(request.getName())) {
            throw new RuntimeException("Name is empty");
        }
        Long id = request.getId();
        if (id == null)
            throw new RuntimeException("ChargeCategory Id is null");
        ChargeCategoryEntity de = this.chargeCategoryRepository.findOne(id);
        if (de == null)
            throw new RuntimeException("ChargeCategory is null");

        de.setName(request.getName());
        this.chargeCategoryRepository.save(de);
        return true;
    }

}
