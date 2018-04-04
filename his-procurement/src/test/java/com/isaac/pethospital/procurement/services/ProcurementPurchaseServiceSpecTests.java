package com.isaac.pethospital.procurement.services;

import com.isaac.pethospital.common.time.DatetimeGenerator;
import com.isaac.pethospital.procurement.dtos.EmployeeOperationRequest;
import com.isaac.pethospital.procurement.dtos.ProcurementPurchaseOperationRequest;
import com.isaac.pethospital.procurement.entities.ProcurementPurchaseEntity;
import com.isaac.pethospital.procurement.feignservices.EmployeeFeignService;
import com.isaac.pethospital.procurement.repositories.ProcurementPurchaseRepository;
import com.isaac.pethospital.procurement.repositories.ProcurementRequestGoodRepository;
import com.sun.scenario.effect.impl.prism.ps.PPSEffectPeer;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ProcurementPurchaseServiceSpecTests {


    ProcurementPurchaseRepository procurementPurchaseRepository;
    ProcurementPurchaseService procurementPurchaseService;
    ProcurementService procurementService;
    DatetimeGenerator generator;
    ProcurementRequestGoodRepository procurementRequestGoodRepository;
    EmployeeFeignService employeeFeignService;


    @Before
    public void before() {
        this.procurementPurchaseRepository = mock(ProcurementPurchaseRepository.class);
        this.generator = mock(DatetimeGenerator.class);
        this.procurementService = mock(ProcurementService.class);
        this.employeeFeignService = mock(EmployeeFeignService.class);
        this.procurementRequestGoodRepository = mock(ProcurementRequestGoodRepository.class);
        this.procurementPurchaseService = spy(new ProcurementPurchaseServiceImpl(this.procurementPurchaseRepository, this.procurementService, this.generator, this.procurementRequestGoodRepository,this.employeeFeignService));
    }

    @Test
    public void whenSubmitProcurementPurchaseFormThenCreateProcurementPurchase() {
        //given
        ProcurementPurchaseOperationRequest ppor = new ProcurementPurchaseOperationRequest();
        //when
        this.procurementPurchaseService.createPurchase(ppor);
        //then
        verify(this.procurementPurchaseRepository, times(1)).save(any(ProcurementPurchaseEntity.class));
    }

    @Test
    public void whenSubmitProcurementPurchaseFormThenNotifyProcurementService() {
        //given
        ProcurementPurchaseOperationRequest ppor = new ProcurementPurchaseOperationRequest();
        //when
        this.procurementPurchaseService.createPurchase(ppor);
        //then
        verify(this.procurementService, times(1)).purchaseSubmitted(any(Long.class), any(ProcurementPurchaseEntity.class));
    }





}
