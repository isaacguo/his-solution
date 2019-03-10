package com.isaac.pethospital.gateway.repositories;

import com.isaac.pethospital.gateway.entities.DatabaseOperationRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatabaseOperationRecordRepository extends JpaRepository<DatabaseOperationRecordEntity, Long> {
}
