package com.isaac.pethospital.medicaltest.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long depId;
    private String name;
    private String description;
    private boolean enable;

    @OneToMany(mappedBy = "department",cascade = CascadeType.ALL)
    @JsonManagedReference("department-reportCategories")
    List<ReportTemplateCategoryEntity> reportTemplateCategoryList = new LinkedList<>();

    public List<ReportTemplateCategoryEntity> getReportTemplateCategoryList() {
        return reportTemplateCategoryList;
    }

    public void addReportTemplateCategory(ReportTemplateCategoryEntity reportTemplateCategory) {
        if(reportTemplateCategory==null)
            throw new RuntimeException("ReportTemplateCategory is null");
        reportTemplateCategory.setDepartment(this);
        this.reportTemplateCategoryList.add(reportTemplateCategory);
    }

    public void removeReportTemplateCategory(ReportTemplateCategoryEntity reportTemplateCategory) {
        if(reportTemplateCategory==null)
            throw new RuntimeException("ReportTemplateCategory is null");
        reportTemplateCategory.setDepartment(null);
        this.reportTemplateCategoryList.remove(reportTemplateCategory);
    }
    @OneToMany(mappedBy = "department")
    @JsonManagedReference("department-reportTemplates")
    List<ReportTemplateEntity> supportedReportTemplates = new LinkedList<>();

    public List<ReportTemplateEntity> getSupportedReportTemplates() {
        return supportedReportTemplates;
    }

    public void addSupportedReportTemplate(ReportTemplateEntity supportedReportTemplate) {
        if (supportedReportTemplate != null)
            supportedReportTemplate.setDepartment(this);
        this.supportedReportTemplates.add(supportedReportTemplate);
    }


    public void removeSupportedReportTemplate(ReportTemplateEntity supportedReportTemplate) {
        if (supportedReportTemplate != null)
            supportedReportTemplate.setDepartment(null);
        this.supportedReportTemplates.remove(supportedReportTemplate);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDepId() {
        return depId;
    }

    public void setDepId(Long depId) {
        this.depId = depId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
