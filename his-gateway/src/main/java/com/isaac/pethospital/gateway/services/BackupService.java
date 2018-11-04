package com.isaac.pethospital.gateway.services;

import com.isaac.pethospital.common.services.CrudService;
import com.isaac.pethospital.gateway.dtos.RestoreData;

import java.util.List;

public interface BackupService<T,R> extends CrudService<T,R> {


    void restoreDatabase(RestoreData restoreData);

    List<String> getBackupFolders();

    List<String> getBackupFiles(String folderName);
}
