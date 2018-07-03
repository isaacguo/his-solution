package com.isaac.pethospital.finance.repositories;

import com.isaac.pethospital.finance.entities.ChargeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChargeRepository extends JpaRepository<ChargeEntity,Long> {
}
