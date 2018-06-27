package com.isaac.pethospital.medicaltest.repositories;

import com.isaac.pethospital.medicaltest.dtos.ReportTemplateIdAndNameResponse;
import com.isaac.pethospital.medicaltest.entities.ReportTemplateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReportTemplateRepository extends JpaRepository<ReportTemplateEntity,Long> {

    List<ReportTemplateEntity> findByReportNameContains(@Param("name") String name);
}
