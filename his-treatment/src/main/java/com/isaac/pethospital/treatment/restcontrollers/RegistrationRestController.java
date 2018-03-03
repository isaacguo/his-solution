package com.isaac.pethospital.treatment.restcontrollers;

import com.isaac.pethospital.treatment.dtos.RegistrationOperationRequest;
import com.isaac.pethospital.treatment.entities.RegistrationEntity;
import com.isaac.pethospital.treatment.services.RegistrationService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("registrations")
public class RegistrationRestController {

    RegistrationService registrationService;

    public RegistrationRestController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }
    @GetMapping
    public List<RegistrationEntity> getRegistrations()
    {
        return this.registrationService.getRegistrations();
    }

    @PostMapping("create-registration")
    public RegistrationEntity createRegistration(@Valid @RequestBody RegistrationOperationRequest request)
    {
        return this.registrationService.createRegistration(request);
    }

    @PostMapping("find-by-doctor-and-bookdate-after")
    public List<RegistrationEntity> findByDoctorAndBookdateAfter(@Valid @RequestBody RegistrationOperationRequest request)
    {
        return this.registrationService.findByDoctorAndBookDateAfter(request);
    }


}
