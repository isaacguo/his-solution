package com.isaac.pethospital.procurement.repositories;

import com.isaac.pethospital.procurement.entities.VendorPermissionEntity;
import com.isaac.pethospital.procurement.entities.VendorProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorPermissionRepository extends JpaRepository<VendorPermissionEntity, Long> {

    VendorPermissionEntity findVendorProductEntityByUid(String id);

}
