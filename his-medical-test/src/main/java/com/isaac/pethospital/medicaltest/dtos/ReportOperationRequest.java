package com.isaac.pethospital.medicaltest.dtos;

import com.isaac.pethospital.medicaltest.entities.ReportEntity;
import com.isaac.pethospital.medicaltest.entities.ReportInfoEntity;
import com.isaac.pethospital.medicaltest.entities.ReportItemEntity;
import com.isaac.pethospital.medicaltest.entities.ReportTemplateEntity;
import com.isaac.pethospital.medicaltest.enums.ReportSectionEnum;
import com.isaac.pethospital.medicaltest.enums.ReportStatusEnum;
import com.isaac.pethospital.medicaltest.services.ReportTemplateService;

import java.time.LocalDateTime;
import java.util.*;

public class ReportOperationRequest {

    List<ReportItemEntity> reportItems = new LinkedList<>();
    LocalDateTime createdDateTime;
    LocalDateTime paidDateTime;
    LocalDateTime finishedDateTime;
    ReportStatusEnum reportStatus;
    String reportTemplateUuid;
    String uuid;
    Boolean markAsDone;


    //generate order
    String treatmentCaseUuid;
    List<String> reportUuid;
    List<String> reportUuidLists = new LinkedList<>();
    String petUuid;
    String petOwnerUuid;
    List<ReportItemOperationRequest> medicalTestReports = new LinkedList<>();
    private Long id;

    public List<ReportItemOperationRequest> getMedicalTestReports() {
        return medicalTestReports;
    }

    public void setMedicalTestReports(List<ReportItemOperationRequest> medicalTestReports) {
        this.medicalTestReports = medicalTestReports;
    }

    public Boolean getMarkAsDone() {
        return markAsDone;
    }

    public void setMarkAsDone(Boolean markAsDone) {
        this.markAsDone = markAsDone;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getPetUuid() {
        return petUuid;
    }

    public void setPetUuid(String petUuid) {
        this.petUuid = petUuid;
    }

    public String getPetOwnerUuid() {
        return petOwnerUuid;
    }

    public void setPetOwnerUuid(String petOwnerUuid) {
        this.petOwnerUuid = petOwnerUuid;
    }

    public String getReportTemplateUuid() {
        return reportTemplateUuid;
    }

    public void setReportTemplateUuid(String reportTemplateUuid) {
        this.reportTemplateUuid = reportTemplateUuid;
    }

    public String getTreatmentCaseUuid() {
        return treatmentCaseUuid;
    }

    public void setTreatmentCaseUuid(String treatmentCaseUuid) {
        this.treatmentCaseUuid = treatmentCaseUuid;
    }


    public List<String> getReportUuidLists() {
        return reportUuidLists;
    }


    public List<ReportEntity> toReports(ReportTemplateService reportTemplateService) {

        List<ReportEntity> list = new LinkedList<>();

        this.getMedicalTestReports().forEach(r -> {
            ReportEntity reportEntity = new ReportEntity();

            reportEntity.setReportStatus(ReportStatusEnum.UNPAID);
            reportEntity.setCreatedDateTime(LocalDateTime.now());

            reportEntity.setUuid(UUID.randomUUID().toString());
            reportEntity.setReportName(r.reportName);
            reportEntity.setReportTemplateUuid(r.reportTemplateUuid);
            reportEntity.setTreatmentCaseUuid(this.treatmentCaseUuid);

            ReportTemplateEntity template = reportTemplateService.findByUuid(r.reportTemplateUuid);

            template.getReportTemplateItems().forEach(i -> {
                ReportItemEntity reportItemEntity = new ReportItemEntity();
                reportItemEntity.setComments(i.getComments());
                reportItemEntity.setReferenceHighLimitValue(i.getReferenceHighLimitValue());
                reportItemEntity.setReferenceLowLimitValue(i.getReferenceLowLimitValue());
                reportItemEntity.setItemUnit(i.getItemUnit());
                reportItemEntity.setItemName(i.getItemName());
                reportEntity.addReportItem(reportItemEntity);
            });

            reportEntity.setPetOwnerUuid(this.petOwnerUuid);
            reportEntity.setPetUuid(this.petUuid);
            list.add(reportEntity);
        });

        return list;



        /*
        this.reportInfoList.forEach(r -> {
            ReportInfoEntity reportInfoEntity = new ReportInfoEntity();
            reportInfoEntity.setReportKey(r.getReportKey());
            reportInfoEntity.setReportValue(r.getReportValue());
            reportInfoEntity.setReportSection(ReportSectionEnum.HEADER);
            reportEntity.addReportInfo(reportInfoEntity);
        });


        */
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public LocalDateTime getPaidDateTime() {
        return paidDateTime;
    }

    public void setPaidDateTime(LocalDateTime paidDateTime) {
        this.paidDateTime = paidDateTime;
    }

    public LocalDateTime getFinishedDateTime() {
        return finishedDateTime;
    }

    public void setFinishedDateTime(LocalDateTime finishedDateTime) {
        this.finishedDateTime = finishedDateTime;
    }

    public ReportStatusEnum getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(ReportStatusEnum reportStatus) {
        this.reportStatus = reportStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void updateReport(ReportEntity reportEntity) {

        Map<Long, ReportItemEntity> map = new HashMap<Long, ReportItemEntity>();

        for (ReportItemEntity rie : this.reportItems)
            map.put(rie.getId(), rie);

        reportEntity.getReportItems().forEach(r -> {
            if (map.containsKey(r.getId())) {
                r.setResult(map.get(r.getId()).getResult());
                r.setComments(map.get(r.getId()).getComments());
            }
        });

        /*

        this.reportItems.forEach(r -> {

            reportItemEntity.setComments(r.getComments());
            reportItemEntity.setReferenceHighLimitValue(r.getReferenceHighLimitValue());
            reportItemEntity.setReferenceLowLimitValue(r.getReferenceLowLimitValue());
            reportItemEntity.setItemUnit(r.getItemUnit());
            reportItemEntity.setItemName(r.getItemName());
            reportItemEntity.setResult(r.getResult());

            reportEntity.addReportItem(reportItemEntity);
        });
        */


    }
}
