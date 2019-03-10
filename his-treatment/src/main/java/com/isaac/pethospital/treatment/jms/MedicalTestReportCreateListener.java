package com.isaac.pethospital.treatment.jms;

import com.isaac.pethospital.common.jms.finance.ChargeReportOperationReplyMessage;
import com.isaac.pethospital.common.jms.medicaltest.MedicalTestCreateReportMessage;
import com.isaac.pethospital.treatment.services.TreatmentCaseService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class MedicalTestReportCreateListener {

    private final TreatmentCaseService treatmentCaseService;

    public MedicalTestReportCreateListener(TreatmentCaseService treatmentCaseService) {
        this.treatmentCaseService = treatmentCaseService;
    }

    @JmsListener(destination = "${jms.medical-test-create-report-topic}")
    @Transactional
    public void processMessage(MedicalTestCreateReportMessage message) throws Exception {
        this.treatmentCaseService.onMedicalTestReportCreated(message);
    }
}
