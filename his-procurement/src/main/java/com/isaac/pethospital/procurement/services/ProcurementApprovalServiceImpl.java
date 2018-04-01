package com.isaac.pethospital.procurement.services;

import com.isaac.pethospital.procurement.entities.ProcurementApprovalEntity;
import com.isaac.pethospital.procurement.entities.ProcurementApprovalStageEntity;
import com.isaac.pethospital.procurement.entities.ProcurementEntity;
import com.isaac.pethospital.procurement.feignservices.EmployeeFeignService;
import com.isaac.pethospital.procurement.repositories.ProcurementApprovalRepository;
import com.isaac.pethospital.procurement.repositories.ProcurementApprovalStageRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProcurementApprovalServiceImpl implements ProcurementApprovalService {

    private final ProcurementApprovalStageRepository procurementApprovalStageRepository;
    private final EmployeeFeignService employeeFeignService;
    private final ProcurementApprovalRepository procurementApprovalRepository;

    public ProcurementApprovalServiceImpl(ProcurementApprovalStageRepository procurementApprovalStageRepository,
                                          EmployeeFeignService employeeFeignService,
                                          ProcurementApprovalRepository procurementApprovalRepository) {
        this.procurementApprovalStageRepository = procurementApprovalStageRepository;
        this.employeeFeignService = employeeFeignService;
        this.procurementApprovalRepository = procurementApprovalRepository;
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

        String reviewer=this.employeeFeignService.findDirectReportManagerUserAccount(procurementEntity.getProcurementRequest().getRequester());
        procurementApprovalEntity.setReviewer(reviewer);

        this.procurementApprovalRepository.save(procurementApprovalEntity);
    }

    @Override
    public List<ProcurementApprovalEntity> findMyUnfinishedApprovals(String userAccount) {
        return this.procurementApprovalRepository.findByReviewerAndReviewedIsFalse(userAccount);
    }
}
