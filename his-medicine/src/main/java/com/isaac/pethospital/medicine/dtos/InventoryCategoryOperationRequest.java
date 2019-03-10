package com.isaac.pethospital.medicine.dtos;

import com.isaac.pethospital.medicine.entities.InventoryCategoryEntity;
import com.isaac.pethospital.medicine.entities.InventoryItemEntity;

import java.util.LinkedList;
import java.util.List;

public class InventoryCategoryOperationRequest {

    Long parentId;
    List<InventoryCategoryEntity> children = new LinkedList<>();
    InventoryCategoryEntity parent;
    private Long id;
    private String name;
    private List<InventoryItemEntity> inventoryItemList = new LinkedList<>();

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public List<InventoryCategoryEntity> getChildren() {
        return children;
    }

    public void setChildren(List<InventoryCategoryEntity> children) {
        this.children = children;
    }

    public InventoryCategoryEntity getParent() {
        return parent;
    }

    public void setParent(InventoryCategoryEntity parent) {
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

    public List<InventoryItemEntity> getInventoryItemList() {
        return inventoryItemList;
    }

    public void setInventoryItemList(List<InventoryItemEntity> inventoryItemList) {
        this.inventoryItemList = inventoryItemList;
    }
}
