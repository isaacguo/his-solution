package com.isaac.pethospital.procurement.services;

import com.isaac.pethospital.common.time.DatetimeGenerator;
import com.isaac.pethospital.procurement.dtos.ProcurementOperation;
import com.isaac.pethospital.procurement.entities.ProcurementEntity;
import com.isaac.pethospital.procurement.entities.ProcurementRequestEntity;
import com.isaac.pethospital.procurement.repositories.ProcurementRepository;
import org.springframework.stereotype.Service;

@Service
public class ProcurementServiceImpl implements ProcurementService {

    private final ProcurementRepository procurementRepository;

    private final DatetimeGenerator datetimeGenerator;
    private final ProcurementConfigurationService procurementConfigurationService;
    private final ProcurementStatusService procurementStatusService;

    public ProcurementServiceImpl(ProcurementRepository procurementRepository,
                                  DatetimeGenerator datetimeGenerator,
                                  ProcurementConfigurationService procurementConfigurationService,
                                  ProcurementStatusService procurementStatusService) {
        this.procurementRepository = procurementRepository;
        this.datetimeGenerator = datetimeGenerator;
        this.procurementConfigurationService = procurementConfigurationService;
        this.procurementStatusService = procurementStatusService;
    }

    @Override
    public void requestSubmitted(ProcurementRequestEntity request, Long procurementId) {
        ProcurementEntity pe= this.procurementRepository.findOne(procurementId);
        if(pe==null)
            throw  new RuntimeException("Cannot find Procurement.");
        if(pe.getStatus().getNext().size()!=1)
            throw new RuntimeException("Procurement Next Status has multiple result.");
        pe.setStatus(pe.getStatus().getNext().get(0));
        this.procurementRepository.save(pe);
    }

    @Override
    public ProcurementEntity createProcurement(ProcurementOperation po) {
        ProcurementEntity pe = new ProcurementEntity();
        pe.setStatus(this.procurementStatusService.getRoot());
        String orderNumber = this.procurementConfigurationService.getOrderNumber();
        pe.setOrderNumber(orderNumber);
        return this.procurementRepository.save(pe);
    }
}
