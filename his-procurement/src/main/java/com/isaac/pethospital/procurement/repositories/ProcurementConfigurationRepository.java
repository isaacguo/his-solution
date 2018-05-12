package com.isaac.pethospital.procurement.repositories;

import com.isaac.pethospital.procurement.entities.ProcurementConfigurationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcurementConfigurationRepository extends JpaRepository<ProcurementConfigurationEntity,Long> {
    ProcurementConfigurationEntity findByConfKey(String confKey);
}
