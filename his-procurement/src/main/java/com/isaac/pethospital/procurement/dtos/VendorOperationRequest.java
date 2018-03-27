package com.isaac.pethospital.procurement.dtos;

import com.isaac.pethospital.procurement.entities.VendorEntity;

public class VendorOperationRequest {

    Long id;
    String name;
    String address;
    String postcode;
    String legalPerson;
    String description;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public VendorEntity toVendor() {
        VendorEntity vendor=new VendorEntity();
        updateInternal(vendor);
        return vendor;
    }

    private void updateInternal(VendorEntity vendor) {
        vendor.setAddress(this.address);
        vendor.setDescription(this.description);
        vendor.setLegalPerson(this.legalPerson);
        vendor.setName(this.name);
        vendor.setPostcode(this.postcode);
    }

    public void updateVendor(VendorEntity vendorEntity)
    {
        updateInternal(vendorEntity);
    }
}
