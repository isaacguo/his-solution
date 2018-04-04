package com.isaac.pethospital.procurement.services;

import com.isaac.pethospital.procurement.dtos.ProcurementPurchaseOperationRequest;
import com.isaac.pethospital.procurement.entities.ProcurementEntity;
import com.isaac.pethospital.procurement.entities.ProcurementPurchaseEntity;

import java.util.List;

public interface ProcurementPurchaseService {

    boolean createPurchase(ProcurementPurchaseOperationRequest ppor);

}
