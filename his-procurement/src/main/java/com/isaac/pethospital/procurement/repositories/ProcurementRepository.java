package com.isaac.pethospital.procurement.repositories;

import com.isaac.pethospital.procurement.entities.ProcurementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcurementRepository extends JpaRepository<ProcurementEntity, Long> {

}
