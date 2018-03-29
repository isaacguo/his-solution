package com.isaac.pethospital.procurement.restcontrollers;

import com.isaac.pethospital.common.security.AuthHelper;
import com.isaac.pethospital.procurement.entities.ProcurementStatusEntity;
import com.isaac.pethospital.procurement.services.ProcurementStatusService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("procurement-status")
public class ProcurementStatusRestController {

    private final ProcurementStatusService procurementStatusService;
    private final AuthHelper authHelper;

    public ProcurementStatusRestController(ProcurementStatusService procurementStatusService, AuthHelper authHelper) {
        this.procurementStatusService = procurementStatusService;
        this.authHelper = authHelper;
    }

    @GetMapping("root")
    public ProcurementStatusEntity getRoot()
    {
o       ProcurementStatusEntity procurementStatusEntity= this.procurementStatusService.getRoot();
        List<ProcurementStatusEntity> all=this.procurementStatusService.findAll();
        return procurementStatusEntity;
    }
}
