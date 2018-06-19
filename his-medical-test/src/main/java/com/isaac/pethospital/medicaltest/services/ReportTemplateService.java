package com.isaac.pethospital.medicaltest.services;

import com.isaac.pethospital.medicaltest.dtos.ReportTemplateOperationRequest;
import com.isaac.pethospital.medicaltest.entities.ReportTemplateEntity;

import java.util.List;

public interface ReportTemplateService {
    ReportTemplateEntity createReportTemplate(ReportTemplateOperationRequest request);

    List<ReportTemplateEntity> findAll();

    ReportTemplateEntity findById(Long rid);

    boolean deleteById(Long rid);

    ReportTemplateEntity updateReportTemplate(ReportTemplateOperationRequest request);
}
