package com.isaac.pethospital.procurement.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class VendorProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    @ManyToOne
    @JsonBackReference("category-product")
    VendorProductCategoryEntity category;


    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    @JsonManagedReference("parent-children")
    List<VendorProductEntity> children = new LinkedList<>();
    @ManyToOne
    @JsonBackReference("parent-children")
    VendorProductEntity parent;
    String productEnglishName;  //产品英文名
    String productChineseName;  //产品中文名
    String orderNumber;   //订货号
    boolean productSet = false;
    String currency;
    String packageSpecification; //包装规格
    String packageUnit; //销售单位
    Double pricePerUnit;

    public VendorProductEntity getParent() {
        return parent;
    }

    public void setParent(VendorProductEntity parent) {
        this.parent = parent;
    }

    public void addChild(VendorProductEntity child) {
        if (child == null)
            throw new RuntimeException("Child Product is null.");
        child.setParent(this);
        this.children.add(child);
    }

    public void removeChild(VendorProductEntity child) {
        if (child == null)
            throw new RuntimeException("Child Product is null.");
        child.setParent(null);
        this.children.remove(child);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public VendorProductCategoryEntity getCategory() {
        return category;
    }

    public void setCategory(VendorProductCategoryEntity category) {
        this.category = category;
    }

    public String getProductEnglishName() {
        return productEnglishName;
    }

    public void setProductEnglishName(String productEnglishName) {
        this.productEnglishName = productEnglishName;
    }

    public String getProductChineseName() {
        return productChineseName;
    }

    public void setProductChineseName(String productChineseName) {
        this.productChineseName = productChineseName;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public boolean isProductSet() {
        return productSet;
    }

    public void setProductSet(boolean productSet) {
        this.productSet = productSet;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getPackageSpecification() {
        return packageSpecification;
    }

    public void setPackageSpecification(String packageSpecification) {
        this.packageSpecification = packageSpecification;
    }

    public String getPackageUnit() {
        return packageUnit;
    }

    public void setPackageUnit(String packageUnit) {
        this.packageUnit = packageUnit;
    }

    public Double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(Double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }
}
