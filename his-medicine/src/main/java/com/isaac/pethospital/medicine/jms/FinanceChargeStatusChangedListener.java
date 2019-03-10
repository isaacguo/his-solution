package com.isaac.pethospital.medicine.jms;

import com.isaac.pethospital.common.jms.finance.ChargeOrderStatusChangedMessage;
import com.isaac.pethospital.medicine.services.ExportSheetService;
import com.isaac.pethospital.medicine.services.PharmacyPrescriptionService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class FinanceChargeStatusChangedListener {

    private final PharmacyPrescriptionService pharmacyPrescriptionService;
    private final ExportSheetService exportSheetService;

    public FinanceChargeStatusChangedListener(PharmacyPrescriptionService pharmacyPrescriptionService,
                                              ExportSheetService exportSheetService) {
        this.pharmacyPrescriptionService = pharmacyPrescriptionService;
        this.exportSheetService = exportSheetService;
    }


    @JmsListener(destination = "${jms.finance-charge-status-changed-topic}")
    @SendTo("${jms.finance-charge-item-operation-reply-topic}")
    public void processMessage(ChargeOrderStatusChangedMessage message) {
        this.pharmacyPrescriptionService.onFinanceChargeStatusChanged(message);
    }


}
