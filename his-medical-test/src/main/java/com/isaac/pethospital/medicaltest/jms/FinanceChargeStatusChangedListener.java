package com.isaac.pethospital.medicaltest.jms;

import com.isaac.pethospital.common.jms.finance.ChargeOrderStatusChangedMessage;
import com.isaac.pethospital.common.jms.treatment.GenerateMedicalTestOrderMessage;
import com.isaac.pethospital.medicaltest.services.ReportService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class FinanceChargeStatusChangedListener {

    private final ReportService reportService;

    public FinanceChargeStatusChangedListener(ReportService reportService) {
        this.reportService = reportService;
    }

    @JmsListener(destination = "${jms.finance-charge-status-changed-topic}")
    public void processMessage(ChargeOrderStatusChangedMessage message) throws Exception {
        this.reportService.onFinanceChargeStatusChanged(message);
    }

}
