package com.isaac.pethospital.medicaltest.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.isaac.pethospital.medicaltest.enums.ReportStatusEnum;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Entity
public class ReportEntity {

    @OneToMany(mappedBy = "report", cascade = CascadeType.ALL)
    @JsonManagedReference("report-reportInfo")
    List<ReportInfoEntity> reportInfoList = new LinkedList<>();
    @OneToMany(mappedBy = "report", cascade = CascadeType.ALL)
    @JsonManagedReference("report-reportItem")
    List<ReportItemEntity> reportItems = new LinkedList<>();
    LocalDateTime createdDateTime;
    LocalDateTime paidDateTime;
    LocalDateTime finishedDateTime;
    ReportStatusEnum reportStatus;
    private String reportName;
    private String uuid;
    private String treatmentCaseUuid;
    private String reportTemplateUuid;
    private String petUuid;
    private String petOwnerUuid;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    public String getTreatmentCaseUuid() {
        return treatmentCaseUuid;
    }

    public void setTreatmentCaseUuid(String treatmentCaseUuid) {
        this.treatmentCaseUuid = treatmentCaseUuid;
    }

    public String getReportTemplateUuid() {
        return reportTemplateUuid;
    }

    public void setReportTemplateUuid(String reportTemplateUuid) {
        this.reportTemplateUuid = reportTemplateUuid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
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

    public List<ReportInfoEntity> getReportInfoList() {
        return reportInfoList;
    }

    public void addReportInfo(ReportInfoEntity reportInfo) {
        if (reportInfo == null)
            throw new RuntimeException("Report Info is null");
        reportInfo.setReport(this);
        this.reportInfoList.add(reportInfo);
    }

    public void removeReportInfo(ReportInfoEntity reportInfo) {
        if (reportInfo == null)
            throw new RuntimeException("Report Info is null");

        reportInfo.setReport(null);
        this.reportInfoList.remove(reportInfo);
    }

    public List<ReportItemEntity> getReportItems() {
        return reportItems;
    }

    public void addReportItem(ReportItemEntity reportItem) {
        if (reportItem == null)
            throw new RuntimeException("Report Item is null");
        reportItem.setReport(this);
        this.reportItems.add(reportItem);
    }

    public void removeReportItem(ReportItemEntity reportItem) {
        if (reportItem == null)
            throw new RuntimeException("Report Item is null");
        reportItem.setReport(null);
        this.reportItems.remove(reportItem);
    }
}
