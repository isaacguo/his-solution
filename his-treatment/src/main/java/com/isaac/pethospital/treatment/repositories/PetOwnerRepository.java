package com.isaac.pethospital.treatment.repositories;

import com.isaac.pethospital.treatment.entities.PetEntity;
import com.isaac.pethospital.treatment.entities.PetOwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetOwnerRepository extends JpaRepository<PetOwnerEntity,Long> {

    List<PetOwnerEntity> findByName(String name);
    List<PetOwnerEntity> findByNameContains(String name);
    PetOwnerEntity findByMemberNumber(String s);
    PetOwnerEntity findByPetListContains(PetEntity petEntity);


}
