package com.isaac.pethospital.treatment.services;

import com.isaac.pethospital.treatment.dtos.RegistrationOperationRequest;
import com.isaac.pethospital.treatment.entities.EmployeeEntity;
import com.isaac.pethospital.treatment.entities.PetEntity;
import com.isaac.pethospital.treatment.entities.RegistrationEntity;
import com.isaac.pethospital.treatment.repositories.EmployeeRepository;
import com.isaac.pethospital.treatment.repositories.PetRepository;
import com.isaac.pethospital.treatment.repositories.RegistrationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private RegistrationRepository registrationRepository;
    private EmployeeRepository employeeRepository;
    private PetRepository petRepository;

    public RegistrationServiceImpl(RegistrationRepository registrationRepository, EmployeeRepository employeeRepository, PetRepository petRepository) {
        this.registrationRepository = registrationRepository;
        this.employeeRepository = employeeRepository;
        this.petRepository = petRepository;
    }

    @Override
    public List<RegistrationEntity> findByDoctorAndBookDateAfter(RegistrationOperationRequest registrationOperationRequest) {
        EmployeeEntity doctor = getEmployeeById(registrationOperationRequest.getDoctorId());
        return this.findByDoctorAndBookDateAfter(doctor, registrationOperationRequest.getBookDate());
    }

    public List<RegistrationEntity> findByDoctorAndBookDateAfter(EmployeeEntity employeeEntity, LocalDateTime localDateTime) {
        return this.registrationRepository.findByDoctorAndBookDateAfter(employeeEntity, localDateTime);
    }

    @Override
    public RegistrationEntity createRegistration(RegistrationOperationRequest registrationOperationRequest) {
        EmployeeEntity doctor = getEmployeeById(registrationOperationRequest.getDoctorId());
        EmployeeEntity operator = getEmployeeById(registrationOperationRequest.getOperatorId());
        if (!petRepository.exists(registrationOperationRequest.getPetId()))
            throw new RuntimeException("cannot find pet by id");
        PetEntity pet = this.petRepository.findOne(registrationOperationRequest.getPetId());

        RegistrationEntity registrationEntity = registrationOperationRequest.toRegistrationEntity(doctor, operator, pet);
        registrationEntity.setCreatedDate(LocalDateTime.now());
        registrationEntity.setBookDate(LocalDateTime.now());
        return this.registrationRepository.save(registrationEntity);

    }

    @Override
    public List<RegistrationEntity> getRegistrations() {
        return this.registrationRepository.findAll();
    }

    private EmployeeEntity getEmployeeById(Long employeeId) {
        if (!employeeRepository.exists(employeeId)) {
            throw new RuntimeException("cannot find employee by id");
        }
        return this.employeeRepository.findOne(employeeId);
    }
}
