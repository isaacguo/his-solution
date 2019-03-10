package com.isaac.pethospital.treatment.jms;

import com.isaac.pethospital.common.jms.finance.ChargeReportOperationReplyMessage;
import com.isaac.pethospital.treatment.services.TreatmentCaseService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ChargeItemEventReplyListener {

    private final TreatmentCaseService treatmentCaseService;

    public ChargeItemEventReplyListener(TreatmentCaseService treatmentCaseService) {
        this.treatmentCaseService = treatmentCaseService;
    }

    @JmsListener(destination = "${jms.finance-charge-item-operation-reply-topic}")
    public void processMessage(ChargeReportOperationReplyMessage message) throws Exception {
        this.treatmentCaseService.onChargeItemEvent(message);
    }
}
