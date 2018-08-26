package com.isaac.pethospital.medicine.dtos;

import com.isaac.pethospital.common.converter.HanyuPinyinConverter;
import com.isaac.pethospital.medicine.entities.ImportItemEntity;
import com.isaac.pethospital.medicine.entities.ImportSheetEntity;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class ImportSheetOperationRequest {


    String uuid;
    String sheetNumber;
    String vendor;
    String vendorContact;
    String operator;
    String auditor;
    String comments;
    String batchNumber;





    private Long id;
    private List<ImportItemEntity> importItemList = new LinkedList<>();

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ImportItemEntity> getImportItemList() {
        return importItemList;
    }

    public void setImportItemList(List<ImportItemEntity> importItemList) {
        this.importItemList = importItemList;
    }

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

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getVendorContact() {
        return vendorContact;
    }

    public void setVendorContact(String vendorContact) {
        this.vendorContact = vendorContact;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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

    public ImportSheetEntity toImportSheet(HanyuPinyinConverter converter) {
        ImportSheetEntity sheet = new ImportSheetEntity();
        sheet.setUuid(UUID.randomUUID().toString());
        sheet.setAuditor(this.auditor);
        sheet.setImportTime(LocalDateTime.now());
        sheet.setOperator(this.operator);
        sheet.setSheetNumber(this.sheetNumber);
        sheet.setVendor(this.vendor);
        sheet.setVendorContact(this.vendorContact);
        sheet.setComments(this.comments);
        sheet.setBatchNumber(this.batchNumber);
        this.importItemList.forEach(r -> {
            ImportItemEntity importItemEntity = new ImportItemEntity();
            importItemEntity.setName(r.getName());
            importItemEntity.setNameHanYuPinYin(converter.toHanyuPinyin(r.getName()));
            importItemEntity.setComments(r.getComments());
            importItemEntity.setPricePerUnit(r.getPricePerUnit());
            importItemEntity.setSpecification(r.getSpecification());
            importItemEntity.setUnit(r.getUnit());
            importItemEntity.setAmount(r.getAmount());
            importItemEntity.setTotalPrice(r.getAmount().multiply(r.getPricePerUnit()));
            importItemEntity.setInventoryItemId(r.getInventoryItemId());
            sheet.addImportItem(importItemEntity);
        });
        return sheet;
    }
}
