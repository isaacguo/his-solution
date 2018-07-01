package com.isaac.pethospital.treatment.services;

import com.isaac.pethospital.treatment.common.enums.RegistrationStatusEnum;
import com.isaac.pethospital.treatment.dtos.RegistrationOperationRequest;
import com.isaac.pethospital.treatment.dtos.RegistrationResponse;
import com.isaac.pethospital.treatment.entities.EmployeeEntity;
import com.isaac.pethospital.treatment.entities.RegistrationEntity;

import java.time.LocalDateTime;
import java.util.List;

public interface RegistrationService {


    List<RegistrationResponse> findByDoctorAndBookDateAfter(RegistrationOperationRequest registrationOperationRequest);

    RegistrationEntity createRegistration(RegistrationOperationRequest registrationOperationRequest);

    List<RegistrationEntity> getRegistrations();

    RegistrationStatusEnum updateStatus(RegistrationOperationRequest request);
}
