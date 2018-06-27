package com.isaac.pethospital.medicaltest.services;

import com.isaac.pethospital.medicaltest.dtos.ReportTemplateIdAndNameResponse;
import com.isaac.pethospital.medicaltest.entities.ReportTemplateEntity;
import com.isaac.pethospital.medicaltest.repositories.ReportTemplateRepository;
import com.isaac.pethospital.medicaltest.dtos.ReportTemplateOperationRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportTemplateServiceImpl implements ReportTemplateService {

    private final ReportTemplateRepository reportTemplateRepository;

    public ReportTemplateServiceImpl(ReportTemplateRepository reportTemplateRepository) {
        this.reportTemplateRepository = reportTemplateRepository;
    }

    @Override
    public ReportTemplateEntity createReportTemplate(ReportTemplateOperationRequest request) {
        ReportTemplateEntity reportTemplateEntity = request.toReport();
        return reportTemplateRepository.save(reportTemplateEntity);
    }

    @Override
    public ReportTemplateEntity updateReportTemplate(ReportTemplateOperationRequest request) {
        Long id = request.getId();
        if (id == null)
            throw new RuntimeException("Id is null");
        ReportTemplateEntity reportTemplateEntity = reportTemplateRepository.findOne(id);
        if (reportTemplateEntity == null)
            throw new RuntimeException("Cannot find ReportTemplate");
        reportTemplateRepository.delete(reportTemplateEntity);

        return this.createReportTemplate(request);

    }

    @Override
    public List<ReportTemplateEntity> findTemplateByNameContains(String name) {
        return this.reportTemplateRepository.findByReportNameContains(name);
    }

    @Override
    public List<ReportTemplateEntity> findAll() {
        return this.reportTemplateRepository.findAll();
    }

    @Override
    public ReportTemplateEntity findById(Long rid) {
        return this.reportTemplateRepository.findOne(rid);
    }

    @Override
    public boolean deleteById(Long rid) {
        this.reportTemplateRepository.delete(rid);
        return true;
    }

}
