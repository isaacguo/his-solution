package com.isaac.pethospital.treatment.restcontrollers;

import com.isaac.pethospital.treatment.dtos.NameQuery;
import com.isaac.pethospital.treatment.dtos.PetOperationRequest;
import com.isaac.pethospital.treatment.entities.PetEntity;
import com.isaac.pethospital.treatment.entities.PetOwnerEntity;
import com.isaac.pethospital.treatment.services.PetService;
import com.isaac.pethospital.treatment.services.PetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pets")
public class PetRestController {

    PetService petService;

    public PetRestController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping(value = "find-by-name")
    public List<PetEntity> findByName(@RequestBody NameQuery nameQuery)
    {
        return this.petService.findByName(nameQuery.getName());
    }

    @PostMapping(value = "find-pet-owner")
    public PetOwnerEntity findPetOwnerByPet(@RequestBody PetOperationRequest request)
    {
        return this.petService.findPetOwnerByPet(request);
    }
}
