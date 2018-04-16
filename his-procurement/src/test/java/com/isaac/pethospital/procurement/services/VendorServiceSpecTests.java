package com.isaac.pethospital.procurement.services;

import com.isaac.pethospital.procurement.dtos.VendorOperationRequest;
import com.isaac.pethospital.procurement.entities.VendorEntity;
import com.isaac.pethospital.procurement.feignservices.EmployeeFeignService;
import com.isaac.pethospital.procurement.repositories.VendorRepository;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class VendorServiceSpecTests {

    VendorRepository vendorRepository;
    VendorService vendorService;
    EmployeeFeignService employeeFeignService;

    @Before
    public void before() {
        this.vendorRepository = mock(VendorRepository.class);
        this.employeeFeignService = mock(EmployeeFeignService.class);
        this.vendorService = spy(new VendorServiceImpl(this.vendorRepository, this.employeeFeignService));
    }

    @Test
    public void givenVendorOperationRequestThenCreateVendorEntity() {
        //given
        VendorOperationRequest vendorOperationRequest = new VendorOperationRequest();
        vendorOperationRequest.setName("Company");
        doReturn(null).when(vendorRepository).findByName("Company");
        //when
        this.vendorService.createVendor(vendorOperationRequest);
        //then
        verify(vendorRepository, times(1)).findByName("Company");
        verify(vendorRepository, times(1)).save(any(VendorEntity.class));
    }

    @Test
    public void givenVendorOperationRequestThenDeleteVendorEntity() {
        //given
        VendorOperationRequest vendorOperationRequest = new VendorOperationRequest();
        vendorOperationRequest.setId(1L);
        doReturn(true).when(vendorRepository).exists(1L);
        //when
        this.vendorService.deleteVendor(vendorOperationRequest);
        //then
        verify(vendorRepository, times(1)).exists(1L);
        verify(vendorRepository, times(1)).delete(1L);
    }

    @Test
    public void givenVendorOperationRequestThenUpdateVendorEntity() {
        //given
        VendorOperationRequest vendorOperationRequest = new VendorOperationRequest();
        vendorOperationRequest.setName("Company");
        vendorOperationRequest.setId(1L);
        doReturn(true).when(vendorRepository).exists(1L);
        doReturn(new VendorEntity()).when(vendorRepository).findOne(1L);
        //when
        this.vendorService.updateVendor(vendorOperationRequest);
        //then
        verify(vendorRepository, times(1)).exists(1L);
        verify(vendorRepository, times(1)).save(any(VendorEntity.class));
    }

    @Test
    public void givenVendorOperationRequestThenFindVendorEntityByName() {
        //given
        VendorOperationRequest vendorOperationRequest = new VendorOperationRequest();
        vendorOperationRequest.setName("Company");
        doReturn(new VendorEntity()).when(vendorRepository).findByName("Company");
        //when
        this.vendorService.findByName(vendorOperationRequest);
        //then
        verify(vendorRepository, times(1)).findByName("Company");
    }


    @Test
    public void givenKeywordStringWhenFindByNameContainsKeywordThenReturnList() {
        //given
        String keyword = "com";
        doReturn(new LinkedList<VendorEntity>()).when(vendorRepository).findByNameContainsIgnoreCase("com");
        //when
        this.vendorService.findByNameContains(keyword);
        //then
        verify(vendorRepository, times(1)).findByNameContainsIgnoreCase("com");
    }

}
