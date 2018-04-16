package com.isaac.pethospital.procurement.repositories;

import com.isaac.pethospital.procurement.entities.VendorCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VendorCategoryRepository extends JpaRepository<VendorCategoryEntity, Long> {


    //@Query("select v.id as id, v.name as name, v.children as children from VendorCategoryEntity v join v.children where v.parent is null")
    List<VendorCategoryEntity> findVendorProductCategoryEntityByParentIsNull();

    @Query("select v from VendorCategoryEntity v join v.departments d where d.departmentId = :departmentId and d.permitted=true ")
    List<VendorCategoryEntity> findVendorCategoryEntityByDepartmentId(@Param("departmentId") Long departmentId);


}
