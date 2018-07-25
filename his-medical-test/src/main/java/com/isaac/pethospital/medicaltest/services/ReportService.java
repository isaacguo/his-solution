package com.isaac.pethospital.medicaltest.services;

import com.isaac.pethospital.common.jms.finance.ChargeReportOperationReplyMessage;
import com.isaac.pethospital.common.jms.treatment.GenerateMedicalTestOrderMessage;
import com.isaac.pethospital.medicaltest.dtos.ReportOperationRequest;
import com.isaac.pethospital.medicaltest.entities.ReportEntity;

import java.util.List;

public interface ReportService {
    ReportEntity createReport(ReportOperationRequest request);


    boolean updateReportStatus(ReportOperationRequest reportOperationRequest);

    boolean updateReport(ReportOperationRequest request);

    List<ReportEntity> findAll();

    ReportEntity findOne(Long rid);

    List<ReportEntity> getReportsByIds(ReportOperationRequest request);

    void onGenerateMedicalTestOrder(GenerateMedicalTestOrderMessage message);

    void onChargeItemEvent(ChargeReportOperationReplyMessage message);
}
