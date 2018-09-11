package com.isaac.pethospital.treatment.jms;

import com.isaac.pethospital.common.jms.medicine.PharmacyMedicineDispenseCreateMessage;
import com.isaac.pethospital.treatment.services.TreatmentCaseService;
import org.springframework.jms.annotation.JmsListener;

import javax.transaction.Transactional;

public class PharmacyMedicineDispenseCreateListener {

    private final TreatmentCaseService treatmentCaseService;

    public PharmacyMedicineDispenseCreateListener(TreatmentCaseService treatmentCaseService) {
        this.treatmentCaseService = treatmentCaseService;
    }

    /*
    @JmsListener(destination = "${jms.pharmacy-medicine-dispense-create-topic}")
    public void processMessage(PharmacyMedicineDispenseCreateMessage message) throws Exception {
        this.treatmentCaseService.onPharmacyMedicineDispenseCreate(message);
    }
    */
}
