package com.isaac.pethospital.procurement.repositories;

import com.isaac.pethospital.procurement.entities.ProcurementEntity;
import com.isaac.pethospital.procurement.entities.VendorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<VendorEntity, Long> {

    VendorEntity findByName(String name);
}
