package com.isaac.pethospital.medicine.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class ImportItemEntity {

    @ManyToOne()
    @JsonBackReference("ImportSheetEntity-ImportItemEntity")
    ImportSheetEntity importSheet;
    String name;
    String unit;
    String specification;
    BigDecimal amount;
    BigDecimal pricePerUnit;
    BigDecimal totalPrice;
    String comments;
    String nameHanYuPinYin;

    Long inventoryItemId;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getInventoryItemId() {
        return inventoryItemId;
    }

    public void setInventoryItemId(Long inventoryItemId) {
        this.inventoryItemId = inventoryItemId;
    }

    public String getNameHanYuPinYin() {
        return nameHanYuPinYin;
    }

    public void setNameHanYuPinYin(String nameHanYuPinYin) {
        this.nameHanYuPinYin = nameHanYuPinYin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ImportSheetEntity getImportSheet() {
        return importSheet;
    }

    public void setImportSheet(ImportSheetEntity importSheet) {
        this.importSheet = importSheet;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public BigDecimal getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(BigDecimal pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

}
