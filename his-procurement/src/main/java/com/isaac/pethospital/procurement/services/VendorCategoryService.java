package com.isaac.pethospital.procurement.services;

import com.isaac.pethospital.procurement.dtos.UpdateDepartmentPermissionOperationRequest;
import com.isaac.pethospital.procurement.dtos.UpdateVendorCategoryNameOperationRequest;
import com.isaac.pethospital.procurement.entities.VendorCategoryEntity;

import java.util.List;

public interface VendorCategoryService {
    List<VendorCategoryEntity> findAll();

    List<VendorCategoryEntity> findVendorProductCategoryEntityByParentIsNull();

    VendorCategoryEntity findById(Long id);

    boolean updateDepartmentPermission(UpdateDepartmentPermissionOperationRequest request);

    boolean updateVendorCategoryName(UpdateVendorCategoryNameOperationRequest request);

    List<VendorCategoryEntity> findVendorCategoryEntityByDepartmentId(Long departmentId);

    boolean createRootVendorCategory(UpdateVendorCategoryNameOperationRequest request);

    boolean deleteVendorCategory(UpdateVendorCategoryNameOperationRequest request);

}
