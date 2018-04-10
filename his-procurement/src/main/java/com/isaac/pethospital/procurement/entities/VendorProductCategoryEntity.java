package com.isaac.pethospital.procurement.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class VendorProductCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    @JsonManagedReference("parent-children")
    List<VendorProductCategoryEntity> children = new LinkedList<>();
    @ManyToOne
    @JsonBackReference("parent-children")
    VendorProductCategoryEntity parent;
    @OneToMany(mappedBy = "category", cascade = CascadeType.PERSIST)
    @JsonManagedReference("category-product")
    List<VendorProductEntity> products = new LinkedList<>();
    @ManyToOne
    @JsonBackReference("VendorEntity-VendorProductCategoryEntity")
    VendorEntity vendor;
    String name;

    public VendorEntity getVendor() {
        return vendor;
    }

    public void setVendor(VendorEntity vendor) {
        this.vendor = vendor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VendorProductCategoryEntity getParent() {
        return parent;
    }

    public void setParent(VendorProductCategoryEntity parent) {
        this.parent = parent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<VendorProductCategoryEntity> getChildren() {
        return children;
    }

    public void addChild(VendorProductCategoryEntity child) {
        if (child == null)
            throw new RuntimeException("Category Child is Null.");
        child.setParent(this);

        this.children.add(child);
    }

    public void removeChild(VendorProductCategoryEntity child) {
        if (child == null)
            throw new RuntimeException("Category Child is Null.");
        child.setParent(null);
        this.children.remove(child);
    }

    public List<VendorProductEntity> getProducts() {
        return products;
    }

    public void addProduct(VendorProductEntity product) {
        if (product == null)
            throw new RuntimeException("Product is Null.");
        product.setCategory(this);
        this.products.add(product);
    }

    public void removeProduct(VendorProductEntity product) {
        if (product == null)
            throw new RuntimeException("Product is Null.");
        product.setCategory(null);
        this.products.remove(product);
    }


}
