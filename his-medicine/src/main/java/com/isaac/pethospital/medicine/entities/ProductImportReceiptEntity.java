package com.isaac.pethospital.medicine.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

//入库单
@Entity
public class ProductImportReceiptEntity {

    String importReceiptId;
    @OneToMany(mappedBy = "importReceipt")
    List<InventoryItemEntity> items = new LinkedList<>();
    String vendorId;
    String vendorName;
    String contact;
    String uuid;
    LocalDateTime createdDate;
    String operator;
    String auditor;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImportReceiptId() {
        return importReceiptId;
    }

    public void setImportReceiptId(String importReceiptId) {
        this.importReceiptId = importReceiptId;
    }

    public List<InventoryItemEntity> getItems() {
        return items;
    }

    public void addItem(InventoryItemEntity item) {
        if (item == null)
            throw new RuntimeException("Item is null");
        item.setImportReceipt(this);
        this.items.add(item);
    }

    public void removeItem(InventoryItemEntity item) {
        if (item == null)
            throw new RuntimeException("Item is null");
        item.setImportReceipt(null);
        this.items.remove(item);
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
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
