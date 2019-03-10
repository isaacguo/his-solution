package com.isaac.pethospital.medicaltest.jms;

import com.isaac.pethospital.common.jms.finance.ChargeReportOperationReplyMessage;
import com.isaac.pethospital.medicaltest.services.ReportService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ChargeItemEventReplyListener {

    private final ReportService reportService;

    public ChargeItemEventReplyListener(ReportService reportService) {
        this.reportService = reportService;
    }

    @JmsListener(destination = "${jms.finance-charge-item-operation-reply-topic}")
    public void processMessage(ChargeReportOperationReplyMessage message) throws Exception {
        this.reportService.onChargeItemEvent(message);
    }
}
