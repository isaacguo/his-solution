package com.isaac.pethospital.procurement.repositories;

import com.isaac.pethospital.procurement.entities.ProcurementApprovalStageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcurementApprovalStageRepository extends JpaRepository<ProcurementApprovalStageEntity,Long> {

    ProcurementApprovalStageEntity findProcurementApprovalEntityByPreviousStageIsNull();

    ProcurementApprovalStageEntity findByStage(String stage);
}
