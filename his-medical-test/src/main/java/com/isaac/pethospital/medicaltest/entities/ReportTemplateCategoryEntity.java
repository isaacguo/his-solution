package com.isaac.pethospital.medicaltest.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class ReportTemplateCategoryEntity {

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    @JsonManagedReference("parent-children")
    List<ReportTemplateCategoryEntity> children = new LinkedList<>();
    @ManyToOne
    @JsonBackReference("parent-children")
    ReportTemplateCategoryEntity parent;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.PERSIST)
    @JsonManagedReference("ReportTemplateCategoryEntity-ReportTemplateEntity")
    private List<ReportTemplateEntity> reportTemplateList = new LinkedList<>();


    @ManyToOne()
    @JsonBackReference("department-reportCategories")
    private DepartmentEntity department;

    public DepartmentEntity getDepartment() {
        return department;
    }

    public void setDepartment(DepartmentEntity department) {
        this.department = department;
    }

    public List<ReportTemplateCategoryEntity> getChildren() {
        return children;
    }

    public void addChild(ReportTemplateCategoryEntity child) {
        if (children == null)
            throw new RuntimeException("child is null");
        child.setParent(this);
        this.children.add(child);
    }

    public void removeChild(ReportTemplateCategoryEntity child) {
        if (children == null)
            throw new RuntimeException("child is null");
        child.setParent(null);
        this.children.remove(child);
    }

    public ReportTemplateCategoryEntity getParent() {
        return parent;
    }

    public void setParent(ReportTemplateCategoryEntity parent) {
        this.parent = parent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ReportTemplateEntity> getReportTemplateList() {
        return reportTemplateList;
    }

    public void addReportTemplate(ReportTemplateEntity reportTemplate) {
        if (reportTemplate == null)
            throw new RuntimeException("Template is null");
        reportTemplate.setCategory(this);
        this.reportTemplateList.add(reportTemplate);
    }

    public void removeReportTemplate(ReportTemplateEntity reportTemplate) {
        if (reportTemplate == null)
            throw new RuntimeException("Template is null");
        reportTemplate.setCategory(null);
        this.reportTemplateList.remove(reportTemplate);
    }
}
