package com.isaac.pethospital.treatment.services;

import com.isaac.pethospital.treatment.entities.EmployeeEntity;
import com.isaac.pethospital.treatment.entities.RegistrationEntity;
import com.isaac.pethospital.treatment.repositories.RegistrationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private RegistrationRepository registrationRepository;

    public RegistrationServiceImpl(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    @Override
    public List<RegistrationEntity> findByDoctorAndBookDateAfter(EmployeeEntity employeeEntity, LocalDateTime localDateTime) {
        return this.registrationRepository.findByDoctorAndBookDateAfter(employeeEntity,localDateTime);
    }
}
