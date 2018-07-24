package com.isaac.pethospital.finance.jms;

import com.isaac.pethospital.finance.services.PriceService;
import org.springframework.jms.annotation.JmsListener;
import com.isaac.pethospital.common.jms.finance.PriceItemOperationMessage;
import org.springframework.stereotype.Component;

@Component
public class PriceItemEventListener {

    private final PriceService priceService;

    public PriceItemEventListener(PriceService priceService) {
        this.priceService = priceService;
    }

    @JmsListener(destination = "${jms.finance-price-item-operation-queue}")
    public void processMessage(PriceItemOperationMessage message) throws Exception {
        this.priceService.onPriceItemEventReceived(message);
    }
}
