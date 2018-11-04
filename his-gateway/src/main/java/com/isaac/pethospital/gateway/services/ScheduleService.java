package com.isaac.pethospital.gateway.services;

import com.isaac.pethospital.gateway.entities.BackupEntity;

public interface ScheduleService {


    void scheduleJob(BackupEntity backupEntity);
}
