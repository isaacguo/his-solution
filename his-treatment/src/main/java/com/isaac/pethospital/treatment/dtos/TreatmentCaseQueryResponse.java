package com.isaac.pethospital.treatment.dtos;

import java.time.LocalDateTime;
import java.util.List;

public interface TreatmentCaseQueryResponse {


    LocalDateTime getTreatmentDate();

    LocalDateTime getCreatedDate();

    LocalDateTime getLastModifiedDateTime();

    String getDoctor();

    List<Long> getMedicalTestReportIdList();

    Long getId();
}
