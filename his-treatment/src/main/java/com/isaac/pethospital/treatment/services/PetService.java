package com.isaac.pethospital.treatment.services;

import com.isaac.pethospital.treatment.dtos.PetOperationRequest;
import com.isaac.pethospital.treatment.entities.PetEntity;
import com.isaac.pethospital.treatment.entities.PetOwnerEntity;

import java.util.List;

public interface PetService {
    List<PetEntity> findByName(String name);

    PetOwnerEntity findPetOwnerByPet(PetOperationRequest request);
}
