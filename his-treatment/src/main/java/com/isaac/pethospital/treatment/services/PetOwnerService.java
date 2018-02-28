package com.isaac.pethospital.treatment.services;

import com.isaac.pethospital.treatment.dtos.PetOwnerAddPetRequest;
import com.isaac.pethospital.treatment.dtos.PetOwnerCreateRequest;
import com.isaac.pethospital.treatment.dtos.PetOwnerDeletePetRequest;
import com.isaac.pethospital.treatment.entities.PetEntity;
import com.isaac.pethospital.treatment.entities.PetOwnerEntity;

import java.util.List;

public interface PetOwnerService {
    PetOwnerEntity findByMemberNumber(String memberNumber);

    List<PetOwnerEntity> findByName(String name);
    PetOwnerEntity createPetOwner(PetOwnerCreateRequest petOwnerCreateRequest);
    PetOwnerEntity addPet(PetOwnerAddPetRequest petOwnerAddPetRequest);

    PetOwnerEntity deletePet(PetOwnerDeletePetRequest request);
}
