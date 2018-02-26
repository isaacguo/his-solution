package com.isaac.pethospital.treatment.services;

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
    public PetOwnerEntity createOwner(PetOwnerEntity petOwnerEntity) {
        return this.petOwnerRepository.save(petOwnerEntity);
    }
}
