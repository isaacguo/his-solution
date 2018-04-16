package com.isaac.pethospital.procurement.services;

import com.isaac.pethospital.procurement.dtos.VendorOperationRequest;
import com.isaac.pethospital.procurement.entities.VendorEntity;
import com.isaac.pethospital.procurement.feignservices.EmployeeFeignService;
import com.isaac.pethospital.procurement.repositories.VendorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorServiceImpl implements VendorService {

    private final VendorRepository vendorRepository;
    private final EmployeeFeignService employeeFeignService;

    public VendorServiceImpl(VendorRepository vendorRepository, EmployeeFeignService employeeFeignService) {
        this.vendorRepository = vendorRepository;
        this.employeeFeignService = employeeFeignService;
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

    @Override
    public List<VendorEntity> findPermittedAll(String userAccount) {

        Long departmentId=employeeFeignService.getDepartmentId(userAccount);
        if(departmentId<0)
            throw new RuntimeException("Departement cannot not be found. Error Code:" + departmentId);

        return this.vendorRepository.findPermittedAll(departmentId);
    }
}
