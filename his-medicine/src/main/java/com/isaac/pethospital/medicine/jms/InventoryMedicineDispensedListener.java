package com.isaac.pethospital.medicine.jms;

import com.isaac.pethospital.common.jms.medicine.InventoryPrescriptionDispensedMessage;
import com.isaac.pethospital.medicine.services.PharmacyPrescriptionService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class InventoryMedicineDispensedListener {

    private final PharmacyPrescriptionService pharmacyPrescriptionService;

    public InventoryMedicineDispensedListener(PharmacyPrescriptionService pharmacyPrescriptionService) {
        this.pharmacyPrescriptionService = pharmacyPrescriptionService;
    }

    @JmsListener(destination = "${jms.inventory-prescription-dispensed-topic}")
    public void processMessage(InventoryPrescriptionDispensedMessage message) {
        this.pharmacyPrescriptionService.onInventoryPrescriptionDispensed(message);
    }

}
