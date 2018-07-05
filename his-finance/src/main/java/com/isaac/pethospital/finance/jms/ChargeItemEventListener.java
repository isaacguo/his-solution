package com.isaac.pethospital.finance.jms;

import com.isaac.pethospital.common.dtos.ChargeItemOperationMesassge;
import com.isaac.pethospital.finance.services.ChargeService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ChargeItemEventListener {

    private final ChargeService chargeService;

    public ChargeItemEventListener(ChargeService chargeService) {
        this.chargeService = chargeService;
    }

    @JmsListener(destination = "${jms.finance-charge-item-operation-queue}")
    public void processMessage(ChargeItemOperationMesassge mesassge) throws Exception {
        this.chargeService.onChargeItemEventReceived(mesassge);
        //this.procurementService.approvalPassed(procurementId);
    }
}
