package com.isaac.pethospital.medicaltest.repositories;

import com.isaac.pethospital.medicaltest.entities.ReportTemplateCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReportTemplateCategoryRepository extends JpaRepository<ReportTemplateCategoryEntity, Long> {

    List<ReportTemplateCategoryEntity> findByParentIsNull();
}
