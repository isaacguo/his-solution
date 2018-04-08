package com.isaac.pethospital.procurement.services;

import com.isaac.pethospital.common.time.DatetimeGenerator;
import com.isaac.pethospital.procurement.dtos.EmployeeOperationRequest;
import com.isaac.pethospital.procurement.dtos.ProcurementOperation;
import com.isaac.pethospital.procurement.entities.*;
import com.isaac.pethospital.procurement.feignservices.EmployeeFeignService;
import com.isaac.pethospital.procurement.repositories.ProcurementRepository;
import com.isaac.pethospital.procurement.repositories.VendorRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class ProcurementServiceSpecTests {

    ProcurementRepository procurementRepository;
    ProcurementService procurementService;
    ProcurementConfigurationService procurementConfigurationService;
    DatetimeGenerator generator;
    ProcurementStatusService procurementStatusService;
    ProcurementApprovalService procurementApprovalService;
    VendorRepository vendorRepository;
    EmployeeFeignService employeeFeignService;
    EntityManager entityManager;


    @Before
    public void before() {
        this.procurementRepository = mock(ProcurementRepository.class);
        this.procurementConfigurationService = mock(ProcurementConfigurationService.class);
        this.procurementStatusService = mock(ProcurementStatusService.class);
        this.procurementApprovalService = mock(ProcurementApprovalService.class);
        this.vendorRepository=mock(VendorRepository.class);
        this.employeeFeignService=mock(EmployeeFeignService.class);
        this.entityManager=mock(EntityManager.class);
        this.generator = mock(DatetimeGenerator.class);

        this.procurementService = spy(new ProcurementServiceImpl(this.procurementRepository,
                this.generator,
                this.procurementConfigurationService,
                this.procurementStatusService,
                this.procurementApprovalService,
                this.vendorRepository,
                this.employeeFeignService,
                this.entityManager));
    }

    @Test
    public void whenCreateProcurementThenCreateOne() {
        //given
        ProcurementOperation po = new ProcurementOperation();
        doReturn(new ProcurementEntity()).when(this.procurementRepository).save(any(ProcurementEntity.class));
        doReturn(new ProcurementStatusEntity()).when(this.procurementStatusService).getRoot();
        //when
        this.procurementService.createProcurement(new ProcurementRequestEntity());
        //then
        verify(this.procurementRepository, times(2)).save(any(ProcurementEntity.class));
    }

    @Test
    public void whenCreateProcurementThenOrderNumberIsAssigned() {
        //given
        ProcurementOperation po = new ProcurementOperation();
        doReturn(new ProcurementEntity()).when(this.procurementRepository).save(any(ProcurementEntity.class));
        doReturn(new ProcurementStatusEntity()).when(this.procurementStatusService).getRoot();
        //when
        this.procurementService.createProcurement(new ProcurementRequestEntity());
        //then
        verify(this.procurementConfigurationService, times(1)).getOrderNumber();
        verify(this.procurementRepository, times(2)).save(any(ProcurementEntity.class));
    }

    @Test
    public void whenCreateProcurementThenStatusIsSetToRootStatus() {
        //given
        ProcurementOperation po = new ProcurementOperation();
        doReturn(new ProcurementEntity()).when(this.procurementRepository).save(any(ProcurementEntity.class));
        doReturn(new ProcurementStatusEntity()).when(this.procurementStatusService).getRoot();
        //when
        ProcurementEntity pe = this.procurementService.createProcurement(new ProcurementRequestEntity());
        //then
        verify(this.procurementStatusService, times(1)).getRoot();
    }

    @Test
    public void whenGetNotifiedThenCreateProcurement() {
        ProcurementRequestEntity pre = initForRequestSubmitted();

        //when
        this.procurementService.requestSubmitted(pre);
        //then
        verify(this.procurementRepository, times(2)).save(any(ProcurementEntity.class));
    }

    private ProcurementRequestEntity initForRequestSubmitted() {
        //given
        ProcurementRequestEntity pre = new ProcurementRequestEntity();
        ProcurementEntity pe = new ProcurementEntity();
        ProcurementStatusEntity pse1 = new ProcurementStatusEntity();
        ProcurementStatusEntity pse2 = new ProcurementStatusEntity();
        pse1.addNext(pse2);

        pe.setStatus(pse1.getStatus());
        doReturn(pe).when(this.procurementRepository).findOne(1L);
        doReturn(new ProcurementEntity()).when(this.procurementRepository).save(any(ProcurementEntity.class));
        doReturn(new ProcurementStatusEntity()).when(this.procurementStatusService).getRoot();
        return pre;
    }

    @Test
    public void whenFindAllMyProcurementsThenFindThemByRequesterInRepository() {
        //when
        this.procurementService.findAllMyProcurements("Isaac");
        //then
        verify(this.procurementRepository, times(1)).findByRequester("Isaac");
    }

    @Test
    public void whenCreateProcurementThenNotifyProcurementApprovalService() {
        //when
        ProcurementRequestEntity pre = initForRequestSubmitted();
        this.procurementService.requestSubmitted(pre);
        //then
        this.procurementApprovalService.procurementCreated(any(ProcurementEntity.class));
    }

    @Test
    public void whenPurchaseSubmittedThenAssociateItWithProcurement()
    {
        //given
        ProcurementPurchaseEntity ppe=new ProcurementPurchaseEntity();
        doReturn(new ProcurementEntity()).when(this.procurementRepository).findOne(1L);
        //when
        this.procurementService.purchaseSubmitted(1L,ppe);
        //then
        verify(this.procurementRepository,times(1)).findOne(1L);
    }
    @Test
    public void whenChangeStatusThenChangeIt()
    {
        //given
        ProcurementOperation po=new ProcurementOperation();
        po.setStatus("ABC");
        po.setId(1L);
        doReturn(new ProcurementStatusEntity()).when(this.procurementStatusService).findByStatus(any(String.class));
        doReturn(new ProcurementEntity()).when(this.procurementRepository).findOne(1L);
        //when
        this.procurementService.changeStatus(po);
        //then
        verify(this.procurementStatusService,times(2)).findByStatus(any(String.class));
        verify(this.procurementRepository,times(1)).findOne(1L);
    }

    @Test
    public void whenFindMyProcurementByPurchaseThenFindMyProcurementByPurchaseByAssignee()
    {
        //when
        this.procurementService.findMyProcurementsByPurchaseByAssignee("Isaac");
        //then
        verify(this.procurementRepository, Mockito.times(1)).findMyProcurementByPurchaseByAssignee(any(String.class));

    }


    @Test
    public void whenApprovalPassedThenAssociateProcurementPurchaseEntityToProcurementEntity() {
        //given
        initForApprovalPassed();
        //when
        this.procurementService.approvalPassed(1L);
        //then
        verify(this.procurementRepository, Mockito.times(1)).findOne(1L);
        verify(this.procurementRepository, Mockito.times(1)).save(any(ProcurementEntity.class));
    }

    private void initForApprovalPassed() {
        doReturn("ABC").when(this.employeeFeignService).findByTitle(any(EmployeeOperationRequest.class));
        doReturn(new ProcurementEntity()).when(this.procurementRepository).findOne(any(Long.class));
    }

    @Test
    public void whenApprovalPassedThenFindAssigneeByUsingEmployeeFeignClient() {
        //given
        initForApprovalPassed();
        //when
        this.procurementService.approvalPassed(1L);
        //then
        verify(this.employeeFeignService,times(1)).findByTitle(any(EmployeeOperationRequest.class));
    }


    /*
    @Test
    public void whenAddingVendorInfoThenInformationIsAdded() {
        //given
        ProcurementOperation po = initForAddingVendor(new ProcurementEntity());
        //when
        ProcurementEntity pe = this.procurementService.addVendorInfo(po);
        //then
        verify(this.procurementRepository).findOne(any(Long.class));
        verify(this.vendorRepository).findOne(any(Long.class));
        verify(this.procurementRepository).save(any(ProcurementEntity.class));
    }

    @Test
    public void whenAddingVendorInfoThenProcurementStatusIsAdded()
    {
        //given
        ProcurementEntity pe=new ProcurementEntity();
        pe.setStatus("申请已通过");
        ProcurementOperation po = initForAddingVendor(pe);

        //when
        this.procurementService.addVendorInfo(po);
        //then
        verify(this.procurementStatusService,times(1)).getNextStatus(any(String.class),any(Boolean.class));
    }

    private ProcurementOperation initForAddingVendor(ProcurementEntity pe) {
        ProcurementOperation po = new ProcurementOperation();
        po.setId(1L);
        po.setContactId(2L);
        po.setVendorId(3L);

        VendorEntity ve=new VendorEntity();
        ve.setId(3L);
        ve.setName("Company");
        ContactEntity ce=new ContactEntity();
        ce.setId(2L);
        ce.setName("Isaac");
        ve.addContact(ce);

        ProcurementStatusEntity pse=new ProcurementStatusEntity();
        pse.setStatus("申请已通过");
        ProcurementStatusEntity pse1=new ProcurementStatusEntity();
        pse1.setStatus("OK");
        pse1.setLastStatusResult(true);
        pse.addNext(pse1);

        doReturn(pse1).when(this.procurementStatusService).getNextStatus(any(String.class),any(Boolean.class));
        doReturn(pe).when(this.procurementRepository).findOne(any(Long.class));
        doReturn(ve).when(this.vendorRepository).findOne(any(Long.class));
        return po;
    }
    */
}
