package com.isaac.pethospital.treatment.jms;

import com.isaac.pethospital.common.jms.finance.ChargeReportOperationMessage;
import com.isaac.pethospital.common.jms.finance.ChargeReportOperationReplyMessage;
import com.isaac.pethospital.treatment.services.TreatmentCaseService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class ChargeItemEventListener {

    private final TreatmentCaseService treatmentCaseService;

    public ChargeItemEventListener(TreatmentCaseService treatmentCaseService) {
        this.treatmentCaseService = treatmentCaseService;
    }

    @JmsListener(destination = "${jms.finance-charge-item-operation-reply-topic}")
    public void processMessage(ChargeReportOperationReplyMessage message) throws Exception {
        this.treatmentCaseService.onChargeItemEvent(message);
    }
}
