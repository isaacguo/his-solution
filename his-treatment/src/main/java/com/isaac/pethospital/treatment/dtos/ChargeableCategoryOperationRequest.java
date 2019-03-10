package com.isaac.pethospital.treatment.dtos;


import com.isaac.pethospital.treatment.entities.ChargeableCategoryEntity;

import java.util.LinkedList;
import java.util.List;

public class ChargeableCategoryOperationRequest {

    Long parentId;
    List<ChargeableCategoryEntity> children = new LinkedList<>();
    ChargeableCategoryEntity parent;
    private Long id;
    private String name;
    private List<ChargeableCategoryEntity> chargeableItemList = new LinkedList<>();

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public List<ChargeableCategoryEntity> getChildren() {
        return children;
    }

    public void setChildren(List<ChargeableCategoryEntity> children) {
        this.children = children;
    }

    public ChargeableCategoryEntity getParent() {
        return parent;
    }

    public void setParent(ChargeableCategoryEntity parent) {
        this.parent = parent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ChargeableCategoryEntity> getChargeableItemList() {
        return chargeableItemList;
    }

    public void setChargeableItemList(List<ChargeableCategoryEntity> chargeableItemList) {
        this.chargeableItemList = chargeableItemList;
    }


}
