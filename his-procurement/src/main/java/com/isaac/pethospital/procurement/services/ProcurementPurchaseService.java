package com.isaac.pethospital.procurement.services;

import com.isaac.pethospital.procurement.dtos.ProcurementPurchaseOperationRequest;
import com.isaac.pethospital.procurement.entities.ProcurementPurchaseEntity;

public interface ProcurementPurchaseService {

    boolean createPurchase(ProcurementPurchaseOperationRequest ppor);
}
