package com.isaac.pethospital.procurement.services;

import com.isaac.pethospital.procurement.entities.VendorCategoryEntity;

import java.util.List;

public interface VendorCategoryService {
    List<VendorCategoryEntity> findAll();

    List<VendorCategoryEntity> findVendorProductCategoryEntityByParentIsNull();

    VendorCategoryEntity findById(Long id);
}
