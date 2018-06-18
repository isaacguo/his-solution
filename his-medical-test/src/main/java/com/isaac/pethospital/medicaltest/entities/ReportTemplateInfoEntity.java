package com.isaac.pethospital.medicaltest.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.isaac.pethospital.medicaltest.enums.ReportSectionEnum;

import javax.persistence.*;

@Entity
public class ReportTemplateInfoEntity {


    String reportKey;
    String reportValue;
    @ManyToOne
    @JsonBackReference("reportTemplate-reportTemplateInfo")
    ReportTemplateEntity reportTemplate;
    @Enumerated(EnumType.STRING)
    ReportSectionEnum reportSection;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public ReportTemplateInfoEntity() {
    }

    public ReportSectionEnum getReportSection() {
        return reportSection;
    }

    public void setReportSection(ReportSectionEnum reportSection) {
        this.reportSection = reportSection;
    }

    public String getReportKey() {
        return reportKey;
    }

    public void setReportKey(String reportKey) {
        this.reportKey = reportKey;
    }

    public String getReportValue() {
        return reportValue;
    }

    public void setReportValue(String reportValue) {
        this.reportValue = reportValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ReportTemplateEntity getReportTemplate() {
        return reportTemplate;
    }

    public void setReportTemplate(ReportTemplateEntity reportTemplate) {
        this.reportTemplate = reportTemplate;
    }
}
