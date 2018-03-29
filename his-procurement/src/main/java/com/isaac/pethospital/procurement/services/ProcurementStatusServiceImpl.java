package com.isaac.pethospital.procurement.services;

import com.isaac.pethospital.procurement.entities.ProcurementStatusEntity;
import com.isaac.pethospital.procurement.repositories.ProcurementStatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcurementStatusServiceImpl implements ProcurementStatusService {

    private final ProcurementStatusRepository procurementStatusRepository;

    public ProcurementStatusServiceImpl(ProcurementStatusRepository procurementStatusRepository) {
        this.procurementStatusRepository = procurementStatusRepository;
    }

    public ProcurementStatusEntity getRoot() {
        return procurementStatusRepository.findProcurementStatusEntityByParentIsNull();
    }

    @Override
    public List<ProcurementStatusEntity> findAll() {
        return procurementStatusRepository.findAll();
    }
}
