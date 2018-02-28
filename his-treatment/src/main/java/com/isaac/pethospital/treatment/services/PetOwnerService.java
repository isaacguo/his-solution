package com.isaac.pethospital.treatment.services;

import com.isaac.pethospital.treatment.dtos.PetOwnerPetOperationRequest;
import com.isaac.pethospital.treatment.dtos.PetOwnerOperationRequest;
import com.isaac.pethospital.treatment.dtos.PetOwnerDeletePetRequest;
import com.isaac.pethospital.treatment.entities.PetOwnerEntity;

import java.util.List;

public interface PetOwnerService {
    PetOwnerEntity findByMemberNumber(String memberNumber);

    List<PetOwnerEntity> findByName(String name);
    PetOwnerEntity createPetOwner(PetOwnerOperationRequest petOwnerOperationRequest);
    PetOwnerEntity addPet(PetOwnerPetOperationRequest petOwnerPetOperationRequest);

    PetOwnerEntity deletePet(PetOwnerDeletePetRequest request);

    PetOwnerEntity updatePetOwner(PetOwnerOperationRequest request);

    PetOwnerEntity updatePet(PetOwnerPetOperationRequest request);
}
