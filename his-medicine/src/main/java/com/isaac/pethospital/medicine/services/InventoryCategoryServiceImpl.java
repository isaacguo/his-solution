package com.isaac.pethospital.medicine.services;

import com.isaac.pethospital.common.jms.JmsProperties;
import com.isaac.pethospital.common.jms.JmsSender;
import com.isaac.pethospital.common.services.AbstractCrudService;
import com.isaac.pethospital.medicine.dtos.InventoryCategoryOperationRequest;
import com.isaac.pethospital.medicine.entities.InventoryCategoryEntity;
import com.isaac.pethospital.medicine.repository.InventoryCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryCategoryServiceImpl extends AbstractCrudService<InventoryCategoryEntity, InventoryCategoryOperationRequest> implements InventoryCategoryService<InventoryCategoryEntity, InventoryCategoryOperationRequest> {


    private final JmsSender jmsSender;
    private final JmsProperties jmsProperties;
    InventoryCategoryRepository inventoryCategoryRepository;

    public InventoryCategoryServiceImpl(InventoryCategoryRepository inventoryCategoryRepository, JmsSender jmsSender, JmsProperties jmsProperties) {
        super(inventoryCategoryRepository);
        this.jmsSender = jmsSender;
        this.jmsProperties = jmsProperties;
        this.inventoryCategoryRepository=inventoryCategoryRepository;
    }


    @Override
    public InventoryCategoryEntity create(InventoryCategoryOperationRequest request) {
        /*
        InventoryCategoryEntity inventoryCategoryEntity = new InventoryCategoryEntity();
        inventoryCategoryEntity.setName(request.getName());
        this.jpaRepository.save(inventoryCategoryEntity);
        return inventoryCategoryEntity;
        */

        Long pid = request.getParentId();
        if (pid == null)
        {
            InventoryCategoryEntity category = new InventoryCategoryEntity();
            category.setName(request.getName());

            return this.jpaRepository.save(category);
        }
        else
        {

            InventoryCategoryEntity parent = this.jpaRepository.findOne(pid);
            if (parent == null)
                throw new RuntimeException("parent is null");

            InventoryCategoryEntity category = new InventoryCategoryEntity();
            category.setName(request.getName());

            parent.addChild(category);

            return this.jpaRepository.save(parent);
        }

    }

    @Override
    public InventoryCategoryEntity update(InventoryCategoryOperationRequest request) {

        Long id = request.getId();
        if (id == null)
            throw new RuntimeException("id is null");
        InventoryCategoryEntity entity = this.jpaRepository.findOne(id);
        if (entity == null)
            throw new RuntimeException("entity is null");

        entity.setName(request.getName());
        return this.jpaRepository.save(entity);
    }

    @Override
    public List<InventoryCategoryEntity> findRoots() {
        return this.inventoryCategoryRepository.findByParentIsNull();
    }
}
