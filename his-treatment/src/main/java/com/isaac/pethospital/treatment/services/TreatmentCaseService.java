package com.isaac.pethospital.treatment.services;

import com.isaac.pethospital.common.jms.finance.ChargeReportOperationMessage;
import com.isaac.pethospital.common.jms.finance.ChargeReportOperationReplyMessage;
import com.isaac.pethospital.common.jms.medicaltest.MedicalTestCreateReportMessage;
import com.isaac.pethospital.common.jms.medicaltest.MedicalTestDeleteReportMessage;
import com.isaac.pethospital.common.jms.medicine.PharmacyMedicineDispenseCreateMessage;
import com.isaac.pethospital.treatment.dtos.OperationResponse;
import com.isaac.pethospital.treatment.dtos.TreatmentCaseOperationRequest;
import com.isaac.pethospital.treatment.dtos.TreatmentCaseQueryResponse;
import com.isaac.pethospital.treatment.entities.PrescriptionEntity;
import com.isaac.pethospital.treatment.entities.TreatmentCaseEntity;

import java.util.List;

public interface TreatmentCaseService {

    List<TreatmentCaseQueryResponse> findAll(Long pid);

    TreatmentCaseEntity createTreatmentCase(TreatmentCaseOperationRequest request);

    OperationResponse deleteOne(Long tid);

    List<PrescriptionEntity> getPrescriptionList(Long tid);

    TreatmentCaseEntity findOne(Long tid);

    TreatmentCaseEntity update(TreatmentCaseOperationRequest request);

    Boolean generateMedicalTestOrder(String uuid);

    void onChargeItemEvent(ChargeReportOperationReplyMessage message);

    void onMedicalTestReportCreated(MedicalTestCreateReportMessage message);

    void onMedicalTestReportRemoved(MedicalTestDeleteReportMessage message);

    void onPharmacyMedicineDispenseCreate(PharmacyMedicineDispenseCreateMessage message);
}
