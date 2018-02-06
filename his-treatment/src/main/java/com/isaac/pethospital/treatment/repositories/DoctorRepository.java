package com.isaac.pethospital.treatment.repositories;

import com.isaac.pethospital.treatment.entities.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<DoctorEntity,Long> {
}
