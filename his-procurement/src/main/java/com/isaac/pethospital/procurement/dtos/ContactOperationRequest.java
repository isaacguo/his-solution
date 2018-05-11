package com.isaac.pethospital.procurement.dtos;

import com.isaac.pethospital.procurement.entities.ContactEntity;

import javax.validation.constraints.NotNull;
import java.util.List;

public class ContactOperationRequest {

    Long id;
    @NotNull
    String name;
    @NotNull
    String telephone;

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

    public ContactEntity toContact() {
        ContactEntity contact = new ContactEntity();
        updateInternal(contact);
        return contact;
    }

    private void updateInternal(ContactEntity contact) {
        contact.setName(this.name);
        contact.setTelephone(this.telephone);
    }

    public void updateContact(ContactEntity contact) {
        updateInternal(contact);
    }
}

