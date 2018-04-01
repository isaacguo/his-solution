package com.isaac.pethospital.procurement.repositories;

import com.isaac.pethospital.procurement.entities.ProcurementApprovalEntity;
import com.isaac.pethospital.procurement.entities.ProcurementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProcurementApprovalRepository extends JpaRepository<ProcurementApprovalEntity, Long> {

    List<ProcurementApprovalEntity> findByReviewerAndReviewedIsFalse(String userAccount);
    ProcurementApprovalEntity findByProcurementAndReviewer(ProcurementEntity procurement, String reviewer);

}

