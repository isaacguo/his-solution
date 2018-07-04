package com.isaac.pethospital.finance.services;

import com.isaac.pethospital.common.services.AuthorizationService;
import com.isaac.pethospital.common.services.AuthorizationTopicService;
import com.isaac.pethospital.common.services.FactoryResetService;
import com.isaac.pethospital.finance.entities.ChargeCategoryEntity;
import com.isaac.pethospital.finance.repositories.ChargeCategoryRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class FactoryResetServiceImpl implements FactoryResetService {

    private final AuthorizationService authorizationService;
    private final AuthorizationTopicService authorizationTopicService;

    private final ChargeCategoryRepository chargeCategoryRepository;


    public FactoryResetServiceImpl(AuthorizationService authorizationService, AuthorizationTopicService authorizationTopicService, ChargeCategoryRepository chargeCategoryRepository) {
        this.authorizationService = authorizationService;
        this.authorizationTopicService = authorizationTopicService;
        this.chargeCategoryRepository = chargeCategoryRepository;
    }

    @Transactional
    @Override
    public void reset() {
        this.cleanDb();
        this.init();
    }

    @Override
    public void insertData() {

        createRootChargeCategory();

    }

    private void createRootChargeCategory() {


    }

    @Transactional
    void cleanDb() {
        authorizationService.deleteAll();
        authorizationTopicService.deleteAll();
    }

    @Transactional
    void init() {
        authorizationService.setDomainName("Finance");
        authorizationTopicService.addAuthorizationTopicAndOperations("财务管理", "操作");
        authorizationTopicService.addAuthorizationTopicAndOperations("收费定价", "操作");
    }

}
