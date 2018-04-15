package com.isaac.pethospital.procurement.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class DepartmentPermissionEntity {
    Long departmentId;
    String departmentName;

    public boolean isPermitted() {
        return permitted;
    }

    public void setPermitted(boolean permitted) {
        this.permitted = permitted;
    }

    boolean permitted;
    @ManyToOne
    @JsonBackReference("VendorCategoryEntity-DepartmentPermissionEntity")
    VendorCategoryEntity vendorCategory;
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

    public VendorCategoryEntity getVendorCategory() {
        return vendorCategory;
    }

    public void setVendorCategory(VendorCategoryEntity vendorCategory) {
        this.vendorCategory = vendorCategory;
    }
}
