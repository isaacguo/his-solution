package com.isaac.pethospital.treatment.repositories;

import com.isaac.pethospital.treatment.entities.EmployeeEntity;
import com.isaac.pethospital.treatment.entities.RegistrationNumberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface RegistrationNumberRepository extends JpaRepository<RegistrationNumberEntity,Long> {
    RegistrationNumberEntity findByDoctorAndDate(EmployeeEntity doctor, LocalDate dateTime);
    List<RegistrationNumberEntity> findByDoctor(EmployeeEntity doctor);
}
