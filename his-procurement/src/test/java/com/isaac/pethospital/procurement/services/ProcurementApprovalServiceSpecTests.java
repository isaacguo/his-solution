package com.isaac.pethospital.procurement.services;

import com.isaac.pethospital.procurement.entities.ProcurementApprovalEntity;
import com.isaac.pethospital.procurement.entities.ProcurementApprovalStageEntity;
import com.isaac.pethospital.procurement.entities.ProcurementEntity;
import com.isaac.pethospital.procurement.entities.ProcurementRequestEntity;
import com.isaac.pethospital.procurement.feignservices.EmployeeFeignService;
import com.isaac.pethospital.procurement.repositories.ProcurementApprovalRepository;
import com.isaac.pethospital.procurement.repositories.ProcurementApprovalStageRepository;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.Table;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class ProcurementApprovalServiceSpecTests {

    ProcurementApprovalStageRepository procurementApprovalStageRepository;
    ProcurementApprovalService procurementApprovalService;
    ProcurementApprovalRepository procurementApprovalRepository;
    EmployeeFeignService employeeFeignService;

    @Before
    public void before() {
        this.procurementApprovalStageRepository = mock(ProcurementApprovalStageRepository.class);
        this.employeeFeignService = mock(EmployeeFeignService.class);
        this.procurementApprovalRepository=mock(ProcurementApprovalRepository.class);
        this.procurementApprovalService = spy(new ProcurementApprovalServiceImpl(this.procurementApprovalStageRepository, this.employeeFeignService, this.procurementApprovalRepository));
    }

    @Test
    public void whenGetRootThenGetRoot() {
        //given
        //when
        this.procurementApprovalService.getRoot();
        //then
        verify(procurementApprovalStageRepository, times(1)).findProcurementApprovalEntityByPreviousStageIsNull();
    }

    @Test
    public void whenProcurementCreatedThenSecondStageInPipelineIsAssigned() {
        //given
        ProcurementEntity pe = initForProcurementCreated();
        //when
        this.procurementApprovalService.procurementCreated(pe);
        //then
        verify(this.procurementApprovalService, times(1)).getRoot();
    }

    private ProcurementEntity initForProcurementCreated() {
        ProcurementApprovalStageEntity procurementApprovalStageEntity1 = new ProcurementApprovalStageEntity();
        procurementApprovalStageEntity1.setStage("申请人");

        ProcurementApprovalStageEntity procurementApprovalStageEntity2 = new ProcurementApprovalStageEntity();
        procurementApprovalStageEntity2.setStage("部门经理");

        ProcurementApprovalStageEntity procurementApprovalStageEntity3 = new ProcurementApprovalStageEntity();
        procurementApprovalStageEntity3.setStage("总经理");

        procurementApprovalStageEntity1.setNextStage(procurementApprovalStageEntity2);
        procurementApprovalStageEntity2.setNextStage(procurementApprovalStageEntity3);


        doReturn(procurementApprovalStageEntity1).when(this.procurementApprovalService).getRoot();

        ProcurementEntity pe = new ProcurementEntity();
        ProcurementRequestEntity requestEntity = new ProcurementRequestEntity();
        requestEntity.setRequester("Isaac");
        pe.setProcurementRequest(requestEntity);
        return pe;
    }

    @Test
    public void whenProcurementCreatedThenFindDirectManagerOfRequester() {
        //given
        ProcurementEntity pe = initForProcurementCreated();
        //when
        this.procurementApprovalService.procurementCreated(pe);
        //then
        verify(this.employeeFeignService, times(1)).findDirectReportManagerUserAccount(any(String.class));
    }

    @Test
    public void whenProcurementCreatedThenProcurementApprovalIsCreated() {
        //given
        ProcurementEntity pe = initForProcurementCreated();
        //when
        this.procurementApprovalService.procurementCreated(pe);
        //then
        verify(this.procurementApprovalRepository, times(1)).save(any(ProcurementApprovalEntity.class));
    }
    @Test
    public void whenGetUnfinishedApprovalThenFindInRepositoryByUserAccount()
    {
        //given
        //when
        this.procurementApprovalService.findMyUnfinishedApprovals("Isaac");
        //then
        verify(this.procurementApprovalRepository,times(1)).findByReviewerAndReviewedIsFalse("Isaac");
    }
}
