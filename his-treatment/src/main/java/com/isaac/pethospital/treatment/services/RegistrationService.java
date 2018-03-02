package com.isaac.pethospital.treatment.services;

import com.isaac.pethospital.treatment.dtos.RegistrationOperationRequest;
import com.isaac.pethospital.treatment.entities.EmployeeEntity;
import com.isaac.pethospital.treatment.entities.RegistrationEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface RegistrationService {


    List<RegistrationEntity> findByDoctorAndBookDateAfter(RegistrationOperationRequest registrationOperationRequest);

    RegistrationEntity createRegistration(RegistrationOperationRequest registrationOperationRequest);
}
