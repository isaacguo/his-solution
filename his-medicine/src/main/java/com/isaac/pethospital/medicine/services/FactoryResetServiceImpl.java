package com.isaac.pethospital.medicine.services;

import com.isaac.pethospital.common.services.AuthorizationService;
import com.isaac.pethospital.common.services.AuthorizationTopicService;
import com.isaac.pethospital.common.services.FactoryResetService;
import com.isaac.pethospital.medicine.entities.InventoryCategoryEntity;
import com.isaac.pethospital.medicine.entities.InventoryItemEntity;
import com.isaac.pethospital.medicine.repository.InventoryCategoryRepository;
import com.isaac.pethospital.medicine.repository.InventoryItemRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.UUID;

@Service
public class FactoryResetServiceImpl implements FactoryResetService {

    private final AuthorizationService authorizationService;
    private final AuthorizationTopicService authorizationTopicService;
    private final InventoryCategoryRepository inventoryCategoryRepository;
    private final InventoryItemRepository inventoryItemRepository;

    public FactoryResetServiceImpl(
            InventoryCategoryRepository inventoryCategoryRepository,
            InventoryItemRepository inventoryItemRepository,
            AuthorizationService authorizationService, AuthorizationTopicService authorizationTopicService) {
        this.authorizationService = authorizationService;
        this.authorizationTopicService = authorizationTopicService;
        this.inventoryCategoryRepository=inventoryCategoryRepository;
        this.inventoryItemRepository=inventoryItemRepository;
    }

    @Transactional
    @Override
    public void reset() {

        this.cleanDb();
        this.init();
    }


    @Override
    public void insertData() {

    }

    @Transactional
    void cleanDb() {
        authorizationService.deleteAll();
        authorizationTopicService.deleteAll();

        this.inventoryItemRepository.deleteAll();
        this.inventoryCategoryRepository.deleteAll();
    }

    @Transactional
    void init() {
        authorizationService.setDomainName("Medicine");
        authorizationTopicService.addAuthorizationTopicAndOperations("库房管理", "操作");
        authorizationTopicService.addAuthorizationTopicAndOperations("药房管理", "操作");

        InventoryCategoryEntity cat = new InventoryCategoryEntity();
        cat.setName("药品");
        InventoryItemEntity item1 = new InventoryItemEntity();
        item1.setName("阿司匹林");
        item1.setNameHanYuPinYin("asipinlin");
        item1.setSpecification("Ge");
        item1.setUnit("He");
        item1.setAmount(new BigDecimal(10));
        item1.setUuid(UUID.randomUUID().toString());
        cat.addInventorItem(item1);

        this.inventoryCategoryRepository.save(cat);

    }
}
