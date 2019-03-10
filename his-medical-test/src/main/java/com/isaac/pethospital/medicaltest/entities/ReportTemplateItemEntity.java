package com.isaac.pethospital.medicaltest.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class ReportTemplateItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemName;
    private String itemUnit;
    private String referenceLowLimitValue;
    private String referenceHighLimitValue;
    private String comments;

    @ManyToOne
    @JsonBackReference("reportTemplate-reportTemplateItem")
    private ReportTemplateEntity reportTemplate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemUnit() {
        return itemUnit;
    }

    public void setItemUnit(String itemUnit) {
        this.itemUnit = itemUnit;
    }

    public String getReferenceLowLimitValue() {
        return referenceLowLimitValue;
    }

    public void setReferenceLowLimitValue(String referenceLowLimitValue) {
        this.referenceLowLimitValue = referenceLowLimitValue;
    }

    public String getReferenceHighLimitValue() {
        return referenceHighLimitValue;
    }

    public void setReferenceHighLimitValue(String referenceHighLimitValue) {
        this.referenceHighLimitValue = referenceHighLimitValue;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public ReportTemplateEntity getReportTemplate() {
        return reportTemplate;
    }

    public void setReportTemplate(ReportTemplateEntity reportTemplate) {
        this.reportTemplate = reportTemplate;
    }
}
