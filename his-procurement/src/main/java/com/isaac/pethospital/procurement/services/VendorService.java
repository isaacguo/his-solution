package com.isaac.pethospital.procurement.services;

import com.isaac.pethospital.procurement.dtos.VendorOperationRequest;
import com.isaac.pethospital.procurement.entities.VendorEntity;

import java.util.List;

public interface VendorService {


    VendorEntity createVendor(VendorOperationRequest request);

    boolean deleteVendor(VendorOperationRequest request);

    VendorEntity updateVendor(VendorOperationRequest request);

    VendorEntity findByName(VendorOperationRequest request);

    List<VendorEntity> findAll();

    VendorEntity findById(Long id);

    List<VendorEntity> findByNameContains(String keyword);

    List<VendorEntity> findPermittedAll(String userAccount);
}
