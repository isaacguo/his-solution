package com.isaac.pethospital.procurement.restcontrollers;

import com.isaac.pethospital.common.security.AuthHelper;
import com.isaac.pethospital.procurement.dtos.ProcurementRequestOperation;
import com.isaac.pethospital.procurement.services.ProcurementRequestService;
import com.isaac.pethospital.procurement.services.ProcurementStatusService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("procurement-request")
public class ProcurementRequestRestController {

    private final ProcurementRequestService procurementRequestService;
    private final AuthHelper authHelper;

    public ProcurementRequestRestController(ProcurementRequestService procurementRequestService, AuthHelper authHelper) {
        this.procurementRequestService = procurementRequestService;
        this.authHelper = authHelper;
    }

    @PostMapping("create")
    public boolean createRequest(@RequestBody ProcurementRequestOperation procurementRequestOperation){
        procurementRequestOperation.setRequester(authHelper.getUserAccount());
        return this.procurementRequestService.createRequest(procurementRequestOperation);
    }
}
