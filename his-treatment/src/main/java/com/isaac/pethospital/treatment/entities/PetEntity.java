package com.isaac.pethospital.treatment.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Entity
public class PetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private UUID uuid;

    @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL)
    @JsonManagedReference("pet-petCase")
    List<PetCaseEntity> petCaseList = new LinkedList<>();

    private String petName;
    private String ownerName;

    @ManyToOne
    @JsonBackReference("petType-pet")
    private PetTypeEntity petType;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public List<PetCaseEntity> getPetCaseList() {
        return petCaseList;
    }

    public void addPetCase(PetCaseEntity petCase) {
        if (petCase == null) throw new RuntimeException("PetCase is null");
        petCase.setPet(this);
        this.petCaseList.add(petCase);
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public PetTypeEntity getPetType() {
        return petType;
    }

    public void setPetType(PetTypeEntity petType) {
        this.petType = petType;
    }
}
