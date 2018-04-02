package com.isaac.pethospital.procurement.services;

import com.isaac.pethospital.procurement.entities.ProcurementStatusEntity;
import com.isaac.pethospital.procurement.repositories.ProcurementStatusRepository;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class ProcurementStatusServiceSpecTests {


    ProcurementStatusRepository procurementStatusRepository;
    ProcurementStatusService procurementStatusService;

    @Before
    public void before() {
        this.procurementStatusRepository = mock(ProcurementStatusRepository.class);
        this.procurementStatusService = spy(new ProcurementStatusServiceImpl(this.procurementStatusRepository));
    }

    @Test
    public void whenGetRootThenGetRoot() {
        //given
        //when
        this.procurementStatusService.getRoot();
        //then
        verify( procurementStatusRepository, times(1)).findProcurementStatusEntityByParentIsNull();
    }

    @Test
    public void givenStatusAndStatusResultWhenGetNextThenReturnStatusEntity()
    {
        //given
        ProcurementStatusEntity parentStatus = new ProcurementStatusEntity();
        doReturn(parentStatus).when(this.procurementStatusRepository).findByStatus(any(String.class));

        //when
        this.procurementStatusService.getNextStatus("A",true);
        //
        verify(procurementStatusRepository,times(1)).findByParentAndLastStatusResult(any(ProcurementStatusEntity.class),any(Boolean.class));

    }


}
