package com.isaac.pethospital.common.jms.finance;

public class ReportOperationMessage {

    String reportUuid;
    String reportTemplateUuid;

    public String getReportUuid() {
        return reportUuid;
    }

    public void setReportUuid(String reportUuid) {
        this.reportUuid = reportUuid;
    }


    public String getReportTemplateUuid() {
        return reportTemplateUuid;
    }

    public void setReportTemplateUuid(String reportTemplateUuid) {
        this.reportTemplateUuid = reportTemplateUuid;
    }
}
