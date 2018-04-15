package com.isaac.pethospital.procurement.repositories;

import com.isaac.pethospital.procurement.entities.VendorCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VendorCategoryRepository extends JpaRepository<VendorCategoryEntity, Long> {


    //@Query("select v.id as id, v.name as name, v.children as children from VendorCategoryEntity v join v.children where v.parent is null")
    List<VendorCategoryEntity> findVendorProductCategoryEntityByParentIsNull();
}
