package com.isaac.pethospital.procurement.repositories;

import com.isaac.pethospital.procurement.entities.VendorProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorProductRepository extends JpaRepository<VendorProductEntity, Long> {

}
