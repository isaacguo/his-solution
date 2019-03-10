package com.isaac.pethospital.medicine.repository;

import com.isaac.pethospital.medicine.entities.ExportSheetEntity;
import com.isaac.pethospital.medicine.entities.ImportSheetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExportSheetRepository extends JpaRepository<ExportSheetEntity,Long> {
}
