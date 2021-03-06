package com.isaac.pethospital.procurement.services;

import com.isaac.pethospital.procurement.dtos.ProcurementApprovalOperationRequest;
import com.isaac.pethospital.procurement.entities.ProcurementApprovalEntity;
import com.isaac.pethospital.procurement.entities.ProcurementApprovalStageEntity;
import com.isaac.pethospital.procurement.entities.ProcurementEntity;

import java.util.List;

public interface ProcurementApprovalService {
    ProcurementApprovalStageEntity getRoot();

    void procurementCreated(ProcurementEntity any);

    List<ProcurementApprovalEntity> findMyUnfinishedApprovals(String userAccount);

    List<ProcurementEntity> findMyUnfinishedApprovalProcurements(String userAccount);

    boolean approvalReceived(ProcurementApprovalOperationRequest request);


    Long findMyUnfinishedApprovalProcurementsCount(String userAccount);
}
