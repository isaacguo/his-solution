package com.isaac.pethospital.medicine.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class InventoryCategoryEntity {


    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    @JsonManagedReference("parent-children")
    List<InventoryCategoryEntity> children = new LinkedList<>();
    @ManyToOne
    @JsonBackReference("parent-children")
    InventoryCategoryEntity parent;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.PERSIST)
    @JsonManagedReference("InventoryCategoryEntity-InventoryItemEntity")
    private List<InventoryItemEntity> inventoryItemList = new LinkedList<>();

    public List<InventoryCategoryEntity> getChildren() {
        return children;
    }

    public void addChild(InventoryCategoryEntity child) {
        if (children == null)
            throw new RuntimeException("child is null");
        child.setParent(this);
        this.children.add(child);
    }

    public void removeChild(InventoryCategoryEntity child) {
        if (children == null)
            throw new RuntimeException("child is null");
        child.setParent(null);
        this.children.remove(child);
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

    public void addInventorItem(InventoryItemEntity inventoryItem) {
        if (inventoryItem == null)
            throw new RuntimeException("Template is null");
        inventoryItem.setCategory(this);
        this.inventoryItemList.add(inventoryItem);
    }

    public void removeReportTemplate(InventoryItemEntity inventoryItem) {
        if (inventoryItem == null)
            throw new RuntimeException("Template is null");
        inventoryItem.setCategory(null);
        this.inventoryItemList.remove(inventoryItem);
    }


}
