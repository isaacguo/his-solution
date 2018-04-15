package com.isaac.pethospital.procurement.services;

import com.isaac.pethospital.procurement.entities.VendorCategoryEntity;
import com.isaac.pethospital.procurement.repositories.VendorProductCategoryRepository;
import com.isaac.pethospital.procurement.restcontrollers.VendorCategoryRestController;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorCategoryServiceImpl implements VendorCategoryService {

    private final VendorProductCategoryRepository vendorProductCategoryRepository;

    public VendorCategoryServiceImpl(VendorProductCategoryRepository vendorProductCategoryRepository) {
        this.vendorProductCategoryRepository = vendorProductCategoryRepository;
    }

    @Override
    public List<VendorCategoryEntity> findAll() {
        return this.vendorProductCategoryRepository.findAll();
    }

    @Override
    public List<VendorCategoryEntity> findVendorProductCategoryEntityByParentIsNull() {
        return this.vendorProductCategoryRepository.findVendorProductCategoryEntityByParentIsNull();
    }

    @Override
    public VendorCategoryEntity findById(Long id) {
        return this.vendorProductCategoryRepository.findOne(id);
    }
}
