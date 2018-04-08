package com.isaac.pethospital.procurement.restcontrollers;

import com.isaac.pethospital.common.security.AuthHelper;
import com.isaac.pethospital.procurement.dtos.ProcurementOperation;
import com.isaac.pethospital.procurement.entities.ProcurementEntity;
import com.isaac.pethospital.procurement.services.ProcurementService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("procurements")
public class ProcurementRestController {
    private final ProcurementService procurementService;
    private final AuthHelper authHelper;

    public ProcurementRestController(ProcurementService procurementService, AuthHelper authHelper) {
        this.procurementService = procurementService;
        this.authHelper = authHelper;
    }

    @GetMapping("user")
    public List<ProcurementEntity> getAllMyProcurements() {
        String requester = this.authHelper.getUserAccount();
        return this.procurementService.findAllMyProcurements(requester);
    }

    @PostMapping("user/query")
    public List<ProcurementEntity> findByQuery(@RequestBody ProcurementOperation request) {

        return this.procurementService.findByQuery(request);


    }

    @GetMapping("user/purchases")
    public List<ProcurementEntity> findMyProcurementsByPurchaseByAssignee() {
        String assignee = this.authHelper.getUserAccount();
        return this.procurementService.findMyProcurementsByPurchaseByAssignee(assignee);
    }

    @GetMapping("{id}")
    public ProcurementEntity getProcurement(@PathVariable("id") Long id) {
        return this.procurementService.findOne(id);
    }

}
