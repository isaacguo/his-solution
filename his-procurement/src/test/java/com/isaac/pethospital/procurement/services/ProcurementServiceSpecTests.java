package com.isaac.pethospital.procurement.services;

import com.isaac.pethospital.common.time.DatetimeGenerator;
import com.isaac.pethospital.procurement.dtos.ProcurementOperation;
import com.isaac.pethospital.procurement.entities.ProcurementEntity;
import com.isaac.pethospital.procurement.entities.ProcurementRequestEntity;
import com.isaac.pethospital.procurement.entities.ProcurementStatusEntity;
import com.isaac.pethospital.procurement.repositories.ProcurementRepository;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.processing.ProcessingEnvironment;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class ProcurementServiceSpecTests {

    ProcurementRepository procurementRepository;
    ProcurementService procurementService;
    ProcurementConfigurationService procurementConfigurationService;
    DatetimeGenerator generator;
    ProcurementStatusService procurementStatusService;

    @Before
    public void before() {
        this.procurementRepository = mock(ProcurementRepository.class);
        this.procurementConfigurationService=mock(ProcurementConfigurationService.class);
        this.procurementStatusService=mock(ProcurementStatusService.class);
        this.generator=mock(DatetimeGenerator.class);
        this.procurementService = spy(new ProcurementServiceImpl(this.procurementRepository,this.generator, this.procurementConfigurationService,this.procurementStatusService));
    }

    @Test
    public void whenCreateProcurementThenCreateOne()
    {
        //given
        ProcurementOperation po = new ProcurementOperation();
        //when
        this.procurementService.createProcurement(po);
        //then
        verify(this.procurementRepository, times(1)).save(any(ProcurementEntity.class));
    }

    @Test
    public void whenCreateProcurementThenOrderNumberIsAssigned()
    {
        //given
        ProcurementOperation po = new ProcurementOperation();
        //when
        this.procurementService.createProcurement(po);
        //then
        verify(this.procurementConfigurationService,times(1)).getOrderNumber();
        verify(this.procurementRepository, times(1)).save(any(ProcurementEntity.class));
    }

    @Test
    public void whenCreateProcurementThenStatusIsSetToRootStatus()
    {
        //given
        ProcurementOperation po = new ProcurementOperation();
        //when
        ProcurementEntity pe=this.procurementService.createProcurement(po);
        //then
        verify(this.procurementStatusService,times(1)).getRoot();
    }

    @Test
    public void whenNotifiedThenChangeStatus()
    {
        //given
        ProcurementRequestEntity pre=new ProcurementRequestEntity();
        ProcurementEntity pe=new ProcurementEntity();
        ProcurementStatusEntity pse1=new ProcurementStatusEntity();
        ProcurementStatusEntity pse2=new ProcurementStatusEntity();
        pse1.addNext(pse2);

        pe.setStatus(pse1);
        doReturn(pe).when(this.procurementRepository).findOne(1L);
        //when
        this.procurementService.requestSubmitted(pre,1L);
        //then
        verify(this.procurementRepository,times(1)).save(any(ProcurementEntity.class));
    }

}
