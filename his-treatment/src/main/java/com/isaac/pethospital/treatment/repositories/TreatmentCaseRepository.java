package com.isaac.pethospital.treatment.repositories;

import com.isaac.pethospital.treatment.dtos.TreatmentCaseQueryResponse;
import com.isaac.pethospital.treatment.entities.PetEntity;
import com.isaac.pethospital.treatment.entities.TreatmentCaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TreatmentCaseRepository extends JpaRepository<TreatmentCaseEntity, Long> {

    @Query("select t.id as id,t.treatmentDate as treatmentDate, t.createdDate as createdDate, t.clinicSituation as clinicSituation, d.name as doctor from TreatmentCaseEntity t join t.doctor d where t.pet=:pet ")
    List<TreatmentCaseQueryResponse> findTreatmentCaseEntitiesByPet(@Param("pet") PetEntity pet);
}
