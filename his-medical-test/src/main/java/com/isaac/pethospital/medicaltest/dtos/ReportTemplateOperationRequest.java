package com.isaac.pethospital.medicaltest.dtos;

import com.isaac.pethospital.common.converter.HanyuPinyinConverter;
import com.isaac.pethospital.medicaltest.entities.ReportTemplateEntity;
import com.isaac.pethospital.medicaltest.entities.ReportTemplateInfoEntity;
import com.isaac.pethospital.medicaltest.entities.ReportTemplateItemEntity;
import com.isaac.pethospital.medicaltest.enums.ReportSectionEnum;

import java.util.LinkedList;
import java.util.List;

public class ReportTemplateOperationRequest {

    List<ReportTemplateItemEntity> reportItems = new LinkedList<>();
    List<ReportTemplateInfoEntity> reportInfo = new LinkedList<>();
    private Long id;
    private Long categoryId;
    private String reportName;
    private String reportNameHanYuPinYin;

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getReportNameHanYuPinYin() {
        return reportNameHanYuPinYin;
    }

    public void setReportNameHanYuPinYin(String reportNameHanYuPinYin) {
        this.reportNameHanYuPinYin = reportNameHanYuPinYin;
    }

    public List<ReportTemplateInfoEntity> getReportInfo() {
        return reportInfo;
    }

    public void setReportInfo(List<ReportTemplateInfoEntity> reportInfo) {
        this.reportInfo = reportInfo;
    }

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

    public ReportTemplateEntity toReport(HanyuPinyinConverter converter) {
        ReportTemplateEntity reportTemplateEntity = new ReportTemplateEntity();
        reportTemplateEntity.setReportName(this.reportName);
        reportTemplateEntity.setReportNameHanYuPinYin(converter.toHanyuPinyin(this.reportName));

        this.reportItems.forEach(r -> {
            ReportTemplateItemEntity reportTemplateItemEntity = new ReportTemplateItemEntity();
            reportTemplateItemEntity.setItemName(r.getItemName());
            reportTemplateItemEntity.setItemUnit(r.getItemUnit());
            reportTemplateItemEntity.setReferenceLowLimitValue(r.getReferenceLowLimitValue());
            reportTemplateItemEntity.setReferenceHighLimitValue(r.getReferenceHighLimitValue());
            reportTemplateItemEntity.setComments(r.getComments());
            reportTemplateEntity.addReportTemplateItem(reportTemplateItemEntity);
        });

        this.reportInfo.forEach(r -> {
            ReportTemplateInfoEntity reportTemplateInfoEntity = new ReportTemplateInfoEntity();
            reportTemplateInfoEntity.setReportKey(r.getReportKey());
            reportTemplateInfoEntity.setReportSection(ReportSectionEnum.HEADER);
            reportTemplateEntity.addReportTemplateInfo(reportTemplateInfoEntity);
        });
        return reportTemplateEntity;
    }
}
