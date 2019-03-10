package com.isaac.pethospital.procurement.services;

import com.isaac.pethospital.procurement.dtos.ProcurementRequestOperation;

public interface ProcurementRequestService {
    boolean createRequest(ProcurementRequestOperation pro);
}
