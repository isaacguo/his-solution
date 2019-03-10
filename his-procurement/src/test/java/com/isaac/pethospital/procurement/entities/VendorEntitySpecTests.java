package com.isaac.pethospital.procurement.entities;


import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;


public class VendorEntitySpecTests {


    VendorEntity vendorEntity;

    @Before
    public void init()
    {
        this.vendorEntity = new VendorEntity();
    }


    @Test
    public void givenVendorEntityThenHasFieldLong()
    {
        assertThat(this.vendorEntity, hasProperty("id"));
    }

    @Test
    public void givenVendorEntityThenHasFieldName()
    {
        assertThat(this.vendorEntity, hasProperty("name"));
    }

    @Test
    public void givenVendorEntityThenHasFieldAddress()
    {
        assertThat(this.vendorEntity, hasProperty("address"));
    }

    @Test
    public void givenVendorEntityThenHasFieldPostcode()
    {
        assertThat(this.vendorEntity, hasProperty("postcode"));
    }

    @Test
    public void givenVendorEntityThenHasFieldDescription()
    {
        assertThat(this.vendorEntity, hasProperty("description"));
    }

    @Test
    public void givenVendorEntityThenHasFieldContactList()
    {
        assertThat(this.vendorEntity, hasProperty("contacts"));
    }

}
