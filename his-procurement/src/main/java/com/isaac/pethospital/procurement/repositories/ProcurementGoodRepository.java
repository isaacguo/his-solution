package com.isaac.pethospital.procurement.repositories;

import com.isaac.pethospital.procurement.entities.ProcurementRequestGoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcurementGoodRepository extends JpaRepository<ProcurementRequestGoodEntity, Long> {
}
