package com.isaac.pethospital.treatment.repositories;

import com.isaac.pethospital.treatment.entities.PetCaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetCaseRepository extends JpaRepository<PetCaseEntity, Long> {
}
