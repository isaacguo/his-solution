package com.isaac.pethospital.medicine.dtos;

import com.isaac.pethospital.medicine.entities.InventoryItemEntity;

import java.util.UUID;

public class InventoryItemOperationRequest
{
    String uuid;
    String inventoryItemId; //货品编码
    String name; //名称
    String unit; //单位
    String specification; //规格
    String number; //数量
    Long categoryId;
    private Long id;

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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public InventoryItemEntity toEntity
            ()
    {
        InventoryItemEntity iie=new InventoryItemEntity();
        iie.setInventoryItemId(this.inventoryItemId);
        iie.setName(this.name);
        iie.setSpecification(this.specification);
        iie.setUnit(this.unit);
        iie.setUuid(UUID.randomUUID().toString());
        return iie;
    }

}
