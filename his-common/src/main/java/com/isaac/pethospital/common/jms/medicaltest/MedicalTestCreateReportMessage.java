package com.isaac.pethospital.common.jms.medicaltest;

public class MedicalTestCreateReportMessage {

    String reportUuid;
    String treatmentCaseUuid;

    public String getReportUuid() {
        return reportUuid;
    }

    public void setReportUuid(String reportUuid) {
        this.reportUuid = reportUuid;
    }

    public String getTreatmentCaseUuid() {
        return treatmentCaseUuid;
    }

    public void setTreatmentCaseUuid(String treatmentCaseUuid) {
        this.treatmentCaseUuid = treatmentCaseUuid;
    }
}
