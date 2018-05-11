package com.isaac.pethospital.procurement.repositories;

import com.isaac.pethospital.procurement.entities.ProcurementPurchaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProcurementPurchaseRepository extends JpaRepository<ProcurementPurchaseEntity,Long> {

    List<ProcurementPurchaseEntity> findByAssignTo(String assignTo);
}
