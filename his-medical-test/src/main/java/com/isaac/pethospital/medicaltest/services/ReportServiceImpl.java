package com.isaac.pethospital.medicaltest.services;

import com.isaac.pethospital.common.jms.JmsProperties;
import com.isaac.pethospital.common.jms.JmsSender;
import com.isaac.pethospital.common.jms.finance.ChargeOrderStatusChangedMessage;
import com.isaac.pethospital.common.jms.finance.ChargeReportOperationMessage;
import com.isaac.pethospital.common.jms.finance.ChargeReportOperationReplyMessage;
import com.isaac.pethospital.common.jms.finance.ReportOperationMessage;
import com.isaac.pethospital.common.jms.medicaltest.MedicalTestCreateReportMessage;
import com.isaac.pethospital.common.jms.medicaltest.MedicalTestDeleteReportMessage;
import com.isaac.pethospital.common.jms.treatment.GenerateMedicalTestOrderMessage;
import com.isaac.pethospital.medicaltest.dtos.ReportOperationRequest;
import com.isaac.pethospital.medicaltest.entities.ReportEntity;
import com.isaac.pethospital.medicaltest.enums.ReportStatusEnum;
import com.isaac.pethospital.medicaltest.repositories.ReportRepository;
import org.apache.commons.lang.StringUtils;
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

        ReportEntity saved = this.reportRepository.save(reportEntity);

        MedicalTestCreateReportMessage message = new MedicalTestCreateReportMessage();
        message.setReportUuid(reportEntity.getUuid());
        message.setTreatmentCaseUuid(reportEntity.getTreatmentCaseUuid());
        jmsSender.sendEvent(this.jmsProperties.getMedicalTestCreateReportTopic(), message);

        return saved;
    }

    @Override
    public boolean deleteReport(String uuid) {

        ReportEntity report = this.reportRepository.findByUuid(uuid);
        String treatmentCaseUuid = report.getTreatmentCaseUuid();
        if (StringUtils.isEmpty(treatmentCaseUuid))
            throw new RuntimeException("The Report to be deleted cannot be found");
        this.reportRepository.delete(report);

        MedicalTestDeleteReportMessage message = new MedicalTestDeleteReportMessage();
        message.setTreatmentCaseUuid(treatmentCaseUuid);
        message.setReportUuid(uuid);
        jmsSender.sendEvent(this.jmsProperties.getMedicalTestRemovedReportTopic(), message);

        return true;
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
        List<String> uuids = request.getReportUuidLists();
        return this.reportRepository.findByUuidIn(uuids);
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

    @Override
    public void onFinanceChargeStatusChanged(ChargeOrderStatusChangedMessage message) {

        List<ReportEntity> reports=this.reportRepository.findByUuidIn(message.getChargeItemUuid());

        switch (message.getNewStatus()) {
            case PAID:
                reports.stream().forEach(r->r.setReportStatus(ReportStatusEnum.PAID));
                this.reportRepository.save(reports);
                break;
            case UNPAID:
                break;
            case REIMBURSED:
                break;
        }

    }


}
