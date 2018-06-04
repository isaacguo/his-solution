package com.isaac.pethospital.medicaltest.services;

import com.isaac.pethospital.medicaltest.dtos.ReportOperationRequest;
import com.isaac.pethospital.medicaltest.entities.ReportTemplateEntity;

import java.util.List;

public interface ReportTemplateService {
    ReportTemplateEntity createReportTemplate(ReportOperationRequest request);

    List<ReportTemplateEntity> findAll();

    ReportTemplateEntity findById(Long rid);

    boolean deleteById(Long rid);
}
