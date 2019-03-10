package com.isaac.pethospital.medicaltest.dtos;

public class DepartmentReportTemplateOperationRequest {
    Long depId;
    Long testReportTemplateId;

    public Long getDepId() {
        return depId;
    }

    public void setDepId(Long depId) {
        this.depId = depId;
    }

    public Long getTestReportTemplateId() {
        return testReportTemplateId;
    }

    public void setTestReportTemplateId(Long testReportTemplateId) {
        this.testReportTemplateId = testReportTemplateId;
    }
}
