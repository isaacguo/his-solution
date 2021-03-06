package com.isaac.pethospital.treatment.entities;

import com.isaac.pethospital.common.enums.PetColorEnum;
import com.isaac.pethospital.common.enums.PetGenderEnum;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;

public class PetEntitySpecTests {

    @Test
    public void givenPetEntityHasFieldName() {
        PetEntity petEntity = getPetEntity();
        assertThat(petEntity, hasProperty("name", is("Benben")));
    }

    @Test
    public void givenPetEntityHasFieldGender() {
        PetEntity petEntity = getPetEntity();
        assertThat(petEntity, hasProperty("gender", is(PetGenderEnum.MALE)));
    }

    @Test
    public void givenPetEntityHasFieldDateOfBirth() {
        PetEntity petEntity = getPetEntity();
        assertThat(petEntity, hasProperty("dateOfBirth", is(getDateOfBirth())));
    }

    @Test
    public void givenPetEntityHasFieldAge() {
        PetEntity petEntity = getPetEntity();
        assertThat(petEntity, hasProperty("age", is(2)));
    }

    @Test
    public void givenPetEntityHasFieldColor() {
        PetEntity petEntity = getPetEntity();
        assertThat(petEntity, hasProperty("color", is(PetColorEnum.WHITE)));
    }

    @Test
    public void givenPetEntityHasFieldType() {
        PetEntity petEntity = getPetEntity();
        assertThat(petEntity, hasProperty("petType"));
    }

    @Test
    public void givenPetEntityHasFieldSterilized() {
        PetEntity petEntity = getPetEntity();
        assertThat(petEntity, hasProperty("sterilized",is(false)));
    }

    @Test
    public void givenPetEntityHasFieldTreatmentCaseList() {
        PetEntity petEntity = getPetEntity();
        assertThat(petEntity, hasProperty("treatmentCaseList"));
    }

    private PetEntity getPetEntity() {
        PetEntity petEntity = new PetEntity();
        petEntity.setName("Benben");
        petEntity.setGender(PetGenderEnum.MALE);
        petEntity.setDateOfBirth(getDateOfBirth());
        petEntity.setAge(2);
        petEntity.setColor(PetColorEnum.WHITE);

        PetTypeEntity petType = getPetTypeEntity();
        petEntity.setPetType(petType);
        petEntity.setSterilized(false);
        return petEntity;
    }

    private PetTypeEntity getPetTypeEntity() {
        PetTypeEntity petType=new PetTypeEntity();
        petType.setName("狗");
        return petType;
    }

    private LocalDateTime getDateOfBirth() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateOfBirth = LocalDateTime.parse("1984-02-28 00:00:00", formatter);
        return dateOfBirth;
    }
}
