package com.isaac.pethospital.procurement.repositories;

import com.isaac.pethospital.procurement.entities.ProcurementApprovalEntity;
import com.isaac.pethospital.procurement.entities.ProcurementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProcurementApprovalRepository extends JpaRepository<ProcurementApprovalEntity, Long> {

    List<ProcurementApprovalEntity> findByReviewerAndReviewedIsFalse(String userAccount);

    ProcurementApprovalEntity findByProcurementAndReviewer(ProcurementEntity procurement, String reviewer);

    @Query("SELECT COUNT(p) FROM ProcurementApprovalEntity p WHERE p.reviewer = :userAccount AND p.reviewed = false")
    Long findMyUnfinishedApprovalProcurementsCount(@Param("userAccount") String userAccount);
}

