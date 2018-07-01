package com.isaac.pethospital.treatment.services;

import com.isaac.pethospital.treatment.common.enums.RegistrationStatusEnum;
import com.isaac.pethospital.treatment.dtos.RegistrationOperationRequest;
import com.isaac.pethospital.treatment.dtos.RegistrationResponse;
import com.isaac.pethospital.treatment.entities.EmployeeEntity;
import com.isaac.pethospital.treatment.entities.PetEntity;
import com.isaac.pethospital.treatment.entities.RegistrationEntity;
import com.isaac.pethospital.treatment.repositories.EmployeeRepository;
import com.isaac.pethospital.treatment.repositories.PetRepository;
import com.isaac.pethospital.treatment.repositories.RegistrationNumberRepository;
import com.isaac.pethospital.treatment.repositories.RegistrationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private RegistrationRepository registrationRepository;
    private EmployeeRepository employeeRepository;
    private PetRepository petRepository;
    private RegistrationNumberService registrationNumberService;

    public RegistrationServiceImpl(RegistrationRepository registrationRepository, EmployeeRepository employeeRepository, PetRepository petRepository, RegistrationNumberService registrationNumberService) {
        this.registrationRepository = registrationRepository;
        this.employeeRepository = employeeRepository;
        this.petRepository = petRepository;
        this.registrationNumberService = registrationNumberService;
    }

    @Override
    public List<RegistrationResponse> findByDoctorAndBookDateAfter(RegistrationOperationRequest registrationOperationRequest) {
        EmployeeEntity doctor = getEmployeeById(registrationOperationRequest.getDoctorId());
        return this.findByDoctorAndBookDateAfter(doctor, registrationOperationRequest.getBookDate());
    }

    public List<RegistrationResponse> findByDoctorAndBookDateAfter(EmployeeEntity employeeEntity, LocalDateTime localDateTime) {
        return this.registrationRepository.customFindByDoctorAndBookDateAfter(employeeEntity, localDateTime);
    }

    @Override
    public RegistrationEntity createRegistration(RegistrationOperationRequest registrationOperationRequest) {
        EmployeeEntity doctor = getEmployeeById(registrationOperationRequest.getDoctorId());
        EmployeeEntity operator = getEmployeeById(registrationOperationRequest.getOperatorId());
        if (!petRepository.exists(registrationOperationRequest.getPetId()))
            throw new RuntimeException("cannot find pet by id");
        PetEntity pet = this.petRepository.findOne(registrationOperationRequest.getPetId());

        int indexOfDay = this.registrationNumberService.getNumber(doctor, LocalDate.now());

        RegistrationEntity registrationEntity = registrationOperationRequest.toRegistrationEntity(doctor, operator, pet);
        registrationEntity.setCreatedDate(LocalDateTime.now());
        registrationEntity.setBookDate(LocalDateTime.now());
        registrationEntity.setIndexOfDay(indexOfDay);
        RegistrationEntity res = this.registrationRepository.save(registrationEntity);
        return res;
    }

    @Override
    public List<RegistrationEntity> getRegistrations() {
        return this.registrationRepository.findAll();
    }

    @Override
    public RegistrationStatusEnum updateStatus(RegistrationOperationRequest request) {

        RegistrationEntity registration = this.registrationRepository.findOne(request.getId());
        if(registration==null)
            throw new RuntimeException("Cannot find Registration");

        registration.setRegistrationStatus(request.getRegistrationStatus());
        this.registrationRepository.save(registration);
        return registration.getRegistrationStatus();

    }

    private EmployeeEntity getEmployeeById(Long employeeId) {
        if (!employeeRepository.exists(employeeId)) {
            throw new RuntimeException("cannot find employee by id");
        }
        return this.employeeRepository.findOne(employeeId);
    }
}
