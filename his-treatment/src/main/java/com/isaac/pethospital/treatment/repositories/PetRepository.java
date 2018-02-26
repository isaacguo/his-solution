package com.isaac.pethospital.treatment.repositories;

import com.isaac.pethospital.treatment.entities.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<PetEntity,Long> {
    List<PetEntity> findByName(String name);
}
