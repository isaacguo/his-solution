package com.isaac.pethospital.medicaltest.services;

import com.isaac.pethospital.medicaltest.dtos.ReportTemplateOperationRequest;
import com.isaac.pethospital.medicaltest.entities.ReportTemplateEntity;

import java.util.List;

public interface ReportTemplateService {
    ReportTemplateEntity createReportTemplate(ReportTemplateOperationRequest request);

    List<ReportTemplateEntity> findAll();

    List<ReportTemplateEntity> findReportTemplatesByDepartmentId(Long dId);
    List<ReportTemplateEntity> findReportTemplatesByCategoryId(Long cId);

    ReportTemplateEntity findById(Long rid);

    boolean deleteById(Long rid);

    ReportTemplateEntity updateReportTemplate(ReportTemplateOperationRequest request);

    List<ReportTemplateEntity> findTemplateByNameContains(String name);
}
