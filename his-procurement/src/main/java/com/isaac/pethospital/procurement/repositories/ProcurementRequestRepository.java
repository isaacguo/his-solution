package com.isaac.pethospital.procurement.repositories;

import com.isaac.pethospital.procurement.entities.ProcurementRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcurementRequestRepository extends JpaRepository<ProcurementRequestEntity,Long> {
}
