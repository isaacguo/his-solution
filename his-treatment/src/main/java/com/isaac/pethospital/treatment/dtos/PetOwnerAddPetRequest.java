package com.isaac.pethospital.treatment.dtos;

import com.isaac.pethospital.common.enums.PetColorEnum;
import com.isaac.pethospital.common.enums.PetGenderEnum;
import com.isaac.pethospital.treatment.entities.PetEntity;
import com.isaac.pethospital.treatment.entities.PetOwnerEntity;
import com.isaac.pethospital.treatment.entities.PetTypeEntity;

import java.time.LocalDateTime;

public class PetOwnerAddPetRequest {

    private PetOwnerEntity petOwner;
    private boolean sterilized;
    private PetColorEnum color;
    private LocalDateTime dateOfBirth;
    private int age;
    private PetGenderEnum gender;
    private String name;
    private PetTypeEntity petType;

    public PetOwnerEntity getPetOwner() {
        return petOwner;
    }

    public void setPetOwner(PetOwnerEntity petOwner) {
        this.petOwner = petOwner;
    }

    public boolean isSterilized() {
        return sterilized;
    }

    public void setSterilized(boolean sterilized) {
        this.sterilized = sterilized;
    }

    public PetColorEnum getColor() {
        return color;
    }

    public void setColor(PetColorEnum color) {
        this.color = color;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public PetGenderEnum getGender() {
        return gender;
    }

    public void setGender(PetGenderEnum gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PetTypeEntity getPetType() {
        return petType;
    }

    public void setPetType(PetTypeEntity petType) {
        this.petType = petType;
    }

    public PetEntity toPetEntity() {
        PetEntity petEntity=new PetEntity();
        petEntity.setSterilized(this.sterilized);
        petEntity.setPetType(this.petType);
        petEntity.setName(this.name);
        petEntity.setAge(this.age);
        petEntity.setColor(this.color);
        petEntity.setDateOfBirth(this.dateOfBirth);
        petEntity.setGender(this.gender);
        return petEntity;
    }
}
