package com.isaac.pethospital.treatment.repositories;

import com.isaac.pethospital.treatment.entities.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<PetEntity,Long> {
}
