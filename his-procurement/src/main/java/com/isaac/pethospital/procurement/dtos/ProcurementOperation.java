package com.isaac.pethospital.procurement.dtos;

import com.isaac.pethospital.procurement.entities.OperatorEntity;
import com.isaac.pethospital.procurement.entities.ProcurementEntity;
import com.isaac.pethospital.procurement.entities.ProcurementStatusEntity;
import com.isaac.pethospital.procurement.entities.VendorEntity;


public class ProcurementOperation {

    Long orderNumber; //单号
    VendorEntity vendor;
    OperatorEntity operator;
    private Long id;

    ProcurementStatusEntity status;

    public ProcurementEntity toProcurementEntity() {
        return  null;
    }
}
