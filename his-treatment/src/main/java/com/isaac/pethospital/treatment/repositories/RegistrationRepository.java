package com.isaac.pethospital.treatment.repositories;

import com.isaac.pethospital.treatment.common.enums.RegistrationStatusEnum;
import com.isaac.pethospital.treatment.dtos.RegistrationResponse;
import com.isaac.pethospital.treatment.entities.EmployeeEntity;
import com.isaac.pethospital.treatment.entities.RegistrationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface RegistrationRepository extends JpaRepository<RegistrationEntity, Long> {
    List<RegistrationEntity> findByDoctor(EmployeeEntity doctor);


    List<RegistrationEntity> findByDoctorAndBookDateAfter(EmployeeEntity doctor, LocalDateTime localDateTime);

    @Query("select r.id as rid, r.indexOfDay as indexOfDay, p.id as pid, p.name as petName, o.name as petOwnerName, r.registrationStatus as registrationStatus from RegistrationEntity r join r.pet p join p.petOwner as o where r.doctor=:doctor and r.bookDate>=:bookDate")
    List<RegistrationResponse> customFindByDoctorAndBookDateAfter(@Param("doctor") EmployeeEntity doctor, @Param("bookDate") LocalDateTime localDateTime);

    List<RegistrationEntity> findByBookDateBetween(LocalDateTime start, LocalDateTime end);

    Page<RegistrationEntity> findAllRegistrationsByRegistrationStatus(RegistrationStatusEnum status, Pageable pageable);
}
