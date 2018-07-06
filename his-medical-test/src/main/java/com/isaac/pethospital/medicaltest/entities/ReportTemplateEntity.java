package com.isaac.pethospital.medicaltest.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class ReportTemplateEntity {


    @OneToMany(mappedBy = "reportTemplate", cascade = CascadeType.ALL)
    @JsonManagedReference("reportTemplate-reportTemplateItem")
    List<ReportTemplateItemEntity> reportTemplateItems = new LinkedList<>();
    @OneToMany(mappedBy = "reportTemplate", cascade = CascadeType.ALL)
    @JsonManagedReference("reportTemplate-reportTemplateInfo")
    List<ReportTemplateInfoEntity> reportTemplateInfoList = new LinkedList<>();
    @ManyToMany
    //@JsonBackReference("department-reportTemplates")
    @JsonBackReference()
    List<DepartmentEntity> departmentList = new LinkedList<>();
    @ManyToOne()
    @JsonBackReference("ReportTemplateCategoryEntity-ReportTemplateEntity")
    private ReportTemplateCategoryEntity category;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uuid;
    private String reportName;
    private String reportNameHanYuPinYin;

    public ReportTemplateCategoryEntity getCategory() {
        return category;
    }

    public void setCategory(ReportTemplateCategoryEntity category) {
        this.category = category;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getReportNameHanYuPinYin() {
        return reportNameHanYuPinYin;
    }

    public void setReportNameHanYuPinYin(String reportNameHanYuPinYin) {
        this.reportNameHanYuPinYin = reportNameHanYuPinYin;
    }

    public List<DepartmentEntity> getDepartmentList() {
        return departmentList;
    }

    public void addDepartment(DepartmentEntity department) {
        if (department == null)
            throw new RuntimeException("Department is null");
        this.departmentList.add(department);
    }

    public void removeDepartment(DepartmentEntity department) {
        if (department == null)
            throw new RuntimeException("Department is null");
        this.departmentList.remove(department);
    }

    public List<ReportTemplateInfoEntity> getReportTemplateInfoList() {
        return reportTemplateInfoList;
    }

    public void addReportTemplateInfo(ReportTemplateInfoEntity reportTemplateInfo) {
        if (reportTemplateInfo == null)
            throw new RuntimeException("Report Template Info is null");
        reportTemplateInfo.setReportTemplate(this);
        this.reportTemplateInfoList.add(reportTemplateInfo);
    }

    public void removeReportTemplateInfo(ReportTemplateInfoEntity reportTemplateInfo) {
        if (reportTemplateInfo == null)
            throw new RuntimeException("Report Template Info is null");
        reportTemplateInfo.setReportTemplate(null);
        this.reportTemplateInfoList.remove(reportTemplateInfo);
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
