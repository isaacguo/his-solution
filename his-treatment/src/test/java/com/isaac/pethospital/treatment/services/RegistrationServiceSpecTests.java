package com.isaac.pethospital.treatment.services;


import com.isaac.pethospital.treatment.entities.EmployeeEntity;
import com.isaac.pethospital.treatment.entities.PetEntity;
import com.isaac.pethospital.treatment.entities.RegistrationEntity;
import com.isaac.pethospital.treatment.repositories.RegistrationRepository;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class RegistrationServiceSpecTests {

    RegistrationService registrationService;
    RegistrationRepository registrationRepository;

    @Before
    public void before() {
        registrationRepository = mock(RegistrationRepository.class);
        registrationService = spy(new RegistrationServiceImpl(registrationRepository));
    }

    @Test
    public void whenFindByDoctorAndBookDateAfterThenMethodFindByDoctorAndBookDateAfterInRepositoryIsInvokedOnce() {
        List<RegistrationEntity> list = new LinkedList<>();

        EmployeeEntity employeeEntity = new EmployeeEntity();
        LocalDateTime localDateTime = LocalDateTime.now();

        //given
        doReturn(list).when(registrationRepository).findByDoctorAndBookDateAfter(employeeEntity, localDateTime);
        //when
        this.registrationService.findByDoctorAndBookDateAfter(employeeEntity, localDateTime);
        //then
        verify(registrationRepository, times(1)).findByDoctorAndBookDateAfter(employeeEntity, localDateTime);;
    }






}
