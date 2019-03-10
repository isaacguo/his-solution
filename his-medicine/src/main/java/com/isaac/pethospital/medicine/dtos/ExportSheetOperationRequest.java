package com.isaac.pethospital.medicine.dtos;

import com.isaac.pethospital.common.converter.HanyuPinyinConverter;
import com.isaac.pethospital.medicine.entities.ExportItemEntity;
import com.isaac.pethospital.medicine.entities.ExportSheetEntity;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class ExportSheetOperationRequest {

    String uuid;
    String sheetNumber;
    String customer;
    String customerContact;
    LocalDateTime exportedTime;
    String operator;
    String auditor;
    String comments;
    private Long id;
    private List<ExportItemEntity> exportItemList = new LinkedList<>();

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getSheetNumber() {
        return sheetNumber;
    }

    public void setSheetNumber(String sheetNumber) {
        this.sheetNumber = sheetNumber;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getCustomerContact() {
        return customerContact;
    }

    public void setCustomerContact(String customerContact) {
        this.customerContact = customerContact;
    }

    public LocalDateTime getExportedTime() {
        return exportedTime;
    }

    public void setExportedTime(LocalDateTime exportedTime) {
        this.exportedTime = exportedTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
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

    public List<ExportItemEntity> getExportItemList() {
        return exportItemList;
    }

    public void setExportItemList(List<ExportItemEntity> exportItemList) {
        this.exportItemList = exportItemList;
    }

    public ExportSheetEntity toExportSheet(HanyuPinyinConverter converter) {
        ExportSheetEntity ese=new ExportSheetEntity();
        ese.setAuditor(this.auditor);
        ese.setComments(this.comments);
        ese.setCustomer(this.customer);
        ese.setCustomerContact(this.customerContact);
        ese.setOperator(this.operator);
        ese.setSheetNumber(this.sheetNumber);
        ese.setUuid(UUID.randomUUID().toString());
        this.exportItemList.forEach(r -> {
            ExportItemEntity exportItemEntity = new ExportItemEntity();
            exportItemEntity.setName(r.getName());
            exportItemEntity.setNameHanYuPinYin(converter.toHanyuPinyin(r.getName()));
            exportItemEntity.setComments(r.getComments());
            exportItemEntity.setPricePerUnit(r.getPricePerUnit());
            exportItemEntity.setSpecification(r.getSpecification());
            exportItemEntity.setUnit(r.getUnit());
            exportItemEntity.setAmount(r.getAmount());
            exportItemEntity.setTotalPrice(r.getAmount().multiply(r.getPricePerUnit()));
            exportItemEntity.setInventoryItemId(r.getInventoryItemId());
            ese.addExportItem(exportItemEntity);
        });
        return ese;
    }
}
