package com.isaac.pethospital.procurement.services;

import com.isaac.pethospital.procurement.dtos.ProcurementOperation;
import com.isaac.pethospital.procurement.entities.ProcurementEntity;
import com.isaac.pethospital.procurement.entities.ProcurementRequestEntity;

import java.util.List;

public interface ProcurementService {

    void requestSubmitted(ProcurementRequestEntity request);

    ProcurementEntity createProcurement(ProcurementRequestEntity request);

    List<ProcurementEntity> findAllMyProcurements(String requester);

    //ProcurementEntity addVendorInfo(ProcurementOperation po);
}
