package com.isaac.pethospital.medicaltest.services;

import com.isaac.pethospital.common.jms.JmsProperties;
import com.isaac.pethospital.common.jms.JmsSender;
import com.isaac.pethospital.common.jms.finance.ChargeReportOperationMessage;
import com.isaac.pethospital.common.jms.finance.ChargeReportOperationReplyMessage;
import com.isaac.pethospital.common.jms.finance.ReportOperationMessage;
import com.isaac.pethospital.common.jms.treatment.GenerateMedicalTestOrderMessage;
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
    private final JmsSender jmsSender;
    private final JmsProperties jmsProperties;

    public ReportServiceImpl(ReportRepository reportRepository, JmsSender jmsSender, JmsProperties jmsProperties) {
        this.reportRepository = reportRepository;
        this.jmsSender = jmsSender;
        this.jmsProperties = jmsProperties;
    }

    @Override
    public ReportEntity createReport(ReportOperationRequest request) {
        ReportEntity reportEntity = request.toReport();
        reportEntity.setReportStatus(ReportStatusEnum.UNSUBMITTED);
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
        List<Long> ids = request.getReportIdLists();
        return this.reportRepository.findAll(ids);
    }

    @Override
    public void onGenerateMedicalTestOrder(GenerateMedicalTestOrderMessage message) {

        String treatmentCaseUuid = message.getTreatmentCaseUuid();
        List<ReportEntity> reportList = this.reportRepository.findByTreatmentCaseUuidAndReportStatusEquals(treatmentCaseUuid, ReportStatusEnum.UNSUBMITTED);

        ChargeReportOperationMessage crom = new ChargeReportOperationMessage();
        crom.setTreatmentCaseUuid(treatmentCaseUuid);
        crom.setPetOwnerUuid(message.getPetOwnerUuid());
        crom.setPetUuid(message.getPetUuid());
        reportList.forEach(r -> {
            ReportOperationMessage reportOperationMessage = new ReportOperationMessage();
            reportOperationMessage.setReportUuid(r.getUuid());
            reportOperationMessage.setReportTemplateUuid(r.getReportTemplateUuid());
            crom.addReportOperationMessages(reportOperationMessage);
        });

        jmsSender.sendEvent(jmsProperties.getFinanceChargeItemOperationQueue(), crom);


    }

    @Override
    public void onChargeItemEvent(ChargeReportOperationReplyMessage message) {

        message.getReportUuidList().forEach(r -> {
            ReportEntity re = this.reportRepository.findByUuid(r);
            switch (message.getStatus()) {
                case PAID:
                    break;
                case UNPAID:
                    re.setReportStatus(ReportStatusEnum.UNPAID);
                    break;
                case REIMBURSED:
                    break;
            }
            this.reportRepository.save(re);
        });
    }


}
