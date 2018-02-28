package com.isaac.pethospital.treatment.services;

import com.isaac.pethospital.treatment.dtos.PetOwnerPetOperationRequest;
import com.isaac.pethospital.treatment.dtos.PetOwnerOperationRequest;
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
    public PetOwnerEntity createPetOwner(PetOwnerOperationRequest petOwnerOperationRequest) {
        PetOwnerEntity petOwnerEntity = petOwnerOperationRequest.toPetOwnerEntity();
        return this.petOwnerRepository.save(petOwnerEntity);
    }

    @Override
    public PetOwnerEntity updatePetOwner(PetOwnerOperationRequest request) {
        Long petOwnerId = request.getId();
        if (petOwnerId == null || petOwnerId == 0L)
            throw new RuntimeException("Pet Owner Id Should Not Be Zero");
        if (!this.petOwnerRepository.exists(petOwnerId))
            throw new RuntimeException("Pet Owner Cannot Be Found.");
        PetOwnerEntity petOwnerEntity = this.petOwnerRepository.getOne(petOwnerId);

        updatePetOwner(request, petOwnerEntity);

        return this.petOwnerRepository.save(petOwnerEntity);
    }

    @Override
    public PetOwnerEntity updatePet(PetOwnerPetOperationRequest request) {
        Long petId = request.getId();
        if (petId == null || petId == 0L)
            throw new RuntimeException("Pet Id Should Not Be Zero");
        if (request.getPetOwner() == null || request.getPetOwner().getId() == 0)
            throw new RuntimeException("Pet Owner Id Should Not Be Zero");
        if (!this.petOwnerRepository.exists(request.getPetOwner().getId()))
            throw new RuntimeException("Pet Owner Cannot Be Found.");

        PetOwnerEntity petOwnerEntity = this.petOwnerRepository.getOne(request.getPetOwner().getId());

        PetEntity petToBeUpdated = petOwnerEntity.getPetList().stream().filter(r -> r.getId() == request.getId()).findFirst().orElse(null);
        if (petToBeUpdated == null)
            throw new RuntimeException("Cannot find Pet Owner in pet list");

        petToBeUpdated.setDateOfBirth(request.getDateOfBirth());
        petToBeUpdated.setGender(request.getGender());
        petToBeUpdated.setColor(request.getColor());
        petToBeUpdated.setAge(request.getAge());
        petToBeUpdated.setName(request.getName());
        petToBeUpdated.setPetType(request.getPetType());
        petToBeUpdated.setSterilized(request.isSterilized());

        return this.petOwnerRepository.save(petOwnerEntity);
    }

    private void updatePetOwner(PetOwnerOperationRequest request, PetOwnerEntity petOwnerEntity) {
        petOwnerEntity.setHomePhone(request.getHomePhone());
        petOwnerEntity.setGender(request.getGender());
        petOwnerEntity.setEmail(request.getEmail());
        petOwnerEntity.setDateOfBirth(request.getDateOfBirth());
        petOwnerEntity.setCellPhone(request.getCellPhone());
        petOwnerEntity.setAddress(request.getAddress());
        petOwnerEntity.setName(request.getName());
    }

    @Override
    public PetOwnerEntity addPet(PetOwnerPetOperationRequest petOwnerPetOperationRequest) {
        Long petOwnerId = petOwnerPetOperationRequest.getPetOwner().getId();

        if (!this.petOwnerRepository.exists(petOwnerId))
            throw new RuntimeException("Cannot find Pet Owner");

        PetOwnerEntity petOwnerEntity = this.petOwnerRepository.getOne(petOwnerId);
        PetEntity petEntity = petOwnerPetOperationRequest.toPetEntity();
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
