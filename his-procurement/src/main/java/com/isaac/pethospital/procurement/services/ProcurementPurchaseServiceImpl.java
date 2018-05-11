package com.isaac.pethospital.procurement.services;

import com.isaac.pethospital.common.time.DatetimeGenerator;
import com.isaac.pethospital.procurement.dtos.EmployeeOperationRequest;
import com.isaac.pethospital.procurement.dtos.ProcurementPurchaseOperationRequest;
import com.isaac.pethospital.procurement.entities.ProcurementEntity;
import com.isaac.pethospital.procurement.entities.ProcurementPurchaseEntity;
import com.isaac.pethospital.procurement.feignservices.EmployeeFeignService;
import com.isaac.pethospital.procurement.repositories.ProcurementPurchaseRepository;
import com.isaac.pethospital.procurement.repositories.ProcurementRequestGoodRepository;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ProcurementPurchaseServiceImpl implements ProcurementPurchaseService {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    private final ProcurementPurchaseRepository procurementPurchaseRepository;
    private final ProcurementService procurementService;
    private final DatetimeGenerator generator;
    private final ProcurementRequestGoodRepository procurementRequestGoodRepository;
    private final EmployeeFeignService employeeFeignService;

    public ProcurementPurchaseServiceImpl(ProcurementPurchaseRepository procurementPurchaseRepository, ProcurementService procurementService, DatetimeGenerator generator, ProcurementRequestGoodRepository procurementRequestGoodRepository, EmployeeFeignService employeeFeignService) {
        this.procurementPurchaseRepository = procurementPurchaseRepository;
        this.procurementService = procurementService;
        this.generator = generator;
        this.procurementRequestGoodRepository = procurementRequestGoodRepository;
        this.employeeFeignService = employeeFeignService;
    }


    @Override
    public boolean createPurchase(ProcurementPurchaseOperationRequest ppor) {

        ProcurementPurchaseEntity ppe = ppor.toProcurementPurchaseEntity(this.procurementRequestGoodRepository);
        ppe = procurementPurchaseRepository.save(ppe);
        this.procurementService.purchaseSubmitted(ppor.getProcurementId(), ppe);
        return true;
    }



}
