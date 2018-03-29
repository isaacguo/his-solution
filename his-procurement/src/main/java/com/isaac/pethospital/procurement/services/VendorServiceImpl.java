package com.isaac.pethospital.procurement.services;

import com.isaac.pethospital.procurement.dtos.VendorOperationRequest;
import com.isaac.pethospital.procurement.entities.VendorEntity;
import com.isaac.pethospital.procurement.repositories.VendorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorServiceImpl implements VendorService {

    private final VendorRepository vendorRepository;

    public VendorServiceImpl(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    @Override
    public VendorEntity createVendor(VendorOperationRequest request) {
        if (this.vendorRepository.findByName(request.getName()) == null)
            return this.vendorRepository.save(request.toVendor());
        else
            throw new RuntimeException("The Vendor with name:" + request.getName() + " has already existed");
    }

    @Override
    public boolean deleteVendor(VendorOperationRequest request) {
        if (this.vendorRepository.exists(request.getId()))
            this.vendorRepository.delete(request.getId());
        return true;
    }

    @Override
    public VendorEntity updateVendor(VendorOperationRequest request) {
        if (!this.vendorRepository.exists(request.getId()))
            throw new RuntimeException("Vendor doesn't exist");

        VendorEntity vendorEntity = this.vendorRepository.findOne(request.getId());
        request.updateVendor(vendorEntity);
        return this.vendorRepository.save(vendorEntity);

    }

    @Override
    public VendorEntity findByName(VendorOperationRequest request) {
        VendorEntity vendorEntity = this.vendorRepository.findByName(request.getName());

        if (vendorEntity == null)
            throw new RuntimeException("The Vendor with name:" + request.getName() + " doesn't existed");
        else
            return vendorEntity;
    }



    @Override
    public List<VendorEntity> findAll() {
        return this.vendorRepository.findAll();
    }

    @Override
    public VendorEntity findById(Long id) {
        return this.vendorRepository.findOne(id);
    }

    @Override
    public List<VendorEntity> findByNameContains(String keyword) {
        return this.vendorRepository.findByNameContainsIgnoreCase(keyword);
    }
}
