package com.isaac.pethospital.medicine.repository;

import com.isaac.pethospital.medicine.entities.InventoryItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryItemRepository extends JpaRepository<InventoryItemEntity,Long> {

    List<InventoryItemEntity> findDistinctByNameHanYuPinYinContains(String keyword);
}
