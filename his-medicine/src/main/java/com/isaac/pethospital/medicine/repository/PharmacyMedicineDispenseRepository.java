package com.isaac.pethospital.medicine.repository;

import com.isaac.pethospital.medicine.entities.PharmacyMedicineDispenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacyMedicineDispenseRepository extends JpaRepository<PharmacyMedicineDispenseEntity,Long> {
}
