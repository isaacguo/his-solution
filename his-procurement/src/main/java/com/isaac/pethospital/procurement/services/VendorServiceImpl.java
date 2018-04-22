package com.isaac.pethospital.procurement.services;

import com.isaac.pethospital.procurement.dtos.VendorOperationRequest;
import com.isaac.pethospital.procurement.entities.VendorCategoryEntity;
import com.isaac.pethospital.procurement.entities.VendorEntity;
import com.isaac.pethospital.procurement.feignservices.EmployeeFeignService;
import com.isaac.pethospital.procurement.repositories.VendorRepository;
import com.isaac.pethospital.procurement.restcontrollers.VendorCategoryRestController;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorServiceImpl implements VendorService {

    private final VendorRepository vendorRepository;
    private final EmployeeFeignService employeeFeignService;
    private final VendorCategoryService vendorCategoryService;

    public VendorServiceImpl(VendorRepository vendorRepository, EmployeeFeignService employeeFeignService, VendorCategoryService vendorCategoryService) {
        this.vendorRepository = vendorRepository;
        this.employeeFeignService = employeeFeignService;
        this.vendorCategoryService = vendorCategoryService;
    }

    @Override
    public VendorEntity createVendor(VendorOperationRequest request) {
        if (this.vendorRepository.findByName(request.getName()) == null) {
            VendorEntity ve=request.toVendor();
            VendorCategoryEntity vce=this.vendorCategoryService.findById(request.getCategoryId());
            if(vce==null)
                throw new RuntimeException("Cannot find Vendor Category");
            ve.setVendorCategory(vce);
            return this.vendorRepository.save(ve);
        }
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

    @Override
    public List<VendorEntity> findPermittedAll(String userAccount) {

        Long departmentId = employeeFeignService.getDepartmentId(userAccount);
        if (departmentId < 0)
            throw new RuntimeException("Departement cannot not be found. Error Code:" + departmentId);

        return this.vendorRepository.findPermittedAll(departmentId);
    }

    @Override
    public boolean moveVendor(VendorOperationRequest request) {
        VendorCategoryEntity vce = this.vendorCategoryService.findById(request.getCategoryId());
        if (vce == null)
            throw new RuntimeException("Vendor Category cannot be found");

        if (!this.vendorRepository.exists(request.getId()))
            throw new RuntimeException("Vendor doesn't exist");

        VendorEntity vendorEntity = this.vendorRepository.findOne(request.getId());
        vendorEntity.setVendorCategory(vce);
        this.vendorRepository.save(vendorEntity);
        return true;
    }
}
