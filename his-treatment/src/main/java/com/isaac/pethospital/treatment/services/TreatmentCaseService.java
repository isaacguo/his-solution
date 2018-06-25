package com.isaac.pethospital.treatment.services;

import com.isaac.pethospital.treatment.dtos.TreatmentCaseOperationRequest;
import com.isaac.pethospital.treatment.dtos.TreatmentCaseQueryResponse;
import com.isaac.pethospital.treatment.entities.TreatmentCaseEntity;

import java.util.List;

public interface TreatmentCaseService {

    List<TreatmentCaseQueryResponse> findAll(Long pid);

    TreatmentCaseEntity createTreatmentCase(TreatmentCaseOperationRequest request);
}
