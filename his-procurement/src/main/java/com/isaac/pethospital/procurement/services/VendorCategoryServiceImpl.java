package com.isaac.pethospital.procurement.services;

import com.isaac.pethospital.procurement.dtos.UpdateDepartmentPermissionOperationRequest;
import com.isaac.pethospital.procurement.dtos.UpdateVendorCategoryNameOperationRequest;
import com.isaac.pethospital.procurement.entities.DepartmentPermissionEntity;
import com.isaac.pethospital.procurement.entities.VendorCategoryEntity;
import com.isaac.pethospital.procurement.repositories.VendorCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendorCategoryServiceImpl implements VendorCategoryService {

    private final VendorCategoryRepository vendorCategoryRepository;

    public VendorCategoryServiceImpl(VendorCategoryRepository vendorCategoryRepository) {
        this.vendorCategoryRepository = vendorCategoryRepository;
    }

    @Override
    public List<VendorCategoryEntity> findAll() {
        return this.vendorCategoryRepository.findAll();
    }

    @Override
    public List<VendorCategoryEntity> findVendorProductCategoryEntityByParentIsNull() {
        return this.vendorCategoryRepository.findVendorProductCategoryEntityByParentIsNull();
    }

    @Override
    public VendorCategoryEntity findById(Long id) {
        return this.vendorCategoryRepository.findOne(id);
    }

    @Override
    public boolean updateDepartmentPermission(UpdateDepartmentPermissionOperationRequest request) {
        VendorCategoryEntity vce = this.vendorCategoryRepository.findOne(request.getId());
        if (vce == null)
            throw new RuntimeException("Cannot find Vendor Category");

        List<Long> leftAll = vce.getDepartments().stream().map(d -> d.getDepartmentId()).collect(Collectors.toList());
        List<Long> rightAll = request.getDepartments().stream().map(d -> d.getDepartmentId()).collect(Collectors.toList());
        List<DepartmentPermissionEntity> interaction = vce.getDepartments().stream().filter(de -> rightAll.contains(de.getDepartmentId())).collect(Collectors.toList());

        //update
        interaction.forEach(r -> {
            DepartmentPermissionEntity req = request.getDepartments().stream().filter(d -> d.getDepartmentId() == r.getDepartmentId()).findFirst().get();
            r.setPermitted(req.isPermitted());
            r.setDepartmentName(req.getDepartmentName());
        });

        List<DepartmentPermissionEntity> right = request.getDepartments().stream().filter(de -> !leftAll.contains(de.getDepartmentId())).collect(Collectors.toList());
        List<DepartmentPermissionEntity> left = vce.getDepartments().stream().filter(de -> !rightAll.contains(de.getDepartmentId())).collect(Collectors.toList());

        left.forEach(l -> vce.removeDepartment(l));
        right.forEach(r -> {
            DepartmentPermissionEntity dep = new DepartmentPermissionEntity();
            dep.setDepartmentName(r.getDepartmentName());
            dep.setDepartmentId(r.getDepartmentId());
            dep.setPermitted(r.isPermitted());
            vce.addDepartment(r);
        });

        //update
        this.vendorCategoryRepository.save(vce);

        return true;
    }

    @Override
    public boolean updateVendorCategoryName(UpdateVendorCategoryNameOperationRequest request) {

        VendorCategoryEntity vce = this.vendorCategoryRepository.findOne(request.getCategoryId());
        if (vce == null)
            throw new RuntimeException("Vendor Category is null.");
        vce.setName(request.getName());
        this.vendorCategoryRepository.save(vce);
        return true;
    }
}
