package com.isaac.pethospital.medicine.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Entity
public class ImportSheetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "importSheet", cascade = CascadeType.ALL)
    @JsonManagedReference("ImportSheetEntity-ImportItemEntity")
    private List<ImportItemEntity> importItemList = new LinkedList<>();

    String uuid;
    String sheetNumber;
    String vendor;
    String vendorContact;
    LocalDateTime importTime;
    String operator;
    String auditor;

    String comments;

    public String getComments() {
        return comments;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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

    public List<ImportItemEntity> getImportItemList() {
        return importItemList;
    }

    public void addImportItem(ImportItemEntity importItem) {
        if (importItem == null)
            throw new RuntimeException("Import Item is null");
        importItem.setImportSheet(this);
        this.importItemList.add(importItem);
    }


    public void removeImportItem(ImportItemEntity importItem) {
        if (importItem == null)
            throw new RuntimeException("Import Item is null");
        importItem.setImportSheet(null);
        this.importItemList.remove(importItem);
    }

    public String getUuid() {
        return uuid;
    }


    public String getSheetNumber() {
        return sheetNumber;
    }

    public void setSheetNumber(String sheetNumber) {
        this.sheetNumber = sheetNumber;
    }



    public LocalDateTime getImportTime() {
        return importTime;
    }

    public void setImportTime(LocalDateTime importTime) {
        this.importTime = importTime;
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
}
