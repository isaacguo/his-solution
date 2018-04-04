package com.isaac.pethospital.procurement.services;

import com.isaac.pethospital.procurement.dtos.ProcurementOperation;
import com.isaac.pethospital.procurement.entities.ProcurementEntity;
import com.isaac.pethospital.procurement.entities.ProcurementPurchaseEntity;
import com.isaac.pethospital.procurement.entities.ProcurementRequestEntity;

import java.util.List;

public interface ProcurementService {

    void requestSubmitted(ProcurementRequestEntity request);

    ProcurementEntity createProcurement(ProcurementRequestEntity request);

    List<ProcurementEntity> findAllMyProcurements(String requester);

    void purchaseSubmitted(Long procurementId, ProcurementPurchaseEntity purchase);

    boolean changeStatus(ProcurementOperation po);
    void approvalPassed(Long procurementId);

    ProcurementEntity findOne(Long id);

    List<ProcurementEntity> findMyProcurementsByPurchaseByAssignee(String userAccount);

    //ProcurementEntity addVendorInfo(ProcurementOperation po);
}
