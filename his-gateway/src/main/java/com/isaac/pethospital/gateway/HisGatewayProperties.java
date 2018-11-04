package com.isaac.pethospital.gateway;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(prefix = "data")
public class HisGatewayProperties {

    String backupFolder;
    String backupExecutable;
    String restoreExecutable;

    public String getBackupExecutable() {
        return backupExecutable;
    }

    public void setBackupExecutable(String backupExecutable) {
        this.backupExecutable = backupExecutable;
    }

    public String getRestoreExecutable() {
        return restoreExecutable;
    }

    public void setRestoreExecutable(String restoreExecutable) {
        this.restoreExecutable = restoreExecutable;
    }

    public String getBackupFolder() {
        return backupFolder;
    }

    public void setBackupFolder(String backupFolder) {
        this.backupFolder = backupFolder;
    }
}
