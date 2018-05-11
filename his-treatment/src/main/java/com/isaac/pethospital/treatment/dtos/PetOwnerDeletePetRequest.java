package com.isaac.pethospital.treatment.dtos;

import com.isaac.pethospital.treatment.entities.PetOwnerEntity;

public class PetOwnerDeletePetRequest {
    PetOwnerEntity petOwner;
    private Long id;

    public PetOwnerEntity getPetOwner() {
        return petOwner;
    }

    public void setPetOwner(PetOwnerEntity petOwner) {
        this.petOwner = petOwner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
