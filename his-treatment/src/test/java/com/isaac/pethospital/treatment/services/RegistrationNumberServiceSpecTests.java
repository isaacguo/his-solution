package com.isaac.pethospital.treatment.services;

import com.isaac.pethospital.treatment.entities.EmployeeEntity;
import com.isaac.pethospital.treatment.entities.EmployeeTypeEntity;
import com.isaac.pethospital.treatment.entities.RegistrationNumberEntity;
import com.isaac.pethospital.treatment.repositories.EmployeeRepository;
import com.isaac.pethospital.treatment.repositories.RegistrationNumberRepository;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.*;

public class RegistrationNumberServiceSpecTests {

    RegistrationNumberService registrationNumberService;
    RegistrationNumberRepository registrationNumberRepository;
    RegistrationNumberEntity registrationNumberEntity;
    EmployeeEntity doctor;

    LocalDate date;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void before() {

        doctor=new EmployeeEntity();
        this.date = LocalDate.of(2018, 3, 1);


        registrationNumberRepository = mock(RegistrationNumberRepository.class);
        registrationNumberService = spy(new RegistrationNumberServiceImpl(registrationNumberRepository));
    }

    @Test
    public void givenDoctorAndDateWhenGetNumberThenCreateANewEntityIfNotExist() {
        //given
        doReturn(null).when(registrationNumberRepository).findByDoctorAndDate(doctor, date);
        //when
        int indexOfDay = this.registrationNumberService.getNumber(doctor, LocalDate.of(2018, 3, 1));
        //then
        verify(registrationNumberRepository, times(1)).save(any(RegistrationNumberEntity.class));
        assertThat(indexOfDay).isEqualTo(1);
    }

    @Test
    public void givenEntityExistedAlreadyWhenGetNumberThenUpdateNumber()
    {
        //given
        registrationNumberEntity = new RegistrationNumberEntity();
        registrationNumberEntity.setNumber(2);
        registrationNumberEntity.setDate(this.date);
        registrationNumberEntity.setDoctor(this.doctor);


        doReturn(registrationNumberEntity).when(registrationNumberRepository).findByDoctorAndDate(doctor, date);
        //when
        int indexOfDay = this.registrationNumberService.getNumber(doctor, LocalDate.of(2018, 3, 1));
        //then
        verify(registrationNumberRepository, times(1)).save(any(RegistrationNumberEntity.class));
        assertThat(indexOfDay).isEqualTo(3);

    }


}
