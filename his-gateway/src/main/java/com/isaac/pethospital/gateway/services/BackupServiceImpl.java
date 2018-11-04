package com.isaac.pethospital.gateway.services;

import com.isaac.pethospital.common.services.AbstractCrudService;
import com.isaac.pethospital.gateway.entities.BackupEntity;
import com.isaac.pethospital.gateway.repositories.BackupRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class BackupServiceImpl extends AbstractCrudService<BackupEntity, BackupEntity> implements BackupService<BackupEntity, BackupEntity> {
    private final BackupRepository backupRepository;
    private final ScheduleService scheduleService;

    public BackupServiceImpl(BackupRepository backupRepository, ScheduleService scheduleService) {
        super(backupRepository);
        this.backupRepository = backupRepository;
        this.scheduleService = scheduleService;
    }

    @Override
    public BackupEntity create(BackupEntity request) {

        this.backupRepository.save(request);
        this.scheduleService.scheduleJob(request);

        return request;
    }

    @Override
    public BackupEntity update(BackupEntity request) {
        request.setId(1L);
        this.scheduleService.scheduleJob(request);
        return this.backupRepository.save(request);
    }

}
