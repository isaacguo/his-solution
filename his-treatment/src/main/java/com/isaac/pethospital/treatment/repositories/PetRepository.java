package com.isaac.pethospital.treatment.repositories;

import com.isaac.pethospital.treatment.dtos.PetQueryResponse;
import com.isaac.pethospital.treatment.entities.PetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface PetRepository extends JpaRepository<PetEntity, Long> {
    List<PetEntity> findByName(String name);

    @Query("select p.name as petName, o.name as petOwnerName from PetEntity p join p.petOwner o where p.uuid=:uuid")
    PetQueryResponse findByUuid(@Param("uuid") String uuid);


    @Query("select p.name as petName, p.uuid as petUuid, o.name as petOwnerName from PetEntity p join p.petOwner o where p.uuid in (:uuids)")
    List<PetQueryResponse> findByUuidIn(@Param("uuids") Set<String> uuids);
}
