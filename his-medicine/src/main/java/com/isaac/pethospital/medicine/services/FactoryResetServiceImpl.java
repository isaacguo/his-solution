package com.isaac.pethospital.medicine.services;

import com.isaac.pethospital.common.services.AuthorizationService;
import com.isaac.pethospital.common.services.AuthorizationTopicService;
import com.isaac.pethospital.common.services.FactoryResetService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class FactoryResetServiceImpl implements FactoryResetService {

    private final AuthorizationService authorizationService;
    private final AuthorizationTopicService authorizationTopicService;

    public FactoryResetServiceImpl(AuthorizationService authorizationService, AuthorizationTopicService authorizationTopicService) {
        this.authorizationService = authorizationService;
        this.authorizationTopicService = authorizationTopicService;
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
    }

    @Transactional
    void init() {
        authorizationService.setDomainName("Medicine");
        authorizationTopicService.addAuthorizationTopicAndOperations("库房管理", "操作");
        authorizationTopicService.addAuthorizationTopicAndOperations("药房管理", "操作");
    }
}
