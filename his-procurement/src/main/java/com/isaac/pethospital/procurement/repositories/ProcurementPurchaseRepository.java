package com.isaac.pethospital.procurement.repositories;

import com.isaac.pethospital.procurement.entities.ProcurementPurchaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcurementPurchaseRepository extends JpaRepository<ProcurementPurchaseEntity,Long> {
}
