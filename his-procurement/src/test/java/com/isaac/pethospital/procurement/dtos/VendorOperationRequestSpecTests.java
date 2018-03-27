package com.isaac.pethospital.procurement.dtos;

import com.isaac.pethospital.procurement.entities.VendorEntity;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.RequestEntity;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class VendorOperationRequestSpecTests {

    VendorOperationRequest request;

    @Before
    public void init()
    {
        request=new VendorOperationRequest();

    }

    @Test
    public void whenUpdateVendorThenUpdateIt()
    {
        request.setName("Company2");
        VendorEntity vendor=new VendorEntity();
        vendor.setName("Company1");
        request.updateVendor(vendor);
        assertThat(vendor.getName()).isEqualToIgnoringCase("Company2");
    }
}
