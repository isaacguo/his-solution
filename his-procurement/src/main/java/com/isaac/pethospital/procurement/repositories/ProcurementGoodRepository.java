package com.isaac.pethospital.procurement.repositories;

import com.isaac.pethospital.procurement.entities.ProcurementGoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcurementGoodRepository extends JpaRepository<ProcurementGoodEntity, Long> {
}
