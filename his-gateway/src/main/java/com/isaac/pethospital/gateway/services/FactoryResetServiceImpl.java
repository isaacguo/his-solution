package com.isaac.pethospital.gateway.services;

import com.isaac.pethospital.common.services.AuthorizationService;
import com.isaac.pethospital.common.services.AuthorizationTopicService;
import com.isaac.pethospital.common.services.FactoryResetService;
import com.isaac.pethospital.gateway.entities.BackupEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class FactoryResetServiceImpl implements FactoryResetService {

    private final AuthorizationService authorizationService;
    private final AuthorizationTopicService authorizationTopicService;
    private final BackupService<BackupEntity, BackupEntity> backupService;

    public FactoryResetServiceImpl(AuthorizationService authorizationService, AuthorizationTopicService authorizationTopicService, BackupService<BackupEntity, BackupEntity> backupService) {
        this.authorizationService = authorizationService;
        this.authorizationTopicService = authorizationTopicService;
        this.backupService = backupService;
    }

    @Transactional
    @Override
    public void reset() {
        this.cleanDb();
        this.init();

    }

    @Transactional
    void cleanDb() {

        authorizationService.deleteAll();
        authorizationTopicService.deleteAll();
    }

    @Transactional
    void init() {
        authorizationService.setDomainName("Gateway");
        authorizationTopicService.addAuthorizationTopicAndOperations("数据管理", "操作");
    }


    @Override
    public void insertData() {

        BackupEntity be = backupService.readOne(1L);
        if(be==null)
        {
            be=new BackupEntity();
            be.setScheduleType("byhour");
            be.setHourValue(1);
            backupService.create(be);
        }

    }
}
