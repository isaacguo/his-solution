package com.isaac.pethospital.treatment.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.isaac.pethospital.common.enums.GenderEnum;
import com.isaac.pethospital.common.enums.PetColorEnum;
import com.isaac.pethospital.common.enums.PetGenderEnum;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Entity
public class PetEntity {

    @ManyToOne
    @JsonBackReference("PetOwnerEntity-PetEntity")
    PetOwnerEntity petOwner;
    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL)
    @JsonManagedReference("PetEntity-TreatmentCaseEntity")
    List<TreatmentCaseEntity> treatmentCaseList = new LinkedList<>();
    boolean sterilized;
    PetColorEnum color;
    LocalDateTime dateOfBirth;
    int age;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID uuid;
    private PetGenderEnum gender;
    private String name;
    @ManyToOne
    @JsonBackReference("petType-pet")
    private PetTypeEntity petType;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDateTime getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    public List<TreatmentCaseEntity> getTreatmentCaseList() {
        return treatmentCaseList;
    }

    public void addTreatmentCase(TreatmentCaseEntity treatmentCase) {
        if (treatmentCase == null)
            throw new RuntimeException("treatment case is null");
        treatmentCase.setPet(this);
        this.treatmentCaseList.add(treatmentCase);
    }

    public PetOwnerEntity getPetOwner() {
        return petOwner;
    }

    public void setPetOwner(PetOwnerEntity petOwner) {
        this.petOwner = petOwner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }


    public PetTypeEntity getPetType() {
        return petType;
    }

    public void setPetType(PetTypeEntity petType) {
        this.petType = petType;
    }
}
