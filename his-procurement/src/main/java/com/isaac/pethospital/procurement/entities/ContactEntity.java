package com.isaac.pethospital.procurement.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class ContactEntity {

    String name;
    String telephone;
    @ManyToOne
    @JsonBackReference("VendorEntity-ContactEntity")
    VendorEntity vendor;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public VendorEntity getVendor() {
        return vendor;
    }

    public void setVendor(VendorEntity vendor) {
        this.vendor = vendor;
    }
}
