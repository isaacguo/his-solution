package com.isaac.pethospital.medicaltest.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class ReportItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemName;
    private String itemUnit;
    private String referenceLowLimitValue;
    private String referenceHighLimitValue;
    private String result;
    private String comments;
    @ManyToOne
    @JsonBackReference("report-reportItem")
    private ReportEntity report;

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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ReportEntity getReport() {

        return report;
    }

    public void setReport(ReportEntity report) {
        this.report = report;
    }
}
