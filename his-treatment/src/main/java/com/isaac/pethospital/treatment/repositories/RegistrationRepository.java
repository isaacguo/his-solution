package com.isaac.pethospital.treatment.repositories;

import com.isaac.pethospital.treatment.entities.EmployeeEntity;
import com.isaac.pethospital.treatment.entities.RegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface RegistrationRepository extends JpaRepository<RegistrationEntity, Long> {
    List<RegistrationEntity> findByDoctor(EmployeeEntity doctor);

    List<RegistrationEntity> findByDoctorAndBookDateAfter(EmployeeEntity doctor, LocalDateTime localDateTime);

    List<RegistrationEntity> findByBookDateBetween(LocalDateTime start, LocalDateTime end);
}
