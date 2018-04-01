package com.isaac.pethospital.procurement.services;

import com.isaac.pethospital.common.time.DatetimeGenerator;
import com.isaac.pethospital.procurement.dtos.ProcurementOperation;
import com.isaac.pethospital.procurement.entities.ProcurementEntity;
import com.isaac.pethospital.procurement.entities.ProcurementRequestEntity;
import com.isaac.pethospital.procurement.repositories.ProcurementRepository;
import com.isaac.pethospital.procurement.repositories.ProcurementStatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcurementServiceImpl implements ProcurementService {

    private final ProcurementRepository procurementRepository;

    private final DatetimeGenerator datetimeGenerator;
    private final ProcurementConfigurationService procurementConfigurationService;
    private final ProcurementStatusService procurementStatusService;
    private final ProcurementApprovalService procurementApprovalService;

    public ProcurementServiceImpl(ProcurementRepository procurementRepository,
                                  DatetimeGenerator datetimeGenerator,
                                  ProcurementConfigurationService procurementConfigurationService,
                                  ProcurementStatusService procurementStatusService,
                                  ProcurementApprovalService procurementApprovalService) {
        this.procurementRepository = procurementRepository;
        this.datetimeGenerator = datetimeGenerator;
        this.procurementConfigurationService = procurementConfigurationService;
        this.procurementStatusService = procurementStatusService;
        this.procurementApprovalService = procurementApprovalService;
    }

    @Override
    public void requestSubmitted(ProcurementRequestEntity request) {
        ProcurementEntity pe=this.createProcurement(request);
        this.procurementApprovalService.procurementCreated(pe);
    }

    @Override
    public ProcurementEntity createProcurement(ProcurementRequestEntity request) {
        ProcurementEntity pe = new ProcurementEntity();
        pe = this.procurementRepository.save(pe);
        pe.setProcurementRequest(request);
        pe.setStatus(this.procurementStatusService.getRoot().getStatus());
        String orderNumber = this.procurementConfigurationService.getOrderNumber();
        pe.setOrderNumber(orderNumber);

        return this.procurementRepository.save(pe);
    }

    @Override
    public List<ProcurementEntity> findAllMyProcurements(String requester) {
        return this.procurementRepository.findByRequester(requester);
    }
}
