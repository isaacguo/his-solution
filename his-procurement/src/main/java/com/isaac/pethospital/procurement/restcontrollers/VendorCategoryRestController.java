package com.isaac.pethospital.procurement.restcontrollers;

import com.isaac.pethospital.common.security.AuthHelper;
import com.isaac.pethospital.procurement.entities.VendorCategoryEntity;
import com.isaac.pethospital.procurement.repositories.VendorProductCategoryRepository;
import com.isaac.pethospital.procurement.services.VendorCategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
