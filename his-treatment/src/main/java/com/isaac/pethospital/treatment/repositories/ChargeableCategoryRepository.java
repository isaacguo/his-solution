package com.isaac.pethospital.treatment.repositories;

import com.isaac.pethospital.treatment.entities.ChargeableCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChargeableCategoryRepository extends JpaRepository<ChargeableCategoryEntity, Long> {

}
