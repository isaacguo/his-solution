package com.isaac.pethospital.procurement.jms;

import com.isaac.pethospital.procurement.services.ProcurementService;
import com.isaac.pethospital.procurement.services.ProcurementService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ProcurementListener {

    private final ProcurementService procurementService;

    public ProcurementListener(ProcurementService procurementService) {
        this.procurementService = procurementService;
    }

    @JmsListener(destination = "${jms.procurement-approval-passed-topic}")
    public void processMessage(Long procurementId) throws Exception {
        this.procurementService.approvalPassed(procurementId);
    }
}
