package com.isaac.pethospital.procurement.services;

import com.isaac.pethospital.procurement.dtos.UpdateDepartmentPermissionOperationRequest;
import com.isaac.pethospital.procurement.entities.VendorCategoryEntity;
import com.isaac.pethospital.procurement.repositories.ProcurementStatusRepository;
import com.isaac.pethospital.procurement.repositories.VendorCategoryRepository;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class VendorCategoryServiceSpecTests {

    VendorCategoryService vendorCategoryService;
    VendorCategoryRepository vendorCategoryRepository;

    @Before
    public void before() {
        this.vendorCategoryRepository = mock(VendorCategoryRepository.class);
        this.vendorCategoryService = spy(new VendorCategoryServiceImpl(this.vendorCategoryRepository));
    }

    @Test
    public void whenUpdateDepartmentPermissionThenFindCategory()
    {
        //given
        doReturn(new VendorCategoryEntity()).when(this.vendorCategoryRepository).findOne(any(Long.class));
        //when
        this.vendorCategoryService.updateDepartmentPermission(any(UpdateDepartmentPermissionOperationRequest.class));
        //then
        verify(this.vendorCategoryRepository,times(1)).findOne(any(Long.class));

    }

}
