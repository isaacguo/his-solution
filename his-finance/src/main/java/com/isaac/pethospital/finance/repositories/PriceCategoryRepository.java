package com.isaac.pethospital.finance.repositories;

import com.isaac.pethospital.finance.entities.PriceCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PriceCategoryRepository extends JpaRepository<PriceCategoryEntity,Long> {

    PriceCategoryEntity findByName(String name);


    //@Query("select c.id as id, c.name as name from PriceCategoryEntity c where c.parent is null ")
    List<PriceCategoryEntity> findByParentIsNull();
}
