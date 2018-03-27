package com.isaac.pethospital.treatment.dtos;

import com.isaac.pethospital.treatment.entities.PetOwnerEntity;

public class PetOwnerDeletePetRequest {
    PetOwnerEntity petOwner;
    private long id;

    public PetOwnerEntity getPetOwner() {
        return petOwner;
    }

    public void setPetOwner(PetOwnerEntity petOwner) {
        this.petOwner = petOwner;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
