package com.isaac.pethospital.procurement.services;

import com.isaac.pethospital.common.time.DatetimeGenerator;
import com.isaac.pethospital.procurement.dtos.EmployeeOperationRequest;
import com.isaac.pethospital.procurement.dtos.ProcurementOperation;
import com.isaac.pethospital.procurement.entities.*;
import com.isaac.pethospital.procurement.feignservices.EmployeeFeignService;
import com.isaac.pethospital.procurement.repositories.ProcurementRepository;
import com.isaac.pethospital.procurement.repositories.VendorRepository;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcurementServiceImpl implements ProcurementService {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    private final ProcurementRepository procurementRepository;

    private final DatetimeGenerator datetimeGenerator;
    private final ProcurementConfigurationService procurementConfigurationService;
    private final ProcurementStatusService procurementStatusService;
    private final ProcurementApprovalService procurementApprovalService;
    private final VendorRepository vendorRepository;
    private final EmployeeFeignService employeeFeignService;

    public ProcurementServiceImpl(ProcurementRepository procurementRepository,
                                  DatetimeGenerator datetimeGenerator,
                                  ProcurementConfigurationService procurementConfigurationService,
                                  ProcurementStatusService procurementStatusService,
                                  ProcurementApprovalService procurementApprovalService,
                                  VendorRepository vendorRepository,
                                  EmployeeFeignService employeeFeignService) {
        this.procurementRepository = procurementRepository;
        this.datetimeGenerator = datetimeGenerator;
        this.procurementConfigurationService = procurementConfigurationService;
        this.procurementStatusService = procurementStatusService;
        this.procurementApprovalService = procurementApprovalService;
        this.vendorRepository = vendorRepository;
        this.employeeFeignService=employeeFeignService;
    }

    @Override
    public void requestSubmitted(ProcurementRequestEntity request) {
        ProcurementEntity pe = this.createProcurement(request);
        this.procurementApprovalService.procurementCreated(pe);
    }

    @Override
    public ProcurementEntity createProcurement(ProcurementRequestEntity request) {
        ProcurementEntity pe = new ProcurementEntity();
        pe = this.procurementRepository.save(pe);
        pe.setProcurementRequest(request);
        pe.setStatus(this.procurementStatusService.getRoot().getStatus());
        String orderNumber = this.procurementConfigurationService.getOrderNumber();
        pe.setOrderNumber(orderNumber);

        return this.procurementRepository.save(pe);
    }

    @Override
    public List<ProcurementEntity> findAllMyProcurements(String requester) {
        return this.procurementRepository.findByRequester(requester);
    }

    @Override
    public void purchaseSubmitted(Long procurementId, ProcurementPurchaseEntity purchase) {
        ProcurementEntity pe = this.procurementRepository.findOne(procurementId);
        if (pe == null)
            throw new RuntimeException("Cannot find Procurement by given id:" + procurementId);

        pe.setProcurementPurchase(purchase);
        this.procurementRepository.save(pe);
    }

    @Override
    public boolean changeStatus(ProcurementOperation po) {
        ProcurementEntity pe = this.procurementRepository.findOne(po.getId());
        if(pe==null)
            throw new RuntimeException("Cannot find Procurement by given id:"+po.getId());
        ProcurementStatusEntity statusToBeChangedTo=this.procurementStatusService.findByStatus(po.getStatus());
        if(statusToBeChangedTo==null)
            throw new RuntimeException("Cannot find status entity by given status:" + po.getStatus());

        ProcurementStatusEntity currentStatus=this.procurementStatusService.findByStatus(pe.getStatus());

        pe.setStatus(statusToBeChangedTo.getStatus());

        procurementRepository.save(pe);

        return true;
    }


    @Override
    public void approvalPassed(Long procurementId) {
        this.logger.info("in approvalPassed:" + procurementId);
        ProcurementEntity pe = this.procurementRepository.findOne(procurementId);
        ProcurementPurchaseEntity ppe = new ProcurementPurchaseEntity();

        String assignee = getAssignee();
        ppe.setAssignTo(assignee);
        pe.setProcurementPurchase(ppe);

        this.procurementRepository.save(pe);

    }

    private String getAssignee() {
        EmployeeOperationRequest eor = new EmployeeOperationRequest();
        eor.setSearchByTitle("采购部");
        String userAccount = this.employeeFeignService.findByTitle(eor);
        if (StringUtils.isEmpty(userAccount))
            throw new RuntimeException("Cannot get userAccount");
        return userAccount;
    }

    @Override
    public ProcurementEntity findOne(Long id) {
        return this.procurementRepository.findOne(id);
    }

    @Override
    public List<ProcurementEntity> findMyProcurementsByPurchaseByAssignee(String userAccount) {
        return this.procurementRepository.findMyProcurementByPurchaseByAssignee(userAccount);
    }

}
