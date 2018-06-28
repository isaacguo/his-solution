package com.isaac.pethospital.medicaltest.services;

import com.isaac.pethospital.medicaltest.dtos.ReportOperationRequest;
import com.isaac.pethospital.medicaltest.entities.ReportEntity;
import com.isaac.pethospital.medicaltest.enums.ReportStatusEnum;
import com.isaac.pethospital.medicaltest.repositories.ReportRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
        reportEntity.setReportStatus(ReportStatusEnum.CREATED);
        reportEntity.setCreatedDateTime(LocalDateTime.now());

        return this.reportRepository.save(reportEntity);

    }

    @Override
    public boolean updateReportStatus(ReportOperationRequest request) {
        ReportEntity reportEntity = getReportById(request);
        reportEntity.setReportStatus(request.getReportStatus());
        this.reportRepository.save(reportEntity);
        return false;
    }

    private ReportEntity getReportById(ReportOperationRequest request) {
        if (request.getId() == null)
            throw new RuntimeException("Report Id is null");
        ReportEntity reportEntity = this.reportRepository.findOne(request.getId());
        if (reportEntity == null)
            throw new RuntimeException("Cannot find Report");

        return reportEntity;
    }

    @Override
    public boolean updateReport(ReportOperationRequest request) {

        ReportEntity reportEntity = getReportById(request);
        reportEntity.setReportStatus(ReportStatusEnum.FINISHED);
        request.updateReport(reportEntity);
        this.reportRepository.save(reportEntity);
        return true;
    }

    @Override
    public List<ReportEntity> findAll() {
        return this.reportRepository.findAll();
    }

    @Override
    public ReportEntity findOne(Long rid) {
        return this.reportRepository.findOne(rid);
    }

    @Override
    public List<ReportEntity> getReportsByIds(ReportOperationRequest request) {
        List<Long> ids=request.getReportIdLists();
        return this.reportRepository.findAll(ids);
    }
}
