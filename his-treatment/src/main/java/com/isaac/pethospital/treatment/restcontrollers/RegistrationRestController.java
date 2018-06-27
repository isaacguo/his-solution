package com.isaac.pethospital.treatment.restcontrollers;

import com.isaac.pethospital.treatment.dtos.RegistrationOperationRequest;
import com.isaac.pethospital.treatment.dtos.RegistrationResponse;
import com.isaac.pethospital.treatment.entities.EmployeeEntity;
import com.isaac.pethospital.treatment.entities.RegistrationEntity;
import com.isaac.pethospital.treatment.services.EmployeeService;
import com.isaac.pethospital.treatment.services.RegistrationService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("registrations")
public class RegistrationRestController {

    RegistrationService registrationService;
    EmployeeService employeeService;

    public RegistrationRestController(RegistrationService registrationService, EmployeeService employeeService) {
        this.registrationService = registrationService;
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<RegistrationEntity> getRegistrations() {
        return this.registrationService.getRegistrations();
    }

    @PostMapping("create-registration")
    public RegistrationEntity createRegistration(@Valid @RequestBody RegistrationOperationRequest request) {
        return this.registrationService.createRegistration(request);
    }

    @GetMapping("find-my-registration-today")
    public List<RegistrationResponse> findMyRegistrationToday() {
        EmployeeEntity doctor= this.employeeService.findByLoginAccount(getUserAccount());
        RegistrationOperationRequest request=new RegistrationOperationRequest();
        request.setDoctorId(doctor.getId());
        request.setBookDate(LocalDate.now().atStartOfDay());
        return this.registrationService.findByDoctorAndBookDateAfter(request);
    }

    private String getUserAccount() {
        return (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    @PostMapping("find-by-doctor-and-bookdate-after")
    public List<RegistrationResponse> findByDoctorAndBookdateAfter(@Valid @RequestBody RegistrationOperationRequest request) {
        return this.registrationService.findByDoctorAndBookDateAfter(request);
    }


}
