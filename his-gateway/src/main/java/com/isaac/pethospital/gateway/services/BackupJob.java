package com.isaac.pethospital.gateway.services;

import com.isaac.pethospital.gateway.HisGatewayProperties;
import com.isaac.pethospital.gateway.entities.DatabaseOperationRecordEntity;
import com.isaac.pethospital.gateway.repositories.DatabaseOperationRecordRepository;
import com.isaac.pethospital.gateway.utils.CommandRunUtil;
import org.apache.tomcat.jni.Local;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.isaac.pethospital.gateway.utils.CommandRunUtil.getStackTraceString;

public class BackupJob implements Job {

    private static final Logger LOG = LoggerFactory.getLogger(BackupJob.class);

    @Autowired
    private HisGatewayProperties hisGatewayProperties;
    @Autowired
    private DatabaseOperationRecordRepository databaseOperationRecordRepository;


    public BackupJob() {
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        LOG.info("backup database start");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
        LocalDateTime now = LocalDateTime.now();
        String formatDateTime = now.format(formatter);
        String backupFolder = this.hisGatewayProperties.getBackupFolder() + File.separatorChar + formatDateTime;
        String[] arguments1 = {backupFolder};

        DatabaseOperationRecordEntity databaseOperationRecordEntity = new DatabaseOperationRecordEntity();
        databaseOperationRecordEntity.setFolderName(backupFolder);
        databaseOperationRecordEntity.setStartTime(now);
        databaseOperationRecordEntity.setOperation("Backup");

        try {
            if (CommandRunUtil.runCommand(this.hisGatewayProperties.getBackupExecutable(), arguments1))
                databaseOperationRecordEntity.setResult(true);
            else
                databaseOperationRecordEntity.setResult(false);
            databaseOperationRecordEntity.setFinishTime(LocalDateTime.now());
        } catch (InterruptedException e) {
            databaseOperationRecordEntity.setResult(false);
            databaseOperationRecordEntity.setFinishTime(LocalDateTime.now());
            databaseOperationRecordEntity.setLog(getStackTraceString(e));

            LOG.error("Interrupted!", e);
            // Restore interrupted state...
            Thread.currentThread().interrupt();

        } catch (IOException e) {

            databaseOperationRecordEntity.setResult(false);
            databaseOperationRecordEntity.setFinishTime(LocalDateTime.now());
            databaseOperationRecordEntity.setLog(getStackTraceString(e));
        }

        this.databaseOperationRecordRepository.save(databaseOperationRecordEntity);


        LOG.info("backup database finished");
    }

}
