package com.isaac.pethospital.finance.repositories;

import com.isaac.pethospital.finance.entities.ChargeCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ChargeCategoryRepository extends JpaRepository<ChargeCategoryEntity,Long> {

    ChargeCategoryEntity findByName(String name);


    //@Query("select c.id as id, c.name as name from ChargeCategoryEntity c where c.parent is null ")
    List<ChargeCategoryEntity> findByParentIsNull();
}
