package com.isaac.pethospital.medicaltest.dtos;

import com.isaac.pethospital.medicaltest.entities.ReportTemplateEntity;
import com.isaac.pethospital.medicaltest.entities.ReportTemplateItemEntity;

import java.util.LinkedList;
import java.util.List;

public class ReportOperationRequest {

    List<ReportTemplateItemEntity> reportItems = new LinkedList<>();
    private Long id;
    private String reportName;

    public List<ReportTemplateItemEntity> getReportItems() {
        return reportItems;
    }

    public void setReportItems(List<ReportTemplateItemEntity> reportItems) {
        this.reportItems = reportItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public ReportTemplateEntity toReport() {
        ReportTemplateEntity reportTemplateEntity = new ReportTemplateEntity();
        reportTemplateEntity.setReportName(this.reportName);

        this.reportItems.forEach(r -> {
            ReportTemplateItemEntity reportTemplateItemEntity = new ReportTemplateItemEntity();
            reportTemplateItemEntity.setItemName(r.getItemName());
            reportTemplateItemEntity.setItemUnit(r.getItemUnit());
            reportTemplateItemEntity.setReferenceLowLimitValue(r.getReferenceLowLimitValue());
            reportTemplateItemEntity.setReferenceHighLimitValue(r.getReferenceHighLimitValue());
            reportTemplateItemEntity.setComments(r.getComments());
            reportTemplateEntity.addReportTemplateItem(reportTemplateItemEntity);
        });

        return reportTemplateEntity;
    }
}
