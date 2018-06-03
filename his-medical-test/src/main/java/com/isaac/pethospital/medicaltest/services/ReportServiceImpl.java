package com.isaac.pethospital.medicaltest.services;

import com.isaac.pethospital.medicaltest.repositories.ReportRepository;
import com.isaac.pethospital.medicaltest.dtos.ReportOperationRequest;
import com.isaac.pethospital.medicaltest.entities.ReportEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;

    public ReportServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public ReportEntity createReport(ReportOperationRequest request) {
        ReportEntity reportEntity = request.toReport();
        return reportRepository.save(reportEntity);
    }

    @Override
    public List<ReportEntity> findAll() {
        return this.reportRepository.findAll();
    }

    @Override
    public ReportEntity findById(Long rid) {
        return this.reportRepository.findOne(rid);
    }

    @Override
    public boolean deleteById(Long rid) {
        this.reportRepository.delete(rid);
        return true;
    }
}
