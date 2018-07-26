package com.isaac.pethospital.treatment.dtos;

import java.time.LocalDateTime;
import java.util.List;

public interface TreatmentCaseQueryResponse {


    LocalDateTime getTreatmentDate();

    LocalDateTime getCreatedDate();

    LocalDateTime getLastModifiedDateTime();

    String getDoctor();
    String getClinicSituation();


    String getPetOwnerDescription();
    String getDoctorDiagnose();
    String getDoctorAdvice();


    //List<Long> getMedicalTestReportUuidList();

    Long getId();
}
