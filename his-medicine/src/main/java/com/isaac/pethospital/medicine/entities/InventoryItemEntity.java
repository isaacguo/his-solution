package com.isaac.pethospital.medicine.entities;


import javax.persistence.*;

@Entity
public class InventoryItemEntity {

    String uuid;
    String inventoryItemId; //货品编码
    String name; //名称
    String specification; //规格
    String batch; //批次
    String number; //数量
    @ManyToOne
    ProductImportReceiptEntity importReceipt;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public ProductImportReceiptEntity getImportReceipt() {
        return importReceipt;
    }

    public void setImportReceipt(ProductImportReceiptEntity importReceipt) {
        this.importReceipt = importReceipt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getInventoryItemId() {
        return inventoryItemId;
    }

    public void setInventoryItemId(String inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

