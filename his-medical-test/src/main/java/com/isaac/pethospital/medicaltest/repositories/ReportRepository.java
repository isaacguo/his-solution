package com.isaac.pethospital.medicaltest.repositories;


import com.isaac.pethospital.medicaltest.entities.ReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<ReportEntity, Long> {
}
