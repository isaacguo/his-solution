package com.isaac.pethospital.treatment.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class ChargeableItemEntity  {

    String uuid;
    String chargeableItemId; //货品编码
    String name; //名称
    String unit; //单位
    String specification; //规格
    BigDecimal amount; //数量
    String nameHanYuPinYin;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne()
    @JsonBackReference("ChargeableCategoryEntity-ChargeableItemEntity")
    private ChargeableCategoryEntity category;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getNameHanYuPinYin() {
        return nameHanYuPinYin;
    }

    public void setNameHanYuPinYin(String nameHanYuPinYin) {
        this.nameHanYuPinYin = nameHanYuPinYin;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public ChargeableCategoryEntity getCategory() {
        return category;
    }

    public void setCategory(ChargeableCategoryEntity category) {
        this.category = category;
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

    public String getChargeableItemId() {
        return chargeableItemId;
    }

    public void setChargeableItemId(String chargeableItemId) {
        this.chargeableItemId = chargeableItemId;
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


}
