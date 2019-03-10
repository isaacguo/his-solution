package com.isaac.pethospital.common.jms.medicine;

import java.math.BigDecimal;

public class PharmacyPrescriptionItemCreateMessage {



    String inventoryItemUuid; //货品编码
    String name; //名称
    String unit; //单位
    String specification; //规格
    BigDecimal amount; //数量

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

    public String getInventoryItemUuid() {
        return inventoryItemUuid;
    }

    public void setInventoryItemUuid(String inventoryItemUuid) {
        this.inventoryItemUuid = inventoryItemUuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
