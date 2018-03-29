package com.isaac.pethospital.procurement.services;

import com.isaac.pethospital.procurement.entities.ProcurementStatusEntity;

import java.util.List;

public interface ProcurementStatusService {

    ProcurementStatusEntity getRoot();

    List<ProcurementStatusEntity> findAll();
}
