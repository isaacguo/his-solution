package com.isaac.pethospital.procurement.repositories;

import com.isaac.pethospital.procurement.entities.ProcurementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProcurementRepository extends JpaRepository<ProcurementEntity, Long> {

    @Query("select p from ProcurementEntity p join p.procurementRequest r where r.requester = :requester")
    List<ProcurementEntity> findByRequester(@Param("requester") String requester);

}
