package com.isaac.pethospital.medicaltest.repositories;


import com.isaac.pethospital.medicaltest.entities.ReportEntity;
import com.isaac.pethospital.medicaltest.enums.ReportStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReportRepository extends JpaRepository<ReportEntity, Long> {
    ReportEntity findByUuid(String uuid);
    List<ReportEntity> findByTreatmentCaseUuidAndReportStatusEquals(String treatmentCaseUuid, ReportStatusEnum status);
}
