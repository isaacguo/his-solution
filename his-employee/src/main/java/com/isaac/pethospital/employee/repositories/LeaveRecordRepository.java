package com.isaac.pethospital.employee.repositories;

import com.isaac.pethospital.employee.entities.LeaveRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRecordRepository extends JpaRepository<LeaveRecordEntity, Long> {
}
