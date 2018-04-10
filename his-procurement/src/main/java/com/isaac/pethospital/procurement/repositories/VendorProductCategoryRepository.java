package com.isaac.pethospital.procurement.repositories;

import com.isaac.pethospital.procurement.entities.VendorProductCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorProductCategoryRepository extends JpaRepository<VendorProductCategoryEntity, Long> {
}
