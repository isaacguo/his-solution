package com.isaac.pethospital.procurement.restcontrollers;

import com.isaac.pethospital.common.security.AuthHelper;
import com.isaac.pethospital.procurement.dtos.ProcurementApprovalOperationRequest;
import com.isaac.pethospital.procurement.entities.ProcurementApprovalEntity;
import com.isaac.pethospital.procurement.entities.ProcurementApprovalStageEntity;
import com.isaac.pethospital.procurement.entities.ProcurementEntity;
import com.isaac.pethospital.procurement.services.ProcurementApprovalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("procurement-approval")
public class ProcurementApprovalRestController {

    private final ProcurementApprovalService procurementApprovalService;
    private final AuthHelper authHelper;

    public ProcurementApprovalRestController(ProcurementApprovalService procurementApprovalService, AuthHelper authHelper) {
        this.procurementApprovalService = procurementApprovalService;
        this.authHelper = authHelper;
    }

    @GetMapping
    public ProcurementApprovalStageEntity getRoot() {
        return this.procurementApprovalService.getRoot();
    }

    @GetMapping("approvals")
    public List<ProcurementEntity> findMyUnfinishedApprovals() {
        String userAccount = authHelper.getUserAccount();
        return this.procurementApprovalService.findMyUnfinishedApprovalProcurements(userAccount);
    }

    @GetMapping("count")
    public Long findMyUnfinishedApprovalsCount() {
        String userAccount = authHelper.getUserAccount();
        return this.procurementApprovalService.findMyUnfinishedApprovalProcurementsCount(userAccount);
    }

    @PostMapping("update")
    public boolean updateApproval(@RequestBody ProcurementApprovalOperationRequest request) {
        String userAccount = authHelper.getUserAccount();
        request.setUserAccount(userAccount);
        return this.procurementApprovalService.approvalReceived(request);
    }

}
