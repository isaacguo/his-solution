package com.isaac.pethospital.procurement.dtos;

import com.isaac.pethospital.procurement.entities.ContactEntity;
import com.isaac.pethospital.procurement.entities.VendorEntity;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class VendorOperationRequestSpecTests {

    VendorOperationRequest request;

    @Before
    public void init() {
        request = new VendorOperationRequest();

    }

    @Test
    public void whenUpdateVendorThenUpdateIt() {
        request.setName("Company2");
        VendorEntity vendor = new VendorEntity();
        vendor.setName("Company1");
        request.updateVendor(vendor);
        assertThat(vendor.getName()).isEqualToIgnoringCase("Company2");
    }

    @Test
    public void givenVendorEntityWhenUpdateThenContactsShouldBeUpdatedCorrectly() {
        //given
        VendorEntity vendorEntity = new VendorEntity();
        addContact(vendorEntity, 1L, "C1", "CT1");
        addContact(vendorEntity, 2L, "C2", "CT2");

        List<ContactOperationRequest> contactList=new LinkedList<>();
        ContactOperationRequest contact2=new ContactOperationRequest();
        addContactRequest(contactList, contact2, 2L, "CC2", "CTT2");

        ContactOperationRequest contact3=new ContactOperationRequest();
        addContactRequest(contactList, contact3, null, "C3", "CT3");
        request.setContacts(contactList);


        //when
        request.updateVendor(vendorEntity);

        //then
        assertThat(vendorEntity.getContacts()).hasSize(2);
        assertThat(vendorEntity.getContacts().get(0).getName()).isEqualToIgnoringCase("CC2");
        assertThat(vendorEntity.getContacts().get(1).getName()).isEqualToIgnoringCase("C3");

    }

    private void addContactRequest(List<ContactOperationRequest> contactList, ContactOperationRequest contact2, Long l, String cc2, String ctt2) {
        contact2.setId(l);
        contact2.setName(cc2);
        contact2.setTelephone(ctt2);
        contactList.add(contact2);
    }

    private void addContact(VendorEntity vendorEntity, long l, String c22, String ct2) {
        ContactEntity c2 = new ContactEntity();
        c2.setId(l);
        c2.setName(c22);
        c2.setTelephone(ct2);
        vendorEntity.addContact(c2);
    }
}
