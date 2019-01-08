package com.isaac.pethospital.medicine.entities;

import com.isaac.pethospital.common.entities.AbstractCollectionItemEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class PharmacyPrescriptionItemEntity extends AbstractCollectionItemEntity<PharmacyPrescriptionEntity> {


    String uuid;
    String inventoryItemUuid; //货品编码
    String name; //名称
    String unit; //单位
    String specification; //规格
    BigDecimal amount; //数量
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
