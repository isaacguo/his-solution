package com.isaac.pethospital.medicine.repository;

import com.isaac.pethospital.medicine.entities.MedicineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<MedicineEntity, Long> {
}
