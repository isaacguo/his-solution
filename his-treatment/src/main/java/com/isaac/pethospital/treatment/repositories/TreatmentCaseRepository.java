package com.isaac.pethospital.treatment.repositories;

import com.isaac.pethospital.treatment.entities.TreatmentCaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreatmentCaseRepository extends JpaRepository<TreatmentCaseEntity, Long> {
}
