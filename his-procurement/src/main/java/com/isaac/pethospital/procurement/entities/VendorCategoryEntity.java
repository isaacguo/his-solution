package com.isaac.pethospital.procurement.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.isaac.pethospital.procurement.dtos.DepartmentIdAndName;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class VendorCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    @JsonManagedReference("parent-children")
    List<VendorCategoryEntity> children = new LinkedList<>();
    @ManyToOne
    @JsonBackReference("parent-children")
    VendorCategoryEntity parent;
    @OneToMany(mappedBy = "vendorCategory")
    @JsonManagedReference("VendorEntity-VendorCategoryEntity")
    List<VendorEntity> vendors = new LinkedList<>();
    @ManyToMany(mappedBy = "vendorCategories")
    @JsonManagedReference("VendorCategoryEntity-DepartmentPermissionEntity")
    List<DepartmentPermissionEntity> departments = new LinkedList<>();

    public List<VendorEntity> getVendors() {
        return vendors;
    }

    public void addVendor(VendorEntity vendor) {
        if (vendor == null)
            throw new RuntimeException("Vendor is null");
        vendor.setVendorCategory(this);
        this.vendors.add(vendor);
    }

    public void removeVendor(VendorEntity vendor) {
        if (vendor == null)
            throw new RuntimeException("Vendor is null");
        vendor.setVendorCategory(null);
        this.vendors.remove(vendor);
    }

    public List<DepartmentPermissionEntity> getDepartments() {
        return departments;
    }

    public void addDepartment(DepartmentPermissionEntity department) {
        if (department == null)
            throw new RuntimeException("Department is null");
        department.addVendorCategory(this);
        this.departments.add(department);
    }


    public void removeDepartment(DepartmentPermissionEntity department) {
        if (department == null)
            throw new RuntimeException("Department is null");
        department.removeVendorCategory(this);
        this.departments.remove(department);
    }


    /*
    @OneToMany(mappedBy = "category", cascade = CascadeType.PERSIST)
    @JsonManagedReference("category-product")
    List<VendorProductEntity> products = new LinkedList<>();
    */

    public void addChildByName(String name) {
        VendorCategoryEntity vendorCategoryEntity = new VendorCategoryEntity();
        vendorCategoryEntity.setName(name);
        this.addChild(vendorCategoryEntity);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VendorCategoryEntity getParent() {
        return parent;
    }

    public void setParent(VendorCategoryEntity parent) {
        this.parent = parent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<VendorCategoryEntity> getChildren() {
        return children;
    }

    public void addChild(VendorCategoryEntity child) {
        if (child == null)
            throw new RuntimeException("Category Child is Null.");
        child.setParent(this);

        this.children.add(child);
    }

    public void removeChild(VendorCategoryEntity child) {
        if (child == null)
            throw new RuntimeException("Category Child is Null.");
        child.setParent(null);
        this.children.remove(child);
    }

    /*
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
    */


}
