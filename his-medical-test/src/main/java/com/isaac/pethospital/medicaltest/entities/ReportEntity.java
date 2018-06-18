package com.isaac.pethospital.medicaltest.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Entity
public class ReportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    @JsonManagedReference("report-reportInfo")
    List<ReportInfoEntity> reportInfoList = new LinkedList<>();

    @OneToMany(mappedBy = "report", cascade = CascadeType.ALL)
    @JsonManagedReference("report-reportItem")
    List<ReportItemEntity> reportItems = new LinkedList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ReportInfoEntity> getReportInfoList() {
        return reportInfoList;
    }

    public void addReportInfo(ReportInfoEntity reportInfo) {
        if (reportInfo == null)
            throw new RuntimeException("Report Info is null");
        reportInfo.setReport(this);
        this.reportInfoList.add(reportInfo);
    }

    public void removeReportInfo(ReportInfoEntity reportInfo) {
        if (reportInfo == null)
            throw new RuntimeException("Report Info is null");

        reportInfo.setReport(null);
        this.reportInfoList.remove(reportInfo);
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
