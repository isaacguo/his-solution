package com.isaac.pethospital.medicine.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Entity
public class ExportSheetEntity {

    String uuid;
    String sheetNumber;
    String customer;
    String customerContact;
    LocalDateTime exportedTime;
    String operator;
    String auditor;
    String comments;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "exportSheet", cascade = CascadeType.ALL)
    @JsonManagedReference("ExportSheetEntity-ExportItemEntity")
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

    public void addExportItem(ExportItemEntity exportItem) {
        if(exportItem==null)
            throw new RuntimeException("Export Item is null");
        exportItem.setExportSheet(this);
        this.exportItemList.add(exportItem);
    }

    public void removeExportItem(ExportItemEntity exportItem) {
        if(exportItem==null)
            throw new RuntimeException("Export Item is null");
        exportItem.setExportSheet(null);
        this.exportItemList.remove(exportItem);
    }
}
