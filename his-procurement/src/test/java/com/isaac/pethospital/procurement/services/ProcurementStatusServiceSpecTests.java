package com.isaac.pethospital.procurement.services;

import com.isaac.pethospital.procurement.repositories.ProcurementStatusRepository;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
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


}
