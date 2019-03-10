package com.isaac.pethospital.finance.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.apache.commons.lang.StringUtils;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class PriceCategoryEntity {

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    @JsonManagedReference("parent-children")
    List<PriceCategoryEntity> children = new LinkedList<>();
    @ManyToOne
    @JsonBackReference("parent-children")
    PriceCategoryEntity parent;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "chargeCategory", cascade = CascadeType.PERSIST)
    @JsonManagedReference("PriceCategoryEntity-PriceEntity")
    private List<PriceEntity> chargeList = new LinkedList<>();

    public List<PriceCategoryEntity> getChildren() {
        return children;
    }

    public PriceCategoryEntity getParent() {
        return parent;
    }

    public void setParent(PriceCategoryEntity parent) {
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

    public List<PriceEntity> getChargeList() {
        return chargeList;
    }

    public void setChargeList(List<PriceEntity> chargeList) {
        this.chargeList = chargeList;
    }

    public void addChildByName(String name) {
        if (StringUtils.isEmpty(name))
            throw new RuntimeException("ChargeCategory name is null");
        PriceCategoryEntity de=new PriceCategoryEntity();
        de.setName(name);
        this.addChild(de);
    }

    public void addChild(PriceCategoryEntity child) {
        if (child == null)
            throw new RuntimeException("ChargeCategory is null");
        child.setParent(this);
        this.children.add(child);
    }
}
