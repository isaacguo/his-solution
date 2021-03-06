package com.isaac.pethospital.procurement.services;

import com.isaac.pethospital.common.jms.JmsSender;
import com.isaac.pethospital.procurement.dtos.EmployeeOperationRequest;
import com.isaac.pethospital.procurement.dtos.ProcurementApprovalOperationRequest;
import com.isaac.pethospital.procurement.entities.*;
import com.isaac.pethospital.procurement.feignservices.EmployeeFeignService;
import com.isaac.pethospital.procurement.jms.JmsProperties;
import com.isaac.pethospital.procurement.repositories.ProcurementApprovalRepository;
import com.isaac.pethospital.procurement.repositories.ProcurementApprovalStageRepository;
import com.isaac.pethospital.procurement.repositories.ProcurementRepository;
import com.isaac.pethospital.procurement.repositories.ProcurementStatusRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProcurementApprovalServiceImpl implements ProcurementApprovalService {

    private final ProcurementApprovalStageRepository procurementApprovalStageRepository;
    private final EmployeeFeignService employeeFeignService;
    private final ProcurementApprovalRepository procurementApprovalRepository;
    private final ProcurementRepository procurementRepository;
    private final ProcurementStatusService procurementStatusService;
    private final JmsSender jmsSender;
    private final JmsProperties jmsProperties;

    public ProcurementApprovalServiceImpl(ProcurementApprovalStageRepository procurementApprovalStageRepository, EmployeeFeignService employeeFeignService, ProcurementApprovalRepository procurementApprovalRepository, ProcurementRepository procurementRepository, ProcurementStatusService procurementStatusService , JmsSender jmsSender, JmsProperties jmsProperties) {
        this.procurementApprovalStageRepository = procurementApprovalStageRepository;
        this.employeeFeignService = employeeFeignService;
        this.procurementApprovalRepository = procurementApprovalRepository;
        this.procurementRepository = procurementRepository;
        this.procurementStatusService = procurementStatusService;
        this.jmsSender=jmsSender;
        this.jmsProperties=jmsProperties;
    }

    @Override
    public ProcurementApprovalStageEntity getRoot() {
        return this.procurementApprovalStageRepository.findProcurementApprovalEntityByPreviousStageIsNull();
    }

    @Override
    public void procurementCreated(ProcurementEntity procurementEntity) {

        ProcurementApprovalEntity procurementApprovalEntity = new ProcurementApprovalEntity();
        ProcurementApprovalStageEntity rootStage = this.getRoot();
        if (rootStage == null || rootStage.getNextStage() == null)
            throw new RuntimeException("Stage is not defined?");

        procurementApprovalEntity.setStage(rootStage.getNextStage().getStage());
        procurementApprovalEntity.setProcurement(procurementEntity);
        procurementApprovalEntity.setReviewed(false);
        procurementApprovalEntity.setCreatedDateTime(LocalDateTime.now());

        String reviewer = this.employeeFeignService.findDirectReportManagerUserAccount(procurementEntity.getProcurementRequest().getRequester());
        String reviewerFullName=this.employeeFeignService.findUserNameByUserAccount(reviewer).getFullName();
        procurementApprovalEntity.setReviewer(reviewer);
        procurementApprovalEntity.setReviewerFullName(reviewerFullName);

        this.procurementApprovalRepository.save(procurementApprovalEntity);
    }

    @Override
    public List<ProcurementApprovalEntity> findMyUnfinishedApprovals(String userAccount) {
        return this.procurementApprovalRepository.findByReviewerAndReviewedIsFalse(userAccount);
    }

    @Override
    public List<ProcurementEntity> findMyUnfinishedApprovalProcurements(String userAccount) {
        return this.procurementApprovalRepository.findByReviewerAndReviewedIsFalse(userAccount).stream().map(r -> r.getProcurement()).collect(Collectors.toList());
    }

    @Override
    public boolean approvalReceived(ProcurementApprovalOperationRequest request) {

        ProcurementApprovalEntity pae = updateApproval(request);

        changeProcurementStatus(pae);


        ProcurementApprovalStageEntity pase = this.procurementApprovalStageRepository.findByStage(pae.getStage());
        if (request.isReviewResult() && pase.getNextStage() != null) {
            EmployeeOperationRequest employeeOperationRequest = new EmployeeOperationRequest();
            employeeOperationRequest.setSearchByTitle(pase.getNextStage().getStage());

            String userAccount = this.employeeFeignService.findByTitle(employeeOperationRequest);
            String reviewerFullName=this.employeeFeignService.findUserNameByUserAccount(userAccount).getFullName();

            ProcurementApprovalEntity nextPae = new ProcurementApprovalEntity();
            nextPae.setProcurement(pae.getProcurement());
            nextPae.setCreatedDateTime(LocalDateTime.now());
            nextPae.setReviewed(false);
            nextPae.setReviewerFullName(reviewerFullName);
            nextPae.setStage(pase.getNextStage().getStage());
            nextPae.setReviewer(userAccount);

            this.procurementApprovalRepository.save(nextPae);
        } else if (request.isReviewResult() && pase.getNextStage() == null) {
            pae.getProcurement().setStatus(this.procurementStatusService.getNextStatus(pae.getProcurement().getStatus(), true).getStatus());
            this.procurementRepository.save(pae.getProcurement());


            this.jmsSender.sendEvent(this.jmsProperties.getProcurementApprovalPassedTopic(), pae.getProcurement().getId());


        }


        return true;

    }

    @Override
    public Long findMyUnfinishedApprovalProcurementsCount(String userAccount) {
        return this.procurementApprovalRepository.findMyUnfinishedApprovalProcurementsCount(userAccount);
    }


    private ProcurementApprovalEntity updateApproval(ProcurementApprovalOperationRequest request) {
        ProcurementEntity pe = this.procurementRepository.findOne(request.getId());
        ProcurementApprovalEntity pae = this.procurementApprovalRepository.findByProcurementAndReviewer(pe, request.getUserAccount());

        pae.setReviewed(true);
        pae.setReviewedDateTime(LocalDateTime.now());
        pae.setReviewResult(request.isReviewResult());
        pae.setComments(request.getComments());
        this.procurementApprovalRepository.save(pae);
        return pae;
    }

    private void changeProcurementStatus(ProcurementApprovalEntity pae) {
        //change status
        if (pae.getProcurement().getStatus().equals("申请已提交")) {
            ProcurementStatusEntity currentStatus = this.procurementStatusService.findByStatus(pae.getProcurement().getStatus());
            pae.getProcurement().setStatus(currentStatus.getNext().get(0).getStatus());
            this.procurementRepository.save(pae.getProcurement());
        }
    }
}
