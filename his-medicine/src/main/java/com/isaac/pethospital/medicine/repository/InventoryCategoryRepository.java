package com.isaac.pethospital.medicine.repository;

import com.isaac.pethospital.medicine.entities.InventoryCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryCategoryRepository extends JpaRepository<InventoryCategoryEntity,Long> {

    List<InventoryCategoryEntity> findByParentIsNull();
}
