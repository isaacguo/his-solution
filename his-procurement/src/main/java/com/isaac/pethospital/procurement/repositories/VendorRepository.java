package com.isaac.pethospital.procurement.repositories;

import com.isaac.pethospital.procurement.entities.ProcurementEntity;
import com.isaac.pethospital.procurement.entities.VendorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VendorRepository extends JpaRepository<VendorEntity, Long> {

    VendorEntity findByName(String name);

    List<VendorEntity> findByNameContainsIgnoreCase(String keyword);


    @Query("select v from VendorEntity v join v.vendorCategory c join c.departments d where :departmentId = d.departmentId and d.permitted=true")
    List<VendorEntity> findPermittedAll(@Param("departmentId") Long departmentId);


}
