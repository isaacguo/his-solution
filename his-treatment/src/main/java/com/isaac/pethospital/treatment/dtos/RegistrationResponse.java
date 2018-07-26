package com.isaac.pethospital.treatment.dtos;

import com.isaac.pethospital.treatment.common.enums.RegistrationStatusEnum;

public interface RegistrationResponse {
    int getIndexOfDay();
    String getPetName();
    String getPetOwnerName();
    RegistrationStatusEnum getRegistrationStatus();
    Long getPid();
    String getPetUuid();
    Long getRid();
}
