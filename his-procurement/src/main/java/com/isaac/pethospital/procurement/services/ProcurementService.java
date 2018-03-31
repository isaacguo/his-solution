package com.isaac.pethospital.procurement.services;

import com.isaac.pethospital.procurement.dtos.ProcurementOperation;
import com.isaac.pethospital.procurement.entities.ProcurementEntity;
import com.isaac.pethospital.procurement.entities.ProcurementRequestEntity;

public interface ProcurementService {

    void requestSubmitted(ProcurementRequestEntity request, Long procurementId);

    ProcurementEntity createProcurement(ProcurementOperation po);
}
