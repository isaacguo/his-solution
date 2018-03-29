package com.isaac.pethospital.procurement.repositories;

import com.isaac.pethospital.procurement.entities.ProcurementStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcurementStatusRepository extends JpaRepository<ProcurementStatusEntity,Long> {

    ProcurementStatusEntity findProcurementStatusEntityByParentIsNull();

}
