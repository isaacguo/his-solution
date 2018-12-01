package com.isaac.pethospital.treatment.restcontrollers;

import com.isaac.pethospital.treatment.dtos.NameQuery;
import com.isaac.pethospital.treatment.dtos.PetOperationRequest;
import com.isaac.pethospital.treatment.dtos.PetQueryResponse;
import com.isaac.pethospital.treatment.dtos.PetUuidRequest;
import com.isaac.pethospital.treatment.entities.PetEntity;
import com.isaac.pethospital.treatment.entities.PetOwnerEntity;
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

    @GetMapping("{id}")
    public PetEntity findOne(@PathVariable("id") Long id)
    {
        return this.petService.findOne(id);
    }

    @PostMapping(value = "find-by-name")
    public List<PetEntity> findByName(@RequestBody NameQuery nameQuery) {
        return this.petService.findByName(nameQuery.getName());
    }

    @PostMapping(value = "find-pet-owner")
    public PetOwnerEntity findPetOwnerByPet(@RequestBody PetOperationRequest request) {

        return this.petService.findPetOwnerByPet(request);
    }

    @GetMapping(value = "find-by-uuid/{uuid}/")
    public PetQueryResponse findByUuid(@PathVariable("uuid") String uuid) {
        return this.petService.findByUuid(uuid);
    }

    @PostMapping(value = "find-by-uuids")
    public List<PetQueryResponse> findByUuids(@RequestBody List<PetUuidRequest> requestArr) {
        return this.petService.findByUuids(requestArr);
    }

}
