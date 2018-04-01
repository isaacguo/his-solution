package com.isaac.pethospital.procurement.services;

import com.isaac.pethospital.procurement.dtos.EmployeeOperationRequest;
import com.isaac.pethospital.procurement.dtos.ProcurementApprovalOperationRequest;
import com.isaac.pethospital.procurement.entities.*;
import com.isaac.pethospital.procurement.feignservices.EmployeeFeignService;
import com.isaac.pethospital.procurement.repositories.ProcurementApprovalRepository;
import com.isaac.pethospital.procurement.repositories.ProcurementApprovalStageRepository;
import com.isaac.pethospital.procurement.repositories.ProcurementRepository;
import com.isaac.pethospital.procurement.repositories.ProcurementStatusRepository;
import com.sun.jmx.remote.protocol.iiop.ProxyInputStream;
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

    ProcurementRepository procurementRepository;
    ProcurementStatusRepository procurementStatusRepository;


    @Before
    public void before() {
        this.procurementApprovalStageRepository = mock(ProcurementApprovalStageRepository.class);
        this.employeeFeignService = mock(EmployeeFeignService.class);
        this.procurementApprovalRepository = mock(ProcurementApprovalRepository.class);
        this.procurementRepository = mock(ProcurementRepository.class);
        this.procurementStatusRepository = mock(ProcurementStatusRepository.class);
        this.procurementApprovalService = spy(new ProcurementApprovalServiceImpl(this.procurementApprovalStageRepository,
                this.employeeFeignService,
                this.procurementApprovalRepository,
                this.procurementRepository,
                this.procurementStatusRepository));
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
    public void whenGetUnfinishedApprovalThenFindInRepositoryByUserAccount() {
        //given
        //when
        this.procurementApprovalService.findMyUnfinishedApprovals("Isaac");
        //then
        verify(this.procurementApprovalRepository, times(1)).findByReviewerAndReviewedIsFalse("Isaac");
    }

    @Test
    public void givenApprovedOperationRequestThenUpdateApprovalEntity() {
        //given
        ProcurementApprovalOperationRequest request = initForAprovalReceived();
        request.setReviewResult(false);
        //when
        this.procurementApprovalService.approvalReceived(request);
        //then
        //verify(this.procurementApprovalStageRepository,times(1)).findByStage(any(String.class));
        verify(this.procurementApprovalRepository, times(1)).save(any(ProcurementApprovalEntity.class));
    }

    @Test
    public void givenApprovedOperationRequestThenUpdateProcurementEntity() {
        //given
        ProcurementApprovalOperationRequest request = initForAprovalReceived();
        //when
        this.procurementApprovalService.approvalReceived(request);
        //then
        //verify(this.procurementApprovalStageRepository,times(1)).findByStage(any(String.class));
        verify(this.procurementStatusRepository).findByStatus(any(String.class));

        verify(this.procurementRepository, times(1)).save(any(ProcurementEntity.class));
    }

    @Test
    public void whenApprovedThenCreateApprovalEntityForNextStage() {
        //given
        ProcurementApprovalOperationRequest request = initForAprovalReceived();
        request.setReviewResult(true);
        //when
        this.procurementApprovalService.approvalReceived(request);
        //then
        verify(this.procurementApprovalStageRepository,times(1)).findByStage(any(String.class));
        verify(this.employeeFeignService,times(1)).findByTitle(any(EmployeeOperationRequest.class));
        verify(this.procurementApprovalRepository,times(2)).save(any(ProcurementApprovalEntity.class));

    }

    private ProcurementApprovalOperationRequest initForAprovalReceived() {
        ProcurementApprovalOperationRequest request = new ProcurementApprovalOperationRequest();
        request.setId(1L);
        ProcurementApprovalEntity pae = new ProcurementApprovalEntity();
        ProcurementEntity pe = new ProcurementEntity();
        pe.setStatus("申请已提交");
        pae.setProcurement(pe);
        doReturn(pe).when(this.procurementRepository).findOne(any(Long.class));
        doReturn(pae).when(this.procurementApprovalRepository).findByProcurementAndReviewer(any(ProcurementEntity.class),any(String.class));
        ProcurementStatusEntity currentStatus = new ProcurementStatusEntity();
        currentStatus.addNext(new ProcurementStatusEntity());
        doReturn(currentStatus).when(this.procurementStatusRepository).findByStatus(any(String.class));
        ProcurementApprovalStageEntity pase=new ProcurementApprovalStageEntity();
        pase.setNextStage(new ProcurementApprovalStageEntity());
        doReturn(pase).when(this.procurementApprovalStageRepository).findByStage(any(String.class));


        return request;
    }

    @Test
    public void whenGetUnfinishedProcurementsThenFindInRepositoryByUserAccount() {
        //given
        //when
        this.procurementApprovalService.findMyUnfinishedApprovalProcurements("Isaac");
        //then
        verify(this.procurementApprovalRepository, times(1)).findByReviewerAndReviewedIsFalse("Isaac");
    }
}
