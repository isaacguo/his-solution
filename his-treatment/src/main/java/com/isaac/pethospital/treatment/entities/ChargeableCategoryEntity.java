package com.isaac.pethospital.treatment.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class ChargeableCategoryEntity {

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    @JsonManagedReference("parent-children")
    List<ChargeableCategoryEntity> children = new LinkedList<>();
    @ManyToOne
    @JsonBackReference("parent-children")
    ChargeableCategoryEntity parent;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.PERSIST)
    @JsonManagedReference("ChargeableCategoryEntity-ChargeableItemEntity")
    private List<ChargeableItemEntity> chargeableItemList = new LinkedList<>();

    public List<ChargeableCategoryEntity> getChildren() {
        return children;
    }

    public void addChild(ChargeableCategoryEntity child) {
        if (children == null)
            throw new RuntimeException("child is null");
        child.setParent(this);
        this.children.add(child);
    }

    public void removeChild(ChargeableCategoryEntity child) {
        if (children == null)
            throw new RuntimeException("child is null");
        child.setParent(null);
        this.children.remove(child);
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

    public List<ChargeableItemEntity> getChargeableItemList() {
        return chargeableItemList;
    }

    public void addChargeableItem(ChargeableItemEntity chargeableItem) {
        if (chargeableItem == null)
            throw new RuntimeException("Template is null");
        chargeableItem.setCategory(this);
        this.chargeableItemList.add(chargeableItem);
    }

    public void removeReportTemplate(ChargeableItemEntity chargeableItem) {
        if (chargeableItem == null)
            throw new RuntimeException("Template is null");
        chargeableItem.setCategory(null);
        this.chargeableItemList.remove(chargeableItem);
    }


}
