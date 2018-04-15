package com.isaac.pethospital.procurement.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
public class VendorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String address;
    String postcode;
    String description;
    String officialWebsiteLink;
    String email;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference("VendorEntity-ContactEntity")
    List<ContactEntity> contacts = new LinkedList<>();

    /*
    public List<VendorPermissionEntity> getPermissions() {
        return permissions;
    }

    public void addPermission(VendorPermissionEntity permission) {
        if (permission == null)
            throw new RuntimeException("Permission is null");
        this.permissions.add(permission);
    }

    public void removePermission(VendorPermissionEntity permission) {
        if (permission == null)
            throw new RuntimeException("Permission is null");
        this.permissions.remove(permission);
    }

    @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference("VendorEntity-VendorCategoryEntity")
    List<VendorCategoryEntity> productCategories = new LinkedList<>();

    @ManyToMany
    @JsonBackReference("permission-vendor")
    List<VendorPermissionEntity> permissions = new LinkedList<>();


    public List<VendorCategoryEntity> getProductCategories() {
        return productCategories;
    }

    public void addProductCategory(VendorCategoryEntity productCategory) {
        if (productCategory == null)
            throw new RuntimeException("Product Category is null");
        productCategory.setVendor(this);
        this.productCategories.add(productCategory);
    }

    public void removeProductCategory(VendorCategoryEntity productCategory) {
        if (productCategory == null)
            throw new RuntimeException("Product Category is null");
        productCategory.setVendor(null);
        this.productCategories.remove(productCategory);
    }
    */

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

    public List<ContactEntity> getContacts() {
        return contacts;
    }

    public void addContact(ContactEntity contact) {
        if (contact == null)
            throw new RuntimeException("Contact is null");

        contact.setVendor(this);
        this.contacts.add(contact);
    }

    public void removeContact(ContactEntity contact) {
        if (contact == null)
            throw new RuntimeException("Contact is null");
        this.contacts.remove(contact);
        contact.setVendor(null);
    }

}
