package com.isaac.pethospital.treatment.entities;

import com.isaac.pethospital.treatment.common.enums.RegistrationStatusEnum;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;

public class RegistrationEntityTests {

    PetEntity petEntity;
    EmployeeEntity doctor;
    EmployeeEntity operator;

    RegistrationEntity registrationEntity;
    LocalDateTime localDateTime;
    Long price = new Long(30L);


    @Before
    public void init() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.localDateTime = LocalDateTime.parse("2018-02-28 00:00:00", formatter);

        this.doctor = new EmployeeEntity();
        this.doctor.setName("岳不群");
        this.operator = new EmployeeEntity();
        this.operator.setName("东方不败");
        petEntity = new PetEntity();
        petEntity.setName("笨笨");
        this.registrationEntity = new RegistrationEntity();

        registrationEntity.setCreatedDate(this.localDateTime);
        registrationEntity.setBookDate(this.localDateTime);
        registrationEntity.setPet(petEntity);
        registrationEntity.setDoctor(this.doctor);
        registrationEntity.setOperator(this.operator);
        registrationEntity.setPrice(this.price);
        registrationEntity.setIndexOfDay(1);
        registrationEntity.setRegistrationStatus(RegistrationStatusEnum.CALLED);
    }

    @Test
    public void givenRegistrationEntityHasFieldCreatedDate() {
        assertThat(registrationEntity, hasProperty("createdDate", is(this.localDateTime)));
    }
    @Test
    public void givenRegistrationEntityHasFieldRegistrationStatus() {
        assertThat(registrationEntity, hasProperty("registrationStatus", is(RegistrationStatusEnum.CALLED)));
    }

    @Test
    public void givenRegistrationEntityThenHasFieldBookDate() {
        assertThat(registrationEntity, hasProperty("bookDate", is(this.localDateTime)));
    }

    @Test
    public void givenRegistrationEntityThenHasFieldPet() {
        assertThat(registrationEntity, hasProperty("pet", is(this.petEntity)));
    }


    @Test
    public void givenRegistrationEntityThenHasFieldDoctor() {
        assertThat(registrationEntity, hasProperty("doctor", is(this.doctor)));
    }

    @Test
    public void givenRegistrationEntityThenHasFieldOperator() {
        assertThat(registrationEntity, hasProperty("operator", is(this.operator)));
    }

    @Test
    public void givenRegistrationEntityThenHasFieldPrice() {
        assertThat(registrationEntity, hasProperty("price", is(price)));
    }

    @Test
    public void givenRegistrationEntityThenHasFieldIndexOfDay() {
        assertThat(registrationEntity, hasProperty("indexOfDay", is(1)));
    }
}


