package com.isaac.pethospital.medicaltest.services;

import com.isaac.pethospital.common.jms.finance.ChargeOrderStatusChangedMessage;
import com.isaac.pethospital.common.jms.finance.ChargeReportOperationReplyMessage;
import com.isaac.pethospital.common.jms.treatment.GenerateMedicalTestOrderMessage;
import com.isaac.pethospital.medicaltest.dtos.ReportOperationRequest;
import com.isaac.pethospital.medicaltest.entities.ReportEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReportService {
    List<ReportEntity> createReports(ReportOperationRequest request);

    boolean deleteReport(String uuid);


    boolean updateReportStatus(ReportOperationRequest reportOperationRequest);

    boolean updateReport(ReportOperationRequest request);

    List<ReportEntity> findAll();

    ReportEntity findOne(Long rid);

    List<ReportEntity> getReportsByIds(ReportOperationRequest request);

    void onGenerateMedicalTestOrder(GenerateMedicalTestOrderMessage message);

    void onChargeItemEvent(ChargeReportOperationReplyMessage message);

    void onFinanceChargeStatusChanged(ChargeOrderStatusChangedMessage message);

    Page<ReportEntity> findAllOnPage(Pageable pageable);

    ReportEntity findByUuid(String uuid);

    List<ReportEntity> findByPetUuidToday(String uuid);
    List<ReportEntity> findByPetUuidHistory(String uuid);
}
