package com.isaac.pethospital.treatment.dtos;

import com.isaac.pethospital.common.enums.PetGenderEnum;
import com.isaac.pethospital.treatment.entities.PetEntity;
import com.isaac.pethospital.treatment.entities.PetOwnerEntity;

import java.time.LocalDate;

public class PetOwnerPetOperationRequest {

    private Long id;
    private PetOwnerEntity petOwner;
    private boolean sterilized;
    private String color;
    private LocalDate dateOfBirth;
    private int age;
    private PetGenderEnum gender;
    private String name;
    private String petType;
    private String species;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
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

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
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
        petEntity.setSpecies(this.species);
        return petEntity;
    }
}
