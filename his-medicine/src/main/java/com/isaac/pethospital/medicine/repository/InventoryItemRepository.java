package com.isaac.pethospital.medicine.repository;

import com.isaac.pethospital.medicine.entities.InventoryItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryItemRepository extends JpaRepository<InventoryItemEntity,Long> {
}
