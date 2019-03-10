package com.isaac.pethospital.medicaltest.dtos;

public class ReportItemOperationRequest {

    String reportName;
    String reportTemplateUuid;

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getReportTemplateUuid() {
        return reportTemplateUuid;
    }

    public void setReportTemplateUuid(String reportTemplateUuid) {
        this.reportTemplateUuid = reportTemplateUuid;
    }

}
