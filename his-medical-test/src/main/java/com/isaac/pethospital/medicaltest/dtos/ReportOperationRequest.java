package com.isaac.pethospital.medicaltest.dtos;

import com.isaac.pethospital.medicaltest.entities.ReportEntity;
import com.isaac.pethospital.medicaltest.entities.ReportInfoEntity;
import com.isaac.pethospital.medicaltest.entities.ReportItemEntity;
import com.isaac.pethospital.medicaltest.enums.ReportSectionEnum;
import com.isaac.pethospital.medicaltest.enums.ReportStatusEnum;

import java.time.LocalDateTime;
import java.util.*;

public class ReportOperationRequest {

    List<ReportItemEntity> reportItems = new LinkedList<>();
    List<ReportInfoEntity> reportInfoList = new LinkedList<>();
    LocalDateTime createdDateTime;
    LocalDateTime paidDateTime;
    LocalDateTime finishedDateTime;
    ReportStatusEnum reportStatus;
    String reportTemplateUuid;
    String uuid;
    //generate order
    String treatmentCaseUuid;
    List<String> reportUuid;
    List<String> reportUuidLists = new LinkedList<>();
    String reportName;
    String petUuid;
    String petOwnerUuid;
    private Long id;

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

    public List<String> getReportUuid() {
        return reportUuid;
    }

    public void setReportUuid(List<String> reportUuid) {
        this.reportUuid = reportUuid;
    }

    public List<String> getReportUuidLists() {
        return reportUuidLists;
    }

    public void setReportUuidLists(List<String> reportUuidLists) {
        this.reportUuidLists = reportUuidLists;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public ReportEntity toReport() {
        ReportEntity reportEntity = new ReportEntity();
        reportEntity.setUuid(UUID.randomUUID().toString());
        reportEntity.setReportName(this.reportName);
        reportEntity.setReportTemplateUuid(this.reportTemplateUuid);
        reportEntity.setTreatmentCaseUuid(this.treatmentCaseUuid);
        reportEntity.setPetOwnerUuid(this.petOwnerUuid);
        reportEntity.setPetUuid(this.petUuid);

        this.reportInfoList.forEach(r -> {
            ReportInfoEntity reportInfoEntity = new ReportInfoEntity();
            reportInfoEntity.setReportKey(r.getReportKey());
            reportInfoEntity.setReportValue(r.getReportValue());
            reportInfoEntity.setReportSection(ReportSectionEnum.HEADER);
            reportEntity.addReportInfo(reportInfoEntity);
        });

        this.reportItems.forEach(r -> {
            ReportItemEntity reportItemEntity = new ReportItemEntity();
            reportItemEntity.setComments(r.getComments());
            reportItemEntity.setReferenceHighLimitValue(r.getReferenceHighLimitValue());
            reportItemEntity.setReferenceLowLimitValue(r.getReferenceLowLimitValue());
            reportItemEntity.setItemUnit(r.getItemUnit());
            reportItemEntity.setItemName(r.getItemName());
            reportItemEntity.setResult(r.getResult());

            reportEntity.addReportItem(reportItemEntity);
        });


        return reportEntity;
    }

    public List<ReportItemEntity> getReportItems() {
        return reportItems;
    }

    public void setReportItems(List<ReportItemEntity> reportItems) {
        this.reportItems = reportItems;
    }

    public List<ReportInfoEntity> getReportInfoList() {
        return reportInfoList;
    }

    public void setReportInfoList(List<ReportInfoEntity> reportInfoList) {
        this.reportInfoList = reportInfoList;
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
