package com.isaac.pethospital.procurement.repositories;

import com.isaac.pethospital.procurement.entities.ProcurementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ProcurementRepository extends JpaRepository<ProcurementEntity, Long> {

    @Query("select p from ProcurementEntity p join p.procurementRequest r where r.requester = :requester")
    List<ProcurementEntity> findByRequester(@Param("requester") String requester);

    @Query("select p from ProcurementEntity p join p.procurementPurchase r where r.assignTo = :assignee")
    List<ProcurementEntity> findMyProcurementByPurchaseByAssignee(@Param("assignee") String assignee);

    @Query("select p from ProcurementEntity p join p.procurementRequest r where r.submittedData >= :startDate and r.submittedData <= :endDate")
    List<ProcurementEntity> findByQuery(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);

}
