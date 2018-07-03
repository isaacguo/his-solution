package com.isaac.pethospital.finance.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.apache.commons.lang.StringUtils;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class ChargeCategoryEntity {

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    @JsonManagedReference("parent-children")
    List<ChargeCategoryEntity> children = new LinkedList<>();
    @ManyToOne
    @JsonBackReference("parent-children")
    ChargeCategoryEntity parent;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "chargeCategory", cascade = CascadeType.PERSIST)
    @JsonManagedReference("ChargeCategoryEntity-ChargeEntity")
    private List<ChargeEntity> chargeList = new LinkedList<>();

    public List<ChargeCategoryEntity> getChildren() {
        return children;
    }

    public ChargeCategoryEntity getParent() {
        return parent;
    }

    public void setParent(ChargeCategoryEntity parent) {
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

    public List<ChargeEntity> getChargeList() {
        return chargeList;
    }

    public void setChargeList(List<ChargeEntity> chargeList) {
        this.chargeList = chargeList;
    }

    public void addChildByName(String name) {
        if (StringUtils.isEmpty(name))
            throw new RuntimeException("ChargeCategory name is null");
        ChargeCategoryEntity de=new ChargeCategoryEntity();
        de.setName(name);
        this.addChild(de);
    }

    public void addChild(ChargeCategoryEntity child) {
        if (child == null)
            throw new RuntimeException("ChargeCategory is null");
        child.setParent(this);
        this.children.add(child);
    }
}
