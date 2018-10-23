package com.isaac.pethospital.treatment.services;

import com.isaac.pethospital.common.jms.JmsProperties;
import com.isaac.pethospital.common.jms.JmsSender;
import com.isaac.pethospital.common.jms.treatment.PetRegistrationCreatedMessage;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    private JmsSender jmsSender;
    private JmsProperties jmsProperties;

    public RegistrationServiceImpl(RegistrationRepository registrationRepository,
                                   EmployeeRepository employeeRepository,
                                   PetRepository petRepository,
                                   RegistrationNumberService registrationNumberService,
                                   JmsSender jmsSender,
                                   JmsProperties jmsProperties) {
        this.registrationRepository = registrationRepository;
        this.employeeRepository = employeeRepository;
        this.petRepository = petRepository;
        this.registrationNumberService = registrationNumberService;
        this.jmsSender=jmsSender;
        this.jmsProperties=jmsProperties;
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


        PetRegistrationCreatedMessage message=new PetRegistrationCreatedMessage();
        message.setDoctorUuid(doctor.getUuid());
        message.setName("挂号费");
        message.setPetOwnerUuid(pet.getPetOwner().getUuid());
        message.setPetUuid(pet.getUuid());
        message.setPriceUuid(registrationOperationRequest.getPriceUuid());

        jmsSender.sendEvent(this.jmsProperties.getFinancePetRegistrationCreatedTopic(), message);

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

    @Override
    public Page<RegistrationEntity> findAllRegistrationsByStatusOnPage(RegistrationStatusEnum status, Pageable pageable) {
        return this.registrationRepository.findAllRegistrationsByRegistrationStatus(status, pageable);
    }

    @Override
    public RegistrationEntity getOne(Long id) {
        return this.registrationRepository.findOne(id);
    }

    private EmployeeEntity getEmployeeById(Long employeeId) {
        if (!employeeRepository.exists(employeeId)) {
            throw new RuntimeException("cannot find employee by id");
        }
        return this.employeeRepository.findOne(employeeId);
    }
}
