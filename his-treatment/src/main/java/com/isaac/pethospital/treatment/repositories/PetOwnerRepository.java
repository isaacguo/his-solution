package com.isaac.pethospital.treatment.repositories;

import com.isaac.pethospital.treatment.entities.PetOwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetOwnerRepository extends JpaRepository<PetOwnerEntity,Long> {
}
