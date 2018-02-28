package com.isaac.pethospital.treatment.services;

import com.isaac.pethospital.treatment.dtos.PetOwnerAddPetRequest;
import com.isaac.pethospital.treatment.dtos.PetOwnerCreateRequest;
import com.isaac.pethospital.treatment.dtos.PetOwnerDeletePetRequest;
import com.isaac.pethospital.treatment.entities.PetEntity;
import com.isaac.pethospital.treatment.entities.PetOwnerEntity;
import com.isaac.pethospital.treatment.repositories.PetOwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetOwnerServiceImpl implements PetOwnerService {

    PetOwnerRepository petOwnerRepository;

    public PetOwnerServiceImpl(PetOwnerRepository petOwnerRepository) {
        this.petOwnerRepository = petOwnerRepository;
    }

    @Override
    public PetOwnerEntity findByMemberNumber(String memberNumber) {
        return this.petOwnerRepository.findByMemberNumber(memberNumber);
    }

    @Override
    public List<PetOwnerEntity> findByName(String name) {
        return this.petOwnerRepository.findByName(name);
    }

    @Override
    public PetOwnerEntity createPetOwner(PetOwnerCreateRequest petOwnerCreateRequest) {
        PetOwnerEntity petOwnerEntity = petOwnerCreateRequest.toPetOwnerEntity();
        return this.petOwnerRepository.save(petOwnerEntity);
    }

    @Override
    public PetOwnerEntity addPet(PetOwnerAddPetRequest petOwnerAddPetRequest) {
        Long petOwnerId = petOwnerAddPetRequest.getPetOwner().getId();

        if (!this.petOwnerRepository.exists(petOwnerId))
            throw new RuntimeException("Cannot find Pet Owner");

        PetOwnerEntity petOwnerEntity = this.petOwnerRepository.getOne(petOwnerId);
        PetEntity petEntity = petOwnerAddPetRequest.toPetEntity();
        petOwnerEntity.addPet(petEntity);
        return this.petOwnerRepository.save(petOwnerEntity);
    }

    @Override
    public PetOwnerEntity deletePet(PetOwnerDeletePetRequest request) {

        Long petOwnerId = request.getPetOwner().getId();
        if (!this.petOwnerRepository.exists(petOwnerId))
            throw new RuntimeException("Cannot find Pet Owner");

        PetOwnerEntity petOwnerEntity = this.petOwnerRepository.getOne(petOwnerId);
        PetEntity petToBeDeleted = petOwnerEntity.getPetList().stream().filter(r -> r.getId() == request.getId()).findFirst().orElse(null);
        if (petToBeDeleted == null)
            throw new RuntimeException("Cannot find Pet Owner in pet list");
        petOwnerEntity.removePet(petToBeDeleted);

        return this.petOwnerRepository.save(petOwnerEntity);

    }
}
