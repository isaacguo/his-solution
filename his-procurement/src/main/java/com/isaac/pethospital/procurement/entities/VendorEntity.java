package com.isaac.pethospital.procurement.entities;

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
    String legalPerson; //法人
    String description;
    String officialWebsiteLink;

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

    String email;


    @OneToMany
    List<ContactEntity> contactList = new LinkedList<>();

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

    public List<ContactEntity> getContactList() {
        return contactList;
    }

    public void addContact(ContactEntity contact) {
        if (contact == null)
            throw new RuntimeException("Contact is null");

        contact.setVendor(this);
        this.contactList.add(contact);
    }

}
