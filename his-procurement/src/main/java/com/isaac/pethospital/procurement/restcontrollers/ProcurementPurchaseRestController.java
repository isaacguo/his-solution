package com.isaac.pethospital.procurement.restcontrollers;

import com.isaac.pethospital.procurement.dtos.ProcurementPurchaseOperationRequest;
import com.isaac.pethospital.procurement.services.ProcurementPurchaseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("procurement-purchase")
public class ProcurementPurchaseRestController {

    private final ProcurementPurchaseService procurementPurchaseService;

    public ProcurementPurchaseRestController(ProcurementPurchaseService procurementPurchaseService) {
        this.procurementPurchaseService = procurementPurchaseService;
    }

    @PostMapping("create-purchase")
    public boolean createPurchase(@RequestBody ProcurementPurchaseOperationRequest request)
    {
        return this.procurementPurchaseService.createPurchase(request);
    }
}
