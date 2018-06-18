package com.isaac.pethospital.medicaltest.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.isaac.pethospital.medicaltest.enums.ReportSectionEnum;
import org.springframework.jms.annotation.EnableJms;

import javax.persistence.*;

@Entity
public class ReportInfoEntity {

    String reportKey;
    String reportValue;
    @Enumerated(EnumType.STRING)
    ReportSectionEnum reportSection;
    @ManyToOne
    @JsonManagedReference("report-reportInfo")
    ReportEntity report;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public ReportSectionEnum getReportSection() {
        return reportSection;
    }

    public void setReportSection(ReportSectionEnum reportSection) {
        this.reportSection = reportSection;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public ReportEntity getReport() {
        return report;
    }

    public void setReport(ReportEntity report) {
        this.report = report;
    }
}
