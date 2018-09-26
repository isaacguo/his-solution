package com.isaac.pethospital.treatment.repositories;

import com.isaac.pethospital.treatment.entities.ChargeableItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ChargeableItemRepository extends JpaRepository<ChargeableItemEntity, Long> {
    List<ChargeableItemEntity> findDistinctByNameHanYuPinYinContains(String keyword);
}
