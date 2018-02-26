package com.isaac.pethospital.treatment.services;

import com.isaac.pethospital.treatment.entities.PetOwnerEntity;

import java.util.List;

public interface PetOwnerService {
    PetOwnerEntity findByMemberNumber(String memberNumber);

    List<PetOwnerEntity> findByName(String name);

    PetOwnerEntity createOwner(PetOwnerEntity petOwnerEntity);
}
