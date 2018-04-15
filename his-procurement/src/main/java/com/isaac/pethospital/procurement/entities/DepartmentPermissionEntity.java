package com.isaac.pethospital.procurement.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class DepartmentPermissionEntity {
    Long departmentId;
    String departmentName;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }


    @ManyToMany
    @JsonBackReference("VendorCategoryEntity-DepartmentPermissionEntity")
    List<VendorCategoryEntity> vendorCategories = new LinkedList<>();

    public List<VendorCategoryEntity> getVendorCategories() {
        return vendorCategories;
    }

    public void addVendorCategory(VendorCategoryEntity vendorCategory) {
        if (vendorCategory == null)
            throw new RuntimeException("VendorCategory is null");
        this.vendorCategories.add(vendorCategory);
    }

    public void removeVendorCategory(VendorCategoryEntity vendorCategory) {
        if (vendorCategory == null)
            throw new RuntimeException("VendorCategory is null");
        this.vendorCategories.remove(vendorCategory);
    }

}
