package com.isaac.pethospital.treatment.dtos;

import com.isaac.pethospital.common.converter.HanyuPinyinConverter;
import com.isaac.pethospital.treatment.entities.ChargeableItemEntity;

import java.math.BigDecimal;
import java.util.UUID;

public class ChargeableItemOperationRequest {
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

    public String getChargeableItemId() {
        return inventoryItemId;
    }

    public void setChargeableItemId(String inventoryItemId) {
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

    public ChargeableItemEntity toEntity(HanyuPinyinConverter converter)
    {
        ChargeableItemEntity iie=new ChargeableItemEntity();
        iie.setChargeableItemId(this.inventoryItemId);
        iie.setName(this.name);
        iie.setNameHanYuPinYin(converter.toHanyuPinyin(this.name));
        iie.setSpecification(this.specification);
        iie.setUnit(this.unit);
        iie.setAmount(new BigDecimal(0));
        iie.setUuid(this.uuid);
        return iie;
    }
}
