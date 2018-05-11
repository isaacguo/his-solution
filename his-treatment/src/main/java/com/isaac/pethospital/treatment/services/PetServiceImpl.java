package com.isaac.pethospital.treatment.services;

import com.isaac.pethospital.treatment.dtos.PetOperationRequest;
import com.isaac.pethospital.treatment.entities.PetEntity;
import com.isaac.pethospital.treatment.entities.PetOwnerEntity;
import com.isaac.pethospital.treatment.repositories.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    PetRepository petRepository;

    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public List<PetEntity> findByName(String name) {
        return this.petRepository.findByName(name);
    }

    @Override
    public PetOwnerEntity findPetOwnerByPet(PetOperationRequest request) {
        PetEntity petEntity=this.petRepository.findOne(request.getId());
        if(petEntity==null)
            throw new RuntimeException("Pet doesn't exist");
        return petEntity.getPetOwner();
    }
}
