package com.isaac.pethospital.medicaltest.services;

import com.isaac.pethospital.medicaltest.repositories.ReportTemplateRepository;
import com.isaac.pethospital.medicaltest.dtos.ReportOperationRequest;
import com.isaac.pethospital.medicaltest.entities.ReportTemplateEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportTemplateServiceImpl implements ReportTemplateService {

    private final ReportTemplateRepository reportTemplateRepository;

    public ReportTemplateServiceImpl(ReportTemplateRepository reportTemplateRepository) {
        this.reportTemplateRepository = reportTemplateRepository;
    }

    @Override
    public ReportTemplateEntity createReportTemplate(ReportOperationRequest request) {
        ReportTemplateEntity reportTemplateEntity = request.toReport();
        return reportTemplateRepository.save(reportTemplateEntity);
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