package com.isaac.pethospital.treatment.services;


import com.isaac.pethospital.common.jms.JmsProperties;
import com.isaac.pethospital.common.jms.JmsSender;
import com.isaac.pethospital.treatment.dtos.RegistrationOperationRequest;
import com.isaac.pethospital.treatment.entities.EmployeeEntity;
import com.isaac.pethospital.treatment.entities.PetEntity;
import com.isaac.pethospital.treatment.entities.RegistrationEntity;
import com.isaac.pethospital.treatment.repositories.EmployeeRepository;
import com.isaac.pethospital.treatment.repositories.PetRepository;
import com.isaac.pethospital.treatment.repositories.RegistrationRepository;
import org.apache.tomcat.jni.Local;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

public class RegistrationServiceSpecTests {

    RegistrationService registrationService;
    RegistrationNumberService registrationNumberService;
    RegistrationRepository registrationRepository;
    EmployeeRepository employeeRepository;
    PetRepository petRepository;
    JmsSender jmsSender;
    JmsProperties jmsProperties;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void before() {
        registrationRepository = mock(RegistrationRepository.class);
        registrationNumberService = mock(RegistrationNumberService.class);
        employeeRepository = mock(EmployeeRepository.class);
        petRepository = mock(PetRepository.class);
        jmsSender = mock(JmsSender.class);
        jmsProperties = mock(JmsProperties.class);

        registrationService = spy(new RegistrationServiceImpl(registrationRepository, employeeRepository, petRepository, registrationNumberService, jmsSender, jmsProperties));
    }

    @Test
    public void whenFindByDoctorAndBookDateAfterThenMethodFindByDoctorAndBookDateAfterInRepositoryIsInvokedOnce() {
        List<RegistrationEntity> list = new LinkedList<>();
        EmployeeEntity doctor = new EmployeeEntity();
        LocalDateTime localDateTime = LocalDateTime.now();

        RegistrationOperationRequest registrationOperationRequest = getRegistrationOperationRequest();
        registrationOperationRequest.setBookDate(localDateTime);
        doReturn(true).when(employeeRepository).exists(20L);
        doReturn(true).when(employeeRepository).exists(10L);
        doReturn(doctor).when(employeeRepository).findOne(20L);
        doReturn(new EmployeeEntity()).when(employeeRepository).findOne(20L);

        //given
        doReturn(list).when(registrationRepository).customFindByDoctorAndBookDateAfter(doctor, localDateTime);
        //when
        this.registrationService.findByDoctorAndBookDateAfter(registrationOperationRequest);
        //then
        verify(registrationRepository, times(1)).customFindByDoctorAndBookDateAfter(any(EmployeeEntity.class), any(LocalDateTime.class));
    }

    @Test
    public void givenRegistrationOperationRequestWhenCreateRegistrationThenThrowExceptionIfDoctoryIsNotFound() {

        RegistrationOperationRequest registrationOperationRequest = getRegistrationOperationRequest();
        doReturn(false).when(employeeRepository).exists(20L);
        exception.expect(RuntimeException.class);
        exception.expectMessage("cannot find employee by id");
        //when
        this.registrationService.createRegistration(registrationOperationRequest);
    }

    @Test
    public void givenRegistrationOperationRequestWhenCreateRegistrationThenThrowExceptionIfOperatorIsNotFound() {

        RegistrationOperationRequest registrationOperationRequest = getRegistrationOperationRequest();
        doReturn(true).when(employeeRepository).exists(20L);
        doReturn(false).when(employeeRepository).exists(10L);
        doReturn(new EmployeeEntity()).when(employeeRepository).findOne(20L);
        exception.expect(RuntimeException.class);
        exception.expectMessage("cannot find employee by id");
        //when
        this.registrationService.createRegistration(registrationOperationRequest);
    }


    @Test
    public void givenRegistrationOperationRequestWhenCreateRegistrationThenDoctorCanBeFoundByDoctorId() {
        RegistrationOperationRequest registrationOperationRequest = getFullRegistrationOperationRequest();
        //when
        this.registrationService.createRegistration(registrationOperationRequest);
        //then
        verify(employeeRepository, times(2)).findOne(any(Long.class));
    }

    private RegistrationOperationRequest getFullRegistrationOperationRequest() {
        RegistrationOperationRequest registrationOperationRequest = getRegistrationOperationRequest();
        doReturn(true).when(employeeRepository).exists(20L);
        doReturn(true).when(employeeRepository).exists(10L);
        doReturn(true).when(petRepository).exists(15L);
        doReturn(new EmployeeEntity()).when(employeeRepository).findOne(20L);
        doReturn(new EmployeeEntity()).when(employeeRepository).findOne(10L);
        doReturn(new PetEntity()).when(petRepository).findOne(15L);
        return registrationOperationRequest;
    }

    @Test
    public void givenRegistrationOperationRequestWhenCreateRegistrationThenPetCanBeFoundByPetId() {
        RegistrationOperationRequest registrationOperationRequest = getFullRegistrationOperationRequest();
        //when
        this.registrationService.createRegistration(registrationOperationRequest);
        //then
        verify(petRepository, times(1)).findOne(any(Long.class));
    }

    @Test
    public void givenRegistrationOperationRequestWhenCreateRegistrationThenThrowIfNotFound() {
        RegistrationOperationRequest registrationOperationRequest = getRegistrationOperationRequest();
        doReturn(true).when(employeeRepository).exists(20L);
        doReturn(true).when(employeeRepository).exists(10L);
        doReturn(false).when(petRepository).exists(15L);
        doReturn(new EmployeeEntity()).when(employeeRepository).findOne(20L);
        doReturn(new EmployeeEntity()).when(employeeRepository).findOne(10L);
        //exception
        exception.expect(RuntimeException.class);
        exception.expectMessage("cannot find pet by id");

        //when
        this.registrationService.createRegistration(registrationOperationRequest);
        //then
        verify(petRepository, times(1)).findOne(any(Long.class));
    }

    @Test
    public void givenFullRegistrationOperationRequestWhenCreateRegistrationThenSaveInRegistrationRepositoryIsInvoked() {
        RegistrationOperationRequest registrationOperationRequest = getFullRegistrationOperationRequest();
        //when
        this.registrationService.createRegistration(registrationOperationRequest);
        //then
        verify(registrationRepository, times(1)).save(any(RegistrationEntity.class));
    }

    private RegistrationOperationRequest getRegistrationOperationRequest() {
        //given
        RegistrationOperationRequest registrationOperationRequest = new RegistrationOperationRequest();
        registrationOperationRequest.setDoctorId(10L);
        registrationOperationRequest.setOperatorId(20L);
        registrationOperationRequest.setPetId(15L);
        return registrationOperationRequest;
    }
}
