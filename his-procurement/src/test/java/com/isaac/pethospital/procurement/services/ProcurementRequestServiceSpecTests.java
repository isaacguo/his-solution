package com.isaac.pethospital.procurement.services;

import com.isaac.pethospital.common.time.DatetimeGenerator;
import com.isaac.pethospital.procurement.dtos.ProcurementRequestOperation;
import com.isaac.pethospital.procurement.entities.ProcurementEntity;
import com.isaac.pethospital.procurement.entities.ProcurementRequestEntity;
import com.isaac.pethospital.procurement.repositories.ProcurementRequestRepository;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ProcurementRequestServiceSpecTests {


    ProcurementRequestRepository procurementRequestRepository;
    ProcurementRequestService procurementRequestService;
    ProcurementService procurementService;
    DatetimeGenerator generator;

    @Before
    public void before() {
        this.procurementRequestRepository = mock(ProcurementRequestRepository.class);
        this.generator=mock(DatetimeGenerator.class);
        this.procurementService=mock(ProcurementService.class);
        this.procurementRequestService = spy(new ProcurementRequestServiceImpl(this.procurementRequestRepository,this.generator, this.procurementService));
    }

    @Test
    public void whenSubmitRequestThenSaveIt() {
        //given
        ProcurementRequestOperation pro = initForSubmitRequestMethod();
        //when
        this.procurementRequestService.createRequest(pro);
        //then
        verify(this.procurementRequestRepository, times(1)).save(any(ProcurementRequestEntity.class));
    }

    @Test
    public void whenSubmitRequestThenGenerateSubmittedTime() {
        //given
        ProcurementRequestOperation pro = initForSubmitRequestMethod();
        //when
        this.procurementRequestService.createRequest(pro);
        //then
        verify(this.generator, times(1)).getNowLocalDateTime();
    }

    @Test
    public void whenSubmitRequestThenNotifyProcurementService() {
        //given
        ProcurementRequestOperation pro = initForSubmitRequestMethod();
        //when
        this.procurementRequestService.createRequest(pro);
        //then
        verify(this.procurementService, times(1))
                .requestSubmitted(any(ProcurementRequestEntity.class));
    }

    private ProcurementRequestOperation initForSubmitRequestMethod() {
        ProcurementRequestOperation pro = new ProcurementRequestOperation();
        ProcurementEntity procurementEntity=new ProcurementEntity();
        procurementEntity.setId(2L);
        pro.setProcurement(procurementEntity);
        doReturn(new ProcurementRequestEntity()).when(this.procurementRequestRepository).save(any(ProcurementRequestEntity.class));
        return pro;
    }


}
