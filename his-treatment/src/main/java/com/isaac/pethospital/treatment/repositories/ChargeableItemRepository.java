package com.isaac.pethospital.treatment.repositories;

import com.isaac.pethospital.treatment.entities.ChargeableItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ChargeableItemRepository extends JpaRepository<ChargeableItemEntity, Long> {
}
