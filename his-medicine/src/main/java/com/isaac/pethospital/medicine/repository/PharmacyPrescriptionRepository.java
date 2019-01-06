package com.isaac.pethospital.medicine.repository;

import com.isaac.pethospital.medicine.entities.PharmacyPrescriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacyPrescriptionRepository extends JpaRepository<PharmacyPrescriptionEntity,Long> {
}
