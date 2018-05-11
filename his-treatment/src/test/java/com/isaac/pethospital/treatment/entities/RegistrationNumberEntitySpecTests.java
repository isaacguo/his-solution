package com.isaac.pethospital.treatment.entities;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;

public class RegistrationNumberEntitySpecTests {

    RegistrationNumberEntity registrationNumberEntity;
    EmployeeEntity doctor;
    LocalDate localDate;
    @Before
    public void init() {

        this.localDate = LocalDate.of(2018,3,3);

        registrationNumberEntity = new RegistrationNumberEntity();
        this.doctor = new EmployeeEntity();
        this.doctor.setName("abc");

        registrationNumberEntity.setDoctor(this.doctor);
        registrationNumberEntity.setNumber(10);
        registrationNumberEntity.setDate(this.localDate);
    }

    @Test
    public void givenRegistrationNumberEntityHasFieldCreatedDate() {
        assertThat(registrationNumberEntity, hasProperty("doctor", is(this.doctor)));
    }

    @Test
    public void givenRegistrationNumberEntityHasFieldNumber() {
        assertThat(registrationNumberEntity, hasProperty("number", is(10)));
    }

    @Test
    public void givenRegistrationNumberEntityHasFieldDate() {
        assertThat(registrationNumberEntity, hasProperty("date", is(this.localDate)));
    }
}
