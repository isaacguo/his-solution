package com.isaac.pethospital.treatment.entities;

import com.isaac.pethospital.common.enums.GenderEnum;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;

public class PetOwnerEntitySpecTests {

    @Test
    public void givenPetOwnerEntityHasFieldName() {
        PetOwnerEntity petEntity = getPetOwnerEntity();
        assertThat(petEntity, hasProperty("name", is("刘备")));
    }

    @Test
    public void givenPetOwnerEntityHasFieldGender() {
        PetOwnerEntity petEntity = getPetOwnerEntity();
        assertThat(petEntity, hasProperty("gender", is(GenderEnum.MALE)));
    }

    @Test
    public void givenPetOwnerEntityHasFieldDateOfBirth() {
        PetOwnerEntity petEntity = getPetOwnerEntity();
        assertThat(petEntity, hasProperty("dateOfBirth", is(getDateOfBirth())));
    }

    @Test
    public void givenPetOwnerEntityHasFieldCellPhone() {
        PetOwnerEntity petEntity = getPetOwnerEntity();
        assertThat(petEntity, hasProperty("cellPhone", is("1234567")));
    }

    @Test
    public void givenPetOwnerEntityHasFieldHomePhone() {
        PetOwnerEntity petEntity = getPetOwnerEntity();
        assertThat(petEntity, hasProperty("homePhone", is("1234-993")));
    }

    @Test
    public void givenPetOwnerEntityHasFieldEmail() {
        PetOwnerEntity petEntity = getPetOwnerEntity();
        assertThat(petEntity, hasProperty("email", is("isaac@pethos.com")));
    }

    @Test
    public void givenPetOwnerEntityHasFieldExpenseRecordList() {
        PetOwnerEntity petEntity = getPetOwnerEntity();
        assertThat(petEntity, hasProperty("expenseRecordList"));
    }

    @Test
    public void givenPetOwnerEntityHasFieldAddress() {
        PetOwnerEntity petEntity = getPetOwnerEntity();
        assertThat(petEntity, hasProperty("address",is("北京市朝阳区")));
    }

    @Test
    public void givenPetOwnerEntityHasFieldMemberNumber() {
        PetOwnerEntity petEntity = getPetOwnerEntity();
        assertThat(petEntity, hasProperty("memberNumber",is("29291")));
    }


    private PetOwnerEntity getPetOwnerEntity() {
        PetOwnerEntity petOwnerEntity = new PetOwnerEntity();
        petOwnerEntity.setName("刘备");
        petOwnerEntity.setGender(GenderEnum.MALE);
        petOwnerEntity.setDateOfBirth(getDateOfBirth());
        petOwnerEntity.setCellPhone("1234567");
        petOwnerEntity.setEmail("isaac@pethos.com");
        petOwnerEntity.setAddress("北京市朝阳区");
        petOwnerEntity.setHomePhone("1234-993");
        petOwnerEntity.setMemberNumber("29291");
        return petOwnerEntity;
    }

    private LocalDate getDateOfBirth() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDate dateOfBirth = LocalDate.parse("1984-02-28 00:00:00", formatter);
        return dateOfBirth;
    }
}
