package com.isaac.pethospital.finance.jms;

import com.isaac.pethospital.common.jms.finance.ChargeReportOperationMessage;
import com.isaac.pethospital.common.jms.finance.ChargeReportOperationReplyMessage;
import com.isaac.pethospital.common.jms.medicine.PharmacyMedicineDispenseCreateMessage;
import com.isaac.pethospital.common.jms.treatment.PetRegistrationCreatedMessage;
import com.isaac.pethospital.finance.dtos.ChargeOperationRequest;
import com.isaac.pethospital.finance.entities.ChargeEntity;
import com.isaac.pethospital.finance.services.ChargeService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class ChargeItemEventListener {

    private final ChargeService<ChargeEntity, ChargeOperationRequest> chargeService;

    public ChargeItemEventListener(ChargeService<ChargeEntity, ChargeOperationRequest> chargeService) {
        this.chargeService = chargeService;
    }

    @JmsListener(destination = "${jms.finance-charge-item-operation-queue}")
    @SendTo("${jms.finance-charge-item-operation-reply-topic}")
    public ChargeReportOperationReplyMessage processMessage(ChargeReportOperationMessage message) throws Exception {
        return this.chargeService.onGenerateChargeOrderReceived(message);
    }

    @JmsListener(destination = "${jms.pharmacy-medicine-dispense-create-topic}")
    //@SendTo("${jms.finance-charge-item-operation-reply-topic}")
    public void processPharmacyMessage(PharmacyMedicineDispenseCreateMessage message) throws Exception {
        this.chargeService.onPharmacyMedicineDispenseCreateMessageReceived(message);
    }


    @JmsListener(destination = "${jms.finance-pet-registration-created-topic}")
    public void processMessage(PetRegistrationCreatedMessage message) throws Exception {
        this.chargeService.onPetRegistrationMessageReceived(message);
    }


}
