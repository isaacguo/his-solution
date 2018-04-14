package com.isaac.pethospital.procurement.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class VendorPermissionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String uid;

    @ManyToMany(mappedBy = "permissions")
    @JsonManagedReference("permission-vendor")
    List<VendorEntity> vendors;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public List<VendorEntity> getVendors() {
        return vendors;
    }

    public void addVendor(VendorEntity vendor) {
        if (vendor == null)
            throw new RuntimeException("Vendor is null.");
        vendor.addPermission(this);
        this.vendors.add(vendor);
    }

    public void removeVendor(VendorEntity vendor) {
        if (vendor == null)
            throw new RuntimeException("Vendor is null.");
        vendor.removePermission(this);
        this.vendors.remove(vendor);
    }
}
