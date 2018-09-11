package com.isaac.pethospital.common.jms.treatment;

import java.math.BigDecimal;

public class MedicineItemMessage {

    String inventoryItemId; //货品编码
    String name; //名称
    String unit; //单位
    String specification; //规格

    public String getMedicineUuid() {
        return medicineUuid;
    }

    public void setMedicineUuid(String medicineUuid) {
        this.medicineUuid = medicineUuid;
    }

    String medicineUuid;
    BigDecimal amount; //数量
    String uuid;

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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
