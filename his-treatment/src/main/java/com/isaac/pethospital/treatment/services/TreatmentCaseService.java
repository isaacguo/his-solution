package com.isaac.pethospital.treatment.services;

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

    boolean addMedicalReportTemplate(Long tId, Long medicalReportTemplateId);
    boolean removeMedicalReportTemplate(Long tid, Long medicalReportTemplateId);

    TreatmentCaseEntity update(TreatmentCaseOperationRequest request);

    Boolean generateMedicalTestOrder(String uuid);
}
