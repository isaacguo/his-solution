package com.isaac.pethospital.treatment.repositories;

import com.isaac.pethospital.treatment.entities.ChargeableCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChargeableCategoryRepository extends JpaRepository<ChargeableCategoryEntity, Long> {

    List<ChargeableCategoryEntity> findByParentIsNull();
    ChargeableCategoryEntity findByName(String name);

}
