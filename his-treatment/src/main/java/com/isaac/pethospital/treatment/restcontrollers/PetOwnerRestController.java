package com.isaac.pethospital.treatment.restcontrollers;

import com.isaac.pethospital.treatment.dtos.NameQuery;
import com.isaac.pethospital.treatment.entities.PetOwnerEntity;
import com.isaac.pethospital.treatment.services.PetOwnerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("owners")
public class PetOwnerRestController {

    PetOwnerService petOwnerService;

    public PetOwnerRestController(PetOwnerService petOwnerService) {
        this.petOwnerService = petOwnerService;
    }

    @GetMapping(value = "find-by-member-number/{memberNumber}")
    public PetOwnerEntity findByMemberNumber(@PathVariable("memberNumber") String memberNumber)
    {
        return this.petOwnerService.findByMemberNumber(memberNumber);
    }

    @PostMapping(value = "find-by-name")
    public List<PetOwnerEntity> findByName(@RequestBody NameQuery nameQuery)
    {
        return this.petOwnerService.findByName(nameQuery.getName());
    }



}
