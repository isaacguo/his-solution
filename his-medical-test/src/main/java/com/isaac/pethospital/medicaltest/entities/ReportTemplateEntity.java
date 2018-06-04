package com.isaac.pethospital.medicaltest.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class ReportTemplateEntity {

    @OneToMany(mappedBy = "reportTemplate", cascade = CascadeType.ALL)
    @JsonManagedReference("reportTemplate-reportTemplateItem")
    List<ReportTemplateItemEntity> reportTemplateItems = new LinkedList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reportName;

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

    public List<ReportTemplateItemEntity> getReportTemplateItems() {
        return reportTemplateItems;
    }

    public void addReportTemplateItem(ReportTemplateItemEntity reportTemplateItem) {
        if (reportTemplateItem == null)
            throw new RuntimeException("Report Template Item is null");
        reportTemplateItem.setReportTemplate(this);
        this.reportTemplateItems.add(reportTemplateItem);
    }

    public void removeReportTemplateItem(ReportTemplateItemEntity reportTemplateItem) {
        if (reportTemplateItem == null)
            throw new RuntimeException("Report Template Item is null");
        reportTemplateItem.setReportTemplate(null);
        this.reportTemplateItems.remove(reportTemplateItem);
    }
}
