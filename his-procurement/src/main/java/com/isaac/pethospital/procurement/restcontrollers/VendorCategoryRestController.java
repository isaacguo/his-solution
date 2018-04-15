package com.isaac.pethospital.procurement.restcontrollers;

import com.isaac.pethospital.common.security.AuthHelper;
import com.isaac.pethospital.procurement.dtos.UpdateDepartmentPermissionOperationRequest;
import com.isaac.pethospital.procurement.dtos.UpdateVendorCategoryNameOperationRequest;
import com.isaac.pethospital.procurement.entities.VendorCategoryEntity;
import com.isaac.pethospital.procurement.services.VendorCategoryService;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
public class VendorCategoryRestController {

    private final VendorCategoryService vendorCategoryService;
    private final AuthHelper authHelper;

    public VendorCategoryRestController(VendorCategoryService vendorCategoryService, AuthHelper authHelper) {
        this.vendorCategoryService = vendorCategoryService;
        this.authHelper = authHelper;
    }

    @GetMapping("list")
    List<VendorCategoryEntity> findAllForList() {
        return this.vendorCategoryService.findVendorProductCategoryEntityByParentIsNull();
    }

    @GetMapping("{id}")
    VendorCategoryEntity findById(@PathVariable("id") Long id) {
        return this.vendorCategoryService.findById(id);
    }

    @GetMapping
    List<VendorCategoryEntity> findAll() {
        return this.vendorCategoryService.findAll();
    }

    @PostMapping("updateDepartmentPermission")
    public boolean updateDepartmentPermission(@RequestBody UpdateDepartmentPermissionOperationRequest request)
    {
        return this.vendorCategoryService.updateDepartmentPermission(request);
    }

    @PostMapping("updateVendorCategoryName")
    public boolean updateVendorCategoryName(@RequestBody UpdateVendorCategoryNameOperationRequest request)
    {
        return this.vendorCategoryService.updateVendorCategoryName(request);
    }



}
