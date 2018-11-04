package com.isaac.pethospital.gateway.services;

import com.isaac.pethospital.gateway.HisGatewayProperties;
import com.isaac.pethospital.gateway.dtos.RestoreData;
import com.isaac.pethospital.gateway.entities.DatabaseOperationRecordEntity;
import com.isaac.pethospital.gateway.repositories.DatabaseOperationRecordRepository;
import com.isaac.pethospital.gateway.utils.CommandRunUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

@Component
public class DatabaseOperationAsyncHelper {

    private static final Logger LOG = LoggerFactory.getLogger(DatabaseOperationAsyncHelper.class);


    private final DatabaseOperationRecordRepository databaseOperationRecordRepository;
    private final HisGatewayProperties hisGatewayProperties;

    public DatabaseOperationAsyncHelper(DatabaseOperationRecordRepository databaseOperationRecordRepository,
                                        HisGatewayProperties hisGatewayProperties) {
        this.databaseOperationRecordRepository = databaseOperationRecordRepository;
        this.hisGatewayProperties = hisGatewayProperties;
    }

    @Async
    @EventListener
    @Transactional
    public void onRestoreDatabase(RestoreData restoreData) {

        String[] arguments1 = {this.hisGatewayProperties.getBackupFolder() + File.separatorChar + restoreData.getFileName(), "true", "true", "true"};

        DatabaseOperationRecordEntity databaseOperationRecordEntity = new DatabaseOperationRecordEntity();
        databaseOperationRecordEntity.setFolderName(restoreData.getFileName());
        databaseOperationRecordEntity.setStartTime(LocalDateTime.now());
        databaseOperationRecordEntity.setOperation("Restore");

        try {
            if (CommandRunUtil.runCommand(this.hisGatewayProperties.getRestoreExecutable(), arguments1))
                databaseOperationRecordEntity.setResult(true);
            else
                databaseOperationRecordEntity.setResult(false);
            databaseOperationRecordEntity.setFinishTime(LocalDateTime.now());
        } catch (InterruptedException e) {
            databaseOperationRecordEntity.setResult(false);
            databaseOperationRecordEntity.setFinishTime(LocalDateTime.now());
            databaseOperationRecordEntity.setLog(CommandRunUtil.getStackTraceString(e));

            LOG.error("Interrupted!", e);
            // Restore interrupted state...
            Thread.currentThread().interrupt();

        } catch (IOException e) {

            databaseOperationRecordEntity.setResult(false);
            databaseOperationRecordEntity.setFinishTime(LocalDateTime.now());
            databaseOperationRecordEntity.setLog(CommandRunUtil.getStackTraceString(e));
        }

        this.databaseOperationRecordRepository.save(databaseOperationRecordEntity);
    }


}
