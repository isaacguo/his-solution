package com.isaac.pethospital.medicine.jms;

import com.isaac.pethospital.common.jms.treatment.GeneratePharmacyMedicineDispenseOrderMessage;
import com.isaac.pethospital.medicine.services.PharmacyMedicineDispenseService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JmsTreatmentGeneratePharmacyMedicineDispenseOrderListener {

    private final PharmacyMedicineDispenseService pharmacyMedicineDispenseService;

    public JmsTreatmentGeneratePharmacyMedicineDispenseOrderListener(PharmacyMedicineDispenseService pharmacyMedicineDispenseService) {
        this.pharmacyMedicineDispenseService=pharmacyMedicineDispenseService;
    }

    @JmsListener(destination = "${jms.treatment-generate-medicine-dispense-order-topic}")
    public void processMessage(GeneratePharmacyMedicineDispenseOrderMessage message) throws Exception {
        this.pharmacyMedicineDispenseService.onGeneratePharmacyMedicineDispenseOrderMessage(message);
    }

}
