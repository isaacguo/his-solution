package com.isaac.pethospital.treatment.validators;

import com.isaac.pethospital.treatment.dtos.PetOwnerOperationRequest;
import com.isaac.pethospital.treatment.repositories.PetOwnerRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PetOwnerCreateRequestValidator implements Validator {

    PetOwnerRepository petOwnerRepository;

    public PetOwnerCreateRequestValidator(PetOwnerRepository petOwnerRepository) {
        this.petOwnerRepository = petOwnerRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return PetOwnerOperationRequest.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "PetOwner.Name.Required");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cellPhone", "PetOwner.Name.Required");

    }
}
