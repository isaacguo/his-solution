package com.isaac.pethospital.procurement.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class ContactEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String name;

    @ElementCollection
    List<String> cellphone;

    @ManyToOne
    VendorEntity vendor;

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

    public List<String> getCellphone() {
        return cellphone;
    }

    public void setCellphone(List<String> cellphone) {
        this.cellphone = cellphone;
    }

    public VendorEntity getVendor() {
        return vendor;
    }

    public void setVendor(VendorEntity vendor) {
        this.vendor = vendor;
    }
}
