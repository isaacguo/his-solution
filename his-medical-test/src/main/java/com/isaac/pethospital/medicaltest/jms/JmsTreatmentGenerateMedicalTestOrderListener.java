package com.isaac.pethospital.medicaltest.jms;

import com.isaac.pethospital.common.dtos.JmsEmployeeOperationRequest;
import com.isaac.pethospital.common.jms.treatment.GenerateMedicalTestOrderMessage;
import com.isaac.pethospital.medicaltest.services.ReportService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JmsTreatmentGenerateMedicalTestOrderListener {

    private final ReportService reportService;

    public JmsTreatmentGenerateMedicalTestOrderListener(ReportService reportService) {
        this.reportService = reportService;
    }

    @JmsListener(destination = "${jms.treatment-generate-medical-test-order-topic}")
    public void processMessage(GenerateMedicalTestOrderMessage message) throws Exception {
        this.reportService.onGenerateMedicalTestOrder(message);
    }

}
