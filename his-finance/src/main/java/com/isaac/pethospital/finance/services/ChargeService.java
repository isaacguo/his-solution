package com.isaac.pethospital.finance.services;

import com.isaac.pethospital.common.jms.finance.ChargeReportOperationMessage;
import com.isaac.pethospital.common.jms.finance.ChargeReportOperationReplyMessage;
import com.isaac.pethospital.common.jms.medicine.PharmacyPrescriptionCreateMessage;
import com.isaac.pethospital.common.jms.treatment.PetRegistrationCreatedMessage;
import com.isaac.pethospital.common.services.CrudService;
import com.isaac.pethospital.finance.dtos.ChargeOperationRequest;

public interface ChargeService<T,R> extends CrudService<T,R> {

    ChargeReportOperationReplyMessage onGenerateChargeOrderReceived(ChargeReportOperationMessage message);

    boolean updateStatus(Long id, ChargeOperationRequest request);

    void onPharmacyPrescriptionCreateMessageReceived(PharmacyPrescriptionCreateMessage message);
    void onPetRegistrationMessageReceived(PetRegistrationCreatedMessage message);
}
