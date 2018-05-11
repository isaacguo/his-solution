package com.isaac.pethospital.treatment.repositories;

import com.isaac.pethospital.treatment.entities.PetTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetTypeRepository extends JpaRepository<PetTypeEntity,Long> {
}
