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

    @Override
    public ProcurementStatusEntity getNextStatus(String status, boolean result) {
        ProcurementStatusEntity parentStatus = this.procurementStatusRepository.findByStatus(status);
        if (parentStatus == null)
            throw new RuntimeException("Parent Status is null.");
        return this.procurementStatusRepository.findByParentAndLastStatusResult(parentStatus, result);
    }

    @Override
    public ProcurementStatusEntity findByStatus(String status) {
        return this.procurementStatusRepository.findByStatus(status);
    }
}
