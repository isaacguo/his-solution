package com.isaac.pethospital.gateway.restcontrollers;

import com.isaac.pethospital.common.restcontrollers.AbstractCRUDRestController;
import com.isaac.pethospital.common.services.CrudService;
import com.isaac.pethospital.gateway.dtos.RestoreData;
import com.isaac.pethospital.gateway.entities.BackupEntity;
import com.isaac.pethospital.gateway.services.BackupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("data-management")
public class BackupRestController extends AbstractCRUDRestController<BackupEntity, BackupEntity> {

    BackupService<BackupEntity, BackupEntity> backupService;

    public BackupRestController(BackupService backupService) {
        super(backupService);
        this.backupService = backupService;
    }


    @GetMapping("get-backup-folders")
    public List<String> getBackupFolders() {
        return this.backupService.getBackupFolders();
    }

    @GetMapping("get-backup-files/{folderName}")
    public List<String> getBackupFiles(@PathVariable("folderName") String folderName) {
        return this.backupService.getBackupFiles(folderName);
    }

    @PostMapping("restore")
    public String restoreFile(@RequestBody RestoreData restoreData) {
        this.backupService.restoreDatabase(restoreData);
        return restoreData.getFileName();
    }
}
