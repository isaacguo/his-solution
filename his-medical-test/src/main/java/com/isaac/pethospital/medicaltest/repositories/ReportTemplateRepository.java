package com.isaac.pethospital.medicaltest.repositories;

import com.isaac.pethospital.medicaltest.entities.ReportTemplateEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportTemplateRepository extends JpaRepository<ReportTemplateEntity,Long> {
}
