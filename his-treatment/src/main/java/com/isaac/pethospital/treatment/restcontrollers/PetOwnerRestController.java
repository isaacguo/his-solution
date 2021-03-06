package com.isaac.pethospital.treatment.restcontrollers;

import com.isaac.pethospital.treatment.dtos.NameQuery;
import com.isaac.pethospital.treatment.dtos.PetOwnerPetOperationRequest;
import com.isaac.pethospital.treatment.dtos.PetOwnerOperationRequest;
import com.isaac.pethospital.treatment.dtos.PetOwnerDeletePetRequest;
import com.isaac.pethospital.treatment.entities.PetOwnerEntity;
import com.isaac.pethospital.treatment.services.PetOwnerService;
import com.isaac.pethospital.treatment.validators.PetOwnerCreateRequestValidator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("owners")
public class PetOwnerRestController {

    PetOwnerService petOwnerService;
    PetOwnerCreateRequestValidator petOwnerCreateRequestValidator;

    public PetOwnerRestController(PetOwnerService petOwnerService, PetOwnerCreateRequestValidator petOwnerCreateRequestValidator) {
        this.petOwnerService = petOwnerService;
        this.petOwnerCreateRequestValidator = petOwnerCreateRequestValidator;
    }

    @InitBinder("petOwnerCreateRequest")
    public void setupBinder(WebDataBinder binder) {
        binder.addValidators(petOwnerCreateRequestValidator);
    }


    @GetMapping(value = "find-by-member-number/{memberNumber}")
    public PetOwnerEntity findByMemberNumber(@PathVariable("memberNumber") String memberNumber)
    {
        return this.petOwnerService.findByMemberNumber(memberNumber);
    }

    @PostMapping(value = "create-pet-owner")
    public PetOwnerEntity createPetOwner(@Valid @RequestBody PetOwnerOperationRequest petOwnerOperationRequest)
    {
        return this.petOwnerService.createPetOwner(petOwnerOperationRequest);
    }

    @PutMapping(value = "update-pet-owner")
    public PetOwnerEntity updatePetOwner(@Valid @RequestBody PetOwnerOperationRequest petOwnerOperationRequest)
    {
        return this.petOwnerService.updatePetOwner(petOwnerOperationRequest);
    }


    @DeleteMapping(value = "delete-pet")
    public PetOwnerEntity deletePet(@RequestBody PetOwnerDeletePetRequest petOwnerDeletePetRequest)
    {
        return this.petOwnerService.deletePet(petOwnerDeletePetRequest);
    }

    @PostMapping(value = "add-pet")
    public PetOwnerEntity addPet(@Valid @RequestBody PetOwnerPetOperationRequest petOwnerPetOperationRequest)
    {
        return this.petOwnerService.addPet(petOwnerPetOperationRequest);
    }

    @PutMapping(value = "update-pet")
    public PetOwnerEntity updatePet(@Valid @RequestBody PetOwnerPetOperationRequest petOwnerPetOperationRequest)
    {
        return this.petOwnerService.updatePet(petOwnerPetOperationRequest);
    }



    @PostMapping(value = "find-by-name")
    public List<PetOwnerEntity> findByName(@RequestBody NameQuery nameQuery)
    {
        return this.petOwnerService.findByName(nameQuery.getName());
    }



}
