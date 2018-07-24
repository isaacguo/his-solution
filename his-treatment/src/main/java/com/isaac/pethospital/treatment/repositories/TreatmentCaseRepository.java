package com.isaac.pethospital.treatment.repositories;

import com.isaac.pethospital.treatment.dtos.TreatmentCaseQueryResponse;
import com.isaac.pethospital.treatment.entities.PetEntity;
import com.isaac.pethospital.treatment.entities.TreatmentCaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface TreatmentCaseRepository extends JpaRepository<TreatmentCaseEntity, Long> {


    @Query("select t.doctorAdvice as doctorAdvice," +
            " t.petOwnerDescription as petOwnerDescription," +
            " t.doctorDiagnose as doctorDiagnose," +
            " t.id as id," +
            " t.treatmentDate as treatmentDate," +
            " t.createdDate as createdDate," +
            " t.lastModifiedDateTime as lastModifiedDateTime," +
            " t.clinicSituation as clinicSituation," +
            " d.name as doctor from TreatmentCaseEntity t join t.doctor d where t.pet=:pet ")
    List<TreatmentCaseQueryResponse> customFindTreatmentCaseEntitiesByPet(@Param("pet") PetEntity pet);

    TreatmentCaseEntity findByUuid(String uuid);
}
