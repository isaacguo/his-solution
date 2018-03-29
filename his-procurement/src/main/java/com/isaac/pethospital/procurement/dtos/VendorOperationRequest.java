package com.isaac.pethospital.procurement.dtos;

import com.isaac.pethospital.procurement.entities.ContactEntity;
import com.isaac.pethospital.procurement.entities.VendorEntity;

import javax.validation.constraints.NotNull;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class VendorOperationRequest {

    Long id;
    @NotNull
    String name;
    String address;
    String postcode;
    String description;
    String officialWebsiteLink;
    String email;
    List<ContactOperationRequest> contacts = new LinkedList<>();

    public String getOfficialWebsiteLink() {
        return officialWebsiteLink;
    }

    public void setOfficialWebsiteLink(String officialWebsiteLink) {
        this.officialWebsiteLink = officialWebsiteLink;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<ContactOperationRequest> getContacts() {
        return contacts;
    }

    public void setContacts(List<ContactOperationRequest> contacts) {
        this.contacts = contacts;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public VendorEntity toVendor() {
        VendorEntity vendor = new VendorEntity();
        updateInternal(vendor, true);
        return vendor;
    }

    public void updateVendor(VendorEntity vendorEntity) {
        updateInternal(vendorEntity, false);
    }

    private void updateInternal(VendorEntity vendor, boolean isCreate) {
        vendor.setAddress(this.address);
        vendor.setDescription(this.description);
        vendor.setName(this.name);
        vendor.setPostcode(this.postcode);
        vendor.setEmail(this.email);
        vendor.setOfficialWebsiteLink(this.officialWebsiteLink);
        if (isCreate) {
            this.contacts.forEach(r -> {
                vendor.addContact(r.toContact());
            });
        } else {

            List<Long> idSet = this.contacts.stream().filter(c -> c.id != null).map(m -> m.id).collect(Collectors.toList());

            List<ContactEntity> interaction = vendor.getContacts().stream().filter(r -> idSet.contains(r.getId())).collect(Collectors.toList()); //intersection, to be updated
            interaction.forEach(r -> {
                this.contacts.stream().filter(c -> c.id == r.getId()).findFirst().get().updateContact(r);
            });

            //delete
            for (int i = 0; i < vendor.getContacts().size(); i++) {
                if (!interaction.contains(vendor.getContacts().get(i)))
                    vendor.deleteContact(vendor.getContacts().get(i));
            }
            //create
            this.contacts.stream().filter(c -> c.id == null).forEach(r -> {
                vendor.addContact(r.toContact());
            });

        }

    }


}
