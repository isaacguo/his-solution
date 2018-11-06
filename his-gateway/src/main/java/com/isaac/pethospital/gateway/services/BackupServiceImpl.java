package com.isaac.pethospital.gateway.services;

import com.isaac.pethospital.common.services.AbstractCrudService;
import com.isaac.pethospital.gateway.HisGatewayProperties;
import com.isaac.pethospital.gateway.dtos.RestoreData;
import com.isaac.pethospital.gateway.entities.BackupEntity;
import com.isaac.pethospital.gateway.repositories.BackupRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BackupServiceImpl extends AbstractCrudService<BackupEntity, BackupEntity> implements BackupService<BackupEntity, BackupEntity> {
    private static final Logger LOG = LoggerFactory.getLogger(DatabaseOperationAsyncHelper.class);
    private final BackupRepository backupRepository;
    private final ScheduleService scheduleService;
    private final HisGatewayProperties hisGatewayProperties;
    private final ApplicationEventPublisher eventPublisher;

    public BackupServiceImpl(BackupRepository backupRepository,
                             ScheduleService scheduleService,
                             HisGatewayProperties hisGatewayProperties,
                             ApplicationEventPublisher eventPublisher
    ) {
        super(backupRepository);
        this.backupRepository = backupRepository;
        this.scheduleService = scheduleService;
        this.hisGatewayProperties = hisGatewayProperties;
        this.eventPublisher = eventPublisher;
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

    @Override
    public List<String> getBackupFiles(String folderName) {
        File folder = new File(this.hisGatewayProperties.getBackupFolder());
        File subFolder = new File(folder, folderName);

        File[] listOfFiles = subFolder.listFiles();
        List<String> fileList = new ArrayList<>();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile())
                fileList.add(listOfFiles[i].getName());
        }
        return fileList;
    }

    @Override
    public void restoreDatabase(RestoreData restoreData) {
        this.eventPublisher.publishEvent(restoreData);
    }

    @Override
    public List<String> getBackupFolders() {

        File folder = new File(this.hisGatewayProperties.getBackupFolder());
        File[] listOfFiles = folder.listFiles();
        List<File> fileList = new ArrayList<>();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isDirectory())
                fileList.add(listOfFiles[i]);
        }
        fileList.sort((a, b) -> {
            try {
                BasicFileAttributes attrA = Files.readAttributes(a.toPath(), BasicFileAttributes.class);
                BasicFileAttributes attrB = Files.readAttributes(b.toPath(), BasicFileAttributes.class);
                return attrB.creationTime().compareTo(attrA.creationTime());
            } catch (IOException e) {

                this.LOG.error("error in getBackupFolders",e);
                return 0;
            }
        });
        return fileList.stream().map(r->r.getName()).collect(Collectors.toList());
    }
}
