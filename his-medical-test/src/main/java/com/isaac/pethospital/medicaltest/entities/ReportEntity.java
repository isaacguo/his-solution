package com.isaac.pethospital.medicaltest.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class ReportEntity {

    @OneToMany(mappedBy = "report", cascade = CascadeType.ALL)
    @JsonManagedReference("report-reportItem")
    List<ReportItemEntity> reportItems = new LinkedList<>();
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
