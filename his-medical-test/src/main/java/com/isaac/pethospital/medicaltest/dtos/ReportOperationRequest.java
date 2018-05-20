package com.isaac.pethospital.medicaltest.dtos;

import com.isaac.pethospital.medicaltest.entities.ReportEntity;
import com.isaac.pethospital.medicaltest.entities.ReportItemEntity;

import java.util.LinkedList;
import java.util.List;

public class ReportOperationRequest {

    List<ReportItemEntity> reportItems = new LinkedList<>();
    private Long id;
    private String reportName;

    public List<ReportItemEntity> getReportItems() {
        return reportItems;
    }

    public void setReportItems(List<ReportItemEntity> reportItems) {
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

    public ReportEntity toReport() {
        ReportEntity reportEntity = new ReportEntity();
        reportEntity.setReportName(this.reportName);

        this.reportItems.forEach(r -> {
            ReportItemEntity reportItemEntity = new ReportItemEntity();
            reportItemEntity.setItemName(r.getItemName());
            reportItemEntity.setItemUnit(r.getItemUnit());
            reportItemEntity.setReferenceLowLimitValue(r.getReferenceLowLimitValue());
            reportItemEntity.setReferenceHighLimitValue(r.getReferenceHighLimitValue());
            reportItemEntity.setComments(r.getComments());
            reportEntity.addReportItem(reportItemEntity);
        });

        return reportEntity;
    }
}
