package com.isaac.pethospital.treatment.jms;

import com.isaac.pethospital.common.jms.medicaltest.MedicalTestCreateReportMessage;
import com.isaac.pethospital.common.jms.medicaltest.MedicalTestDeleteReportMessage;
import com.isaac.pethospital.treatment.services.TreatmentCaseService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class MedicalTestReportRemoveListener {

    private final TreatmentCaseService treatmentCaseService;

    public MedicalTestReportRemoveListener(TreatmentCaseService treatmentCaseService) {
        this.treatmentCaseService = treatmentCaseService;
    }

    @JmsListener(destination = "${jms.medical-test-removed-report-topic}")
    @Transactional
    public void processMessage(MedicalTestDeleteReportMessage message) throws Exception {
        this.treatmentCaseService.onMedicalTestReportRemoved(message);
    }
}
