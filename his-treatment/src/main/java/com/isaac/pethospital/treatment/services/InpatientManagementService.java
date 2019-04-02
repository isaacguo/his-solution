package com.isaac.pethospital.treatment.services;

import com.isaac.pethospital.treatment.dtos.InpatientManagementRequest;
import com.isaac.pethospital.treatment.entities.InpatientManagementEntity;

import java.util.List;

public interface InpatientManagementService {
    List<InpatientManagementEntity> findByManagementStatus(String status);

    void createInpatientRecord(InpatientManagementRequest request);
}
