package com.isaac.pethospital.finance.jms;

import com.isaac.pethospital.common.dtos.ChargeItemOperationMesassge;
import com.isaac.pethospital.finance.services.PriceService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ChargeItemEventListener {

    private final PriceService priceService;

    public ChargeItemEventListener(PriceService priceService) {
        this.priceService = priceService;
    }

    @JmsListener(destination = "${jms.finance-charge-item-operation-queue}")
    public void processMessage(ChargeItemOperationMesassge mesassge) throws Exception {
        this.priceService.onChargeItemEventReceived(mesassge);
        //this.procurementService.approvalPassed(procurementId);
    }
}
