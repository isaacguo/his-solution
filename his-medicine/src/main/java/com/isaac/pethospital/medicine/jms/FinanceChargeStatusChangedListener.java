package com.isaac.pethospital.medicine.jms;

import com.isaac.pethospital.common.jms.finance.ChargeOrderStatusChangedMessage;
import com.isaac.pethospital.medicine.services.PharmacyPrescriptionService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class FinanceChargeStatusChangedListener {

    private final PharmacyPrescriptionService pharmacyPrescriptionService;

    public FinanceChargeStatusChangedListener(PharmacyPrescriptionService pharmacyPrescriptionService) {
        this.pharmacyPrescriptionService = pharmacyPrescriptionService;
    }

    @JmsListener(destination = "${jms.finance-charge-status-changed-topic}")
    public void processMessage(ChargeOrderStatusChangedMessage message) throws Exception {
        this.pharmacyPrescriptionService.onFinanceChargeStatusChanged(message);
    }

}
