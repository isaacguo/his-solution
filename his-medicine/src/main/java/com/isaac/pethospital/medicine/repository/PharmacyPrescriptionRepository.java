package com.isaac.pethospital.medicine.repository;

import com.isaac.pethospital.medicine.entities.PharmacyPrescriptionEntity;
import com.isaac.pethospital.medicine.enums.PrescriptionStatusEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface PharmacyPrescriptionRepository extends JpaRepository<PharmacyPrescriptionEntity,Long> {

    List<PharmacyPrescriptionEntity> findPharmacyPrescriptionEntitiesByPetUuidAndCreatedDateAfter(String petUuid, LocalDateTime time);
    List<PharmacyPrescriptionEntity> findPharmacyPrescriptionEntitiesByPetUuidAndCreatedDateBefore(String petUuid, LocalDateTime time);
    PharmacyPrescriptionEntity findByUuid(String uuid);
    Page<PharmacyPrescriptionEntity> findPharmacyPrescriptionEntitiesByStatus(PrescriptionStatusEnum status, Pageable pageable);


}
