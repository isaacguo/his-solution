package com.isaac.pethospital.procurement.services;

import com.isaac.pethospital.common.time.DatetimeGenerator;
import com.isaac.pethospital.procurement.dtos.ProcurementPurchaseOperationRequest;
import com.isaac.pethospital.procurement.entities.ProcurementPurchaseEntity;
import com.isaac.pethospital.procurement.entities.ProcurementPurchaseGoodEntity;
import com.isaac.pethospital.procurement.repositories.ProcurementPurchaseRepository;
import com.isaac.pethospital.procurement.repositories.ProcurementRequestGoodRepository;
import org.springframework.stereotype.Service;

@Service
public class ProcurementPurchaseServiceImpl implements ProcurementPurchaseService {

    private final ProcurementPurchaseRepository procurementPurchaseRepository;
    private final ProcurementService procurementService;
    private final DatetimeGenerator generator;
    private final ProcurementRequestGoodRepository procurementRequestGoodRepository;

    public ProcurementPurchaseServiceImpl(ProcurementPurchaseRepository procurementPurchaseRepository, ProcurementService procurementService, DatetimeGenerator generator, ProcurementRequestGoodRepository procurementRequestGoodRepository) {
        this.procurementPurchaseRepository = procurementPurchaseRepository;
        this.procurementService = procurementService;
        this.generator = generator;
        this.procurementRequestGoodRepository = procurementRequestGoodRepository;
    }


    @Override
    public boolean createPurchase(ProcurementPurchaseOperationRequest ppor) {

        ProcurementPurchaseEntity ppe = ppor.toProcurementPurchaseEntity(this.procurementRequestGoodRepository);
        ppe = procurementPurchaseRepository.save(ppe);
        this.procurementService.purchaseSubmitted(ppor.getPurchaseId(),ppe);
        return true;
    }

}
